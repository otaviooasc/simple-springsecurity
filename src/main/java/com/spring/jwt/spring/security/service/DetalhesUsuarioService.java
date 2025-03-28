package com.spring.jwt.spring.security.service;

import com.spring.jwt.spring.security.model.DetalhesUsuario;

public interface DetalhesUsuarioService {
    DetalhesUsuario buscarDetalhes(Long id);
    DetalhesUsuario salvarDetalhe(DetalhesUsuario detalhesUsuario);
}
