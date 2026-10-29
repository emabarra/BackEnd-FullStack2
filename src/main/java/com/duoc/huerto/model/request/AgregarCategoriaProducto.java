package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class AgregarCategoriaProducto {

    @NotBlank 
    private String nombreCategoria;
}
