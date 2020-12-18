package com.marco.astorga.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.marco.astorga.todo.dto.GetTaskDTO;
import com.marco.astorga.todo.dto.TaskDTO;
import com.marco.astorga.todo.dto.UpdateTaskDTO;
import com.marco.astorga.todo.entity.Task;
import com.marco.astorga.todo.entity.User;
import com.marco.astorga.todo.repository.TaskRepository;
import com.marco.astorga.todo.repository.UserRepository;
import com.marco.astorga.todo.service.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service()
public class TaskServicesImpl implements TaskServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public ResponseEntity<?> addtask(TaskDTO taskDTO) {

        User user = userRepository.findByUsername(taskDTO.getusername());
        Task task = new Task();

        task.setUser(user);
        task.setName(taskDTO.getName());
        task.setStatus(false);
        task.setDescription(taskDTO.getDescription());
        taskRepository.save(task);

        return new ResponseEntity<Object>("Task Create", HttpStatus.OK);
    }

    @Override
    public List<GetTaskDTO> getByPage(Pageable pageable, String name) {
        User user = userRepository.findByUsername(name);
        List<GetTaskDTO> GetTaskList = new ArrayList<>();
        List<Task> task = taskRepository.findAllByuser_id(pageable, user.getId()).getContent();
        for (Task t : task) {
            GetTaskDTO getTask = new GetTaskDTO();
            getTask.setId(t.getId());
            getTask.setName(t.getName());
            getTask.setDescription(t.getDescription());
            if (!t.getStatus()) {
                getTask.setStatus("No Resuelto");
            } else {
                getTask.setStatus("Resuelto");
            }

            GetTaskList.add(getTask);
        }

        return GetTaskList;
    }

    @Override
    public ResponseEntity<?> updateTask(UpdateTaskDTO updateTaskDTO) {
        Task task = taskRepository.findById(updateTaskDTO.getId()).orElseThrow(() -> new IllegalStateException("id no existe."));
        task.setStatus(updateTaskDTO.getStatus());
        taskRepository.save(task);
        return new ResponseEntity<Object>("Task Update", HttpStatus.OK);
    }

}