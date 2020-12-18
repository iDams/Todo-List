package com.marco.astorga.todo.service.impl;

import com.marco.astorga.todo.dto.LoginRequestDTO;
import com.marco.astorga.todo.dto.SignUpRequestDTO;
import com.marco.astorga.todo.entity.User;
import com.marco.astorga.todo.repository.UserRepository;
import com.marco.astorga.todo.service.UserServices;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service()
public class UserServicesImpl implements UserServices {

    @Value("${TOKEN}")
    String _TOKEN;
    
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> registerUser(SignUpRequestDTO signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<Object>("¡Este nombre de usuario ya existe!", HttpStatus.BAD_REQUEST);
        }

        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getPassword());
        userRepository.save(user);

        return new ResponseEntity<Object>("Usuario Creado", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginRequestDTO loginRequest) {
        if (!userRepository.existsByUsername(loginRequest.getUsername())) {
            return new ResponseEntity<Object>("¡Este nombre de usuario no existe!", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<Object>("¡Password incorrecta!", HttpStatus.BAD_REQUEST);
        }

        JSONObject result = new JSONObject();

        result.put("username", user.getUsername());
        result.put("token", _TOKEN);

        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

}