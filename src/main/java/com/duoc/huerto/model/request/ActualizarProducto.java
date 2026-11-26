package com.duoc.huerto.model.request;

import lombok.Data;

@Data
public class ActualizarProducto {
    private int idProductos;
    private int idCategoria;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int precioProductos;
    private int stockProducto;
    private int stockCritico;
}