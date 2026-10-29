package com.duoc.huerto.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Data 
@Table (name = "tipos_usuarios")
public class TiposUsuarios {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_tipoUsuario;

    @Column(nullable = false)
    private String categoria_usuario;
}
