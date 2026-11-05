package com.duoc.huerto.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data 
public class AgregarFidelizacion {
    
    @NotBlank 
    private String correoFidelizado;

}
