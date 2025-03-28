package com.spring.jwt.spring.security.repository;

import com.spring.jwt.spring.security.model.DetalhesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalhesUsuarioRepository extends JpaRepository<DetalhesUsuario, Long> {
    Optional<DetalhesUsuario> findById(Long id);
}
