package com.marco.astorga.todo.controller;

import com.marco.astorga.todo.dto.LoginRequestDTO;
import com.marco.astorga.todo.dto.SignUpRequestDTO;
import com.marco.astorga.todo.service.impl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

 

    @Autowired
    UserServicesImpl userServicesImpl;
    
    @PutMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequestDTO signUpRequest) {
        return userServicesImpl.registerUser(signUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
     
        return userServicesImpl.authenticateUser(loginRequest);

    }

}