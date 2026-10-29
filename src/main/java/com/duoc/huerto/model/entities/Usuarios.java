package com.duoc.huerto.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Data 
@Table(name = "usuarios")
public class Usuarios {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario; 

    @Column(nullable = false)
    private int rut_usuario;

    @Column(nullable = false)
    private String nombre_usuario, apellidos_usuario, correo_usuario, region_usuario, comuna_usuario; 

    @ManyToOne 
    @JoinColumn(name = "id_tipoUsuario", nullable = false)
    private TiposUsuarios tiposUsuarios;
    
    @Column(nullable = false)
    private String direccion_usuario;
}
