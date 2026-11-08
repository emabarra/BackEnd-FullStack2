package com.duoc.huerto.model.entities;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Data 
@Table (name = "categoriaProductos")
public class CategoriaProduto extends RepresentationModel<CategoriaProduto>{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;

    @Column(nullable = false)
    private String nombre_categoria;

}
