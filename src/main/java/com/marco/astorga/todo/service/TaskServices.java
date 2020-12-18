package com.marco.astorga.todo.service;

import java.util.List;

import com.marco.astorga.todo.dto.GetTaskDTO;
import com.marco.astorga.todo.dto.TaskDTO;
import com.marco.astorga.todo.dto.UpdateTaskDTO;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TaskServices {
    

    public ResponseEntity<?> addtask(TaskDTO task);
    public List<GetTaskDTO> getByPage(Pageable pageable,  String name);
    public ResponseEntity<?> updateTask(UpdateTaskDTO updateTaskDTO);

    
}