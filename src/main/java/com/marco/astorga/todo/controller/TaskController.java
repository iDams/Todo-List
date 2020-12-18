package com.marco.astorga.todo.controller;

import java.util.List;

import com.marco.astorga.todo.dto.GetTaskDTO;
import com.marco.astorga.todo.dto.TaskDTO;
import com.marco.astorga.todo.dto.UpdateTaskDTO;
import com.marco.astorga.todo.entity.Task;
import com.marco.astorga.todo.service.impl.TaskServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Value("${TOKEN}")
    String _TOKEN;

    @Autowired
    TaskServicesImpl taskServicesImpl;

    @PutMapping("/addtask")
    public ResponseEntity<?> addTask(@RequestBody TaskDTO taskDTO) {

        String headerToken = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
        .getHeader("Authorization");
 
        if (headerToken == null || !headerToken.equals(_TOKEN) ) {
            return new ResponseEntity<Object>("¡Token Invalid!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(taskServicesImpl.addtask(taskDTO));

    }

    @GetMapping(value = "/alltask")
    public ResponseEntity<?> allTask(Pageable pageable, String name) {
        String headerToken = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
        .getHeader("Authorization");
 
        if (headerToken == null || !headerToken.equals(_TOKEN) ) {
            return new ResponseEntity<Object>("¡Token Invalid!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(taskServicesImpl.getByPage(pageable, name));

    }

    @PostMapping("/updatetask")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskDTO updateTaskDTO) {
        String headerToken = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
        .getHeader("Authorization");
 
        if (headerToken == null || !headerToken.equals(_TOKEN) ) {
            return new ResponseEntity<Object>("¡Token Invalid!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(taskServicesImpl.updateTask(updateTaskDTO));
       
    }

}