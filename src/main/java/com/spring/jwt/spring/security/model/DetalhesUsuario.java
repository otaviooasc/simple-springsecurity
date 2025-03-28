package com.spring.jwt.spring.security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalhe-usuario")
public class DetalhesUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String detalhe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}
