package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class AgregarTiposDeUsuarios {
    @NotBlank 
    private String nombreTipoDeUsuario;
}
