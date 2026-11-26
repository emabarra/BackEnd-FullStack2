package com.duoc.huerto.model.request;

import lombok.Data;

@Data
public class AgregarProducto {
    private int idCategoria; // El ID de la categoría que ya existe (ej: 6)
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int precioProductos;
    private int stockProducto;
    private int stockCritico;
}