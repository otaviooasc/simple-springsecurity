package com.spring.jwt.spring.security.impl;

import com.spring.jwt.spring.security.model.DetalhesUsuario;
import com.spring.jwt.spring.security.repository.DetalhesUsuarioRepository;
import com.spring.jwt.spring.security.service.DetalhesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalhesUsuarioServiceImpl implements DetalhesUsuarioService {
    @Autowired
    private DetalhesUsuarioRepository repository;

    @Override
    public DetalhesUsuario buscarDetalhes(Long id) {
        return repository.findById(id).orElse(new DetalhesUsuario());
    }

    @Override
    public DetalhesUsuario salvarDetalhe(DetalhesUsuario detalhesUsuario) {
        return repository.save(detalhesUsuario);
    }
}
