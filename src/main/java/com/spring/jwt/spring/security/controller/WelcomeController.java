package com.spring.jwt.spring.security.controller;

import com.spring.jwt.spring.security.model.DetalhesUsuario;
import com.spring.jwt.spring.security.service.DetalhesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {
    @Autowired
    private DetalhesUsuarioService service;

    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/users/{id}")
    public DetalhesUsuario users(@PathVariable Long id) {
        return service.buscarDetalhes(id);
    }
    @PostMapping("/managers")
    public ResponseEntity<DetalhesUsuario> managers(@RequestBody DetalhesUsuario detalhesUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvarDetalhe(detalhesUsuario));
    }
}