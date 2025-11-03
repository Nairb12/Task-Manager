package com.example.hitss.springboot.taskmanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hitss.springboot.taskmanager.models.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Login",
    description = "Valida el usuario y devuelve el token para"
)
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        return ResponseEntity.ok("Este endpoint es manejado por Spring Security.");
    }
}
