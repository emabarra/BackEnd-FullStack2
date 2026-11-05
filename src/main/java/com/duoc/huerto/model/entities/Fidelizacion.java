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
@Table ( name = "Fidelizacion")
public class Fidelizacion {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fidelizacion; 


    @Column(nullable = false)
    private String nombre_fidelizado, apellido_fidelizado, correo_fidelizado, telefono_fidelizado; 

}