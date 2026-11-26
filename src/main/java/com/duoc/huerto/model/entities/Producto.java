package com.duoc.huerto.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_productos;

    @Column(nullable = false)
    private String codigoProducto, nombreProducto;

    @Column(nullable = true)
    private String descripcionProducto;

    @Column(nullable = false)
    private int precioProductos, stockProducto, stockCritico;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CategoriaProduto categoriaProduto;
}