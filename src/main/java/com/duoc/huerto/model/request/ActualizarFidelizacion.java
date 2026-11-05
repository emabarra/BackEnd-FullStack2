package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class ActualizarFidelizacion {

    @NotBlank 
    private int idFidelizacion;

    @NotBlank 
    private String correoFidelizado;
    
}
