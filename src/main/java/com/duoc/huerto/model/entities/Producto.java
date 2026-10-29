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
@Table (name = "producto")
public class Producto {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_productos;

    @Column(nullable = false)
    private String codigoProducto, nombreProducto;

    @Column(nullable = true)
    private String descripcionProducto;

    @Column(nullable = false)
    private int precioProductos, stockProducto, stockCritico;

    @ManyToOne 
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaProduto categoriaProduto;
}
