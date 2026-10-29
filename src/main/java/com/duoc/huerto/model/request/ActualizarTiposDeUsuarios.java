package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class ActualizarTiposDeUsuarios {
    
    @NotBlank 
    private int idTiposDeUsuario;

    @NotBlank 
    private String nombreTiposDeUsuarios;

}
