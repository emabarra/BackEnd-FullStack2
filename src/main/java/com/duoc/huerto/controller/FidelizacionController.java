package com.duoc.huerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.huerto.model.entities.Fidelizacion;
import com.duoc.huerto.model.request.ActualizarFidelizacion;
import com.duoc.huerto.model.request.AgregarFidelizacion;
import com.duoc.huerto.services.FidelizacionService;

@RestController ("fidelizacion")
@RequestMapping 
public class FidelizacionController {

    @Autowired 
    private FidelizacionService fidelizacionService;

    @GetMapping("")
    public List<Fidelizacion> obtenerFidelizaciones() {
        return fidelizacionService.obtenerFidelizaciones();
    }
    
    @GetMapping("/{idFidelizacion}")
    public Fidelizacion obtenerCategoriaPorId(@PathVariable  int idFidelizacion) {
        return fidelizacionService.obtenerFidelizacionPorId(idFidelizacion);
    }
    
    @PostMapping("")
    public Fidelizacion agregarFidelizacion(@RequestBody AgregarFidelizacion nueva) {
        return fidelizacionService.agregarFidelizacion(nueva);
    }
    
    @PutMapping("")
    public Fidelizacion actualizarFidelizacion(@RequestBody ActualizarFidelizacion nueva) {
        return fidelizacionService.actualizarFidelizacion(nueva);
    }

    @DeleteMapping("/{idFidelizacion}")
    public String eliminarFidelizacion(@PathVariable  int idFidelizacion){
        return fidelizacionService.eliminarFidelizacion(idFidelizacion);
    }


}
