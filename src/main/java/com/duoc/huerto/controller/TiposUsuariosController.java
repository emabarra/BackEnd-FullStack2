package com.duoc.huerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;



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
    public EntityModel<TiposUsuarios> ObtenerTiposUsuariosPorId(@PathVariable int idTipoUsuario) {
        TiposUsuarios tiposUsuarios = tiposUsuariosService.obtenerTiposDeUsuariosPorId(idTipoUsuario);
        Link selfLink = linkTo(methodOn(TiposUsuariosController.class).obtenerTodosTiposUsuarios()).withRel("Obtener-todos-los-tipos-de-usuarios");
        Link eliminarLink = linkTo(TiposUsuariosController.class).slash(idTipoUsuario).withRel("Eliminar-tipo-de-usuario-por-id");

        return EntityModel.of(tiposUsuarios, selfLink, eliminarLink);
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
