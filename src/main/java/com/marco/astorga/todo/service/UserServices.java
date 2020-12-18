package com.marco.astorga.todo.service;

import com.marco.astorga.todo.dto.LoginRequestDTO;
import com.marco.astorga.todo.dto.SignUpRequestDTO;

import org.springframework.http.ResponseEntity;

public interface UserServices {
    

    public  ResponseEntity<?> registerUser(SignUpRequestDTO signUpRequest);
    public  ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequest);
    
}