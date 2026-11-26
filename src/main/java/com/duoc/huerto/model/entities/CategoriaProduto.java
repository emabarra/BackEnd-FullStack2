package com.duoc.huerto.model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "categoria_productos")
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria; // Verifica si en tu clase se llama idCategoria o id_categoria

    @Column(nullable = false)
    private String nombre_categoria;

    @OneToMany(mappedBy = "categoriaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Producto> productos = new ArrayList<>();
}