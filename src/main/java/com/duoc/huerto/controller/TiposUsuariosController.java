package com.duoc.huerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.huerto.model.entities.TiposUsuarios;
import com.duoc.huerto.model.request.ActualizarTiposDeUsuarios;
import com.duoc.huerto.model.request.AgregarTiposDeUsuarios;
import com.duoc.huerto.services.TiposUsuariosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("tiposusuarios")
@RestController 
public class TiposUsuariosController {
    
    @Autowired 
    private TiposUsuariosService tiposUsuariosService;

    @GetMapping("")
    public List<TiposUsuarios> obtenerTodosTiposUsuarios() {
        return tiposUsuariosService.obtenerTodosLosTiposDeUsuarios();
    }

    @GetMapping("/{idTipoUsuario}")
    public TiposUsuarios ObtenerTiposUsuariosPorId(@PathVariable int idTipoUsuario) {
        return tiposUsuariosService.obtenerTiposDeUsuariosPorId(idTipoUsuario);
    }
    
    @PostMapping("")
    public TiposUsuarios agregarTipoUsuario(@RequestBody AgregarTiposDeUsuarios nuevAgregarTiposDeUsuarios) {
        return tiposUsuariosService.agregarTiposDeUsuarios(nuevAgregarTiposDeUsuarios);
    }
    
    @PutMapping("")
    public TiposUsuarios actualizarTiposUsuarios(@RequestBody ActualizarTiposDeUsuarios nuevTiposDeUsuarios) {
        return tiposUsuariosService.actualizarTiposDeUsuarios(nuevTiposDeUsuarios);
    }

    @DeleteMapping("")
    public String eliminarTiposUsuarios(@PathVariable int idTiposUsuarios){
        return tiposUsuariosService.eliminarTiposDeUsuarios(idTiposUsuarios);
    }

}
