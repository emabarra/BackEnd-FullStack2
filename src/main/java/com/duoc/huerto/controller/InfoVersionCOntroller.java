package com.duoc.huerto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa la clase desde tu paquete model.request
import com.duoc.huerto.model.request.InfoVersion;

@RequestMapping("/")
@RestController 
public class InfoVersionCOntroller {

    @Value("${app.name}")
    private String nombreApp;

    @Value("${app.version}")
    private String versionApp; 

    @GetMapping("")
    public InfoVersion info() { // Asegúrate de quitar la 'r' de "InforVersion"
        return new InfoVersion(nombreApp, versionApp);
    }
}