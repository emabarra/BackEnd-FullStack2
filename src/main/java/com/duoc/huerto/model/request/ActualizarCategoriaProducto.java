package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class ActualizarCategoriaProducto {

    @NotBlank 
    private int idCategoria;

    @NotBlank 
    private String nombreCategoria;
}
