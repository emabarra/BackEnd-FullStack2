package com.duoc.huerto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.huerto.model.entities.TiposUsuarios;
import com.duoc.huerto.model.request.ActualizarTiposDeUsuarios;
import com.duoc.huerto.model.request.AgregarTiposDeUsuarios;
import com.duoc.huerto.repositories.TiposUsuariosRepository;

@Service 
public class TiposUsuariosService {
    
    @Autowired 
    private TiposUsuariosRepository tiposUsuariosRepository;

    //Obtener todos los tipos de usuarios
    public List<TiposUsuarios> obtenerTodosLosTiposDeUsuarios(){

        return tiposUsuariosRepository.findAll();

    }

    //Buscar tipos de usuarios por su ID
    public TiposUsuarios obtenerTiposDeUsuariosPorId(int idTipoUsuario){
        TiposUsuarios tiposUsuarios = tiposUsuariosRepository.findById(idTipoUsuario).orElse(null);

        if (tiposUsuarios == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Usuario no encontrado.");
        }

        return tiposUsuarios;

    }

    //Agregar tipos de usuarios
    public TiposUsuarios agregarTiposDeUsuarios(AgregarTiposDeUsuarios nueva){

        TiposUsuarios tiposUsuarioNuevo = new TiposUsuarios();
        tiposUsuarioNuevo.setCategoria_usuario(nueva.getNombreTipoDeUsuario());
        return tiposUsuariosRepository.save(tiposUsuarioNuevo);

    }

    //Eliminar tipos de usuarios
    public String eliminarTiposDeUsuarios(int idTipoUsuario){

        if (tiposUsuariosRepository.existsById(idTipoUsuario)) {
            tiposUsuariosRepository.deleteById(idTipoUsuario);
            return "Tipo de Usuario eliminado correctamente.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Usuario no encontrado.");
        }

    }

    //Actualizar tipos de usuarios
    public TiposUsuarios actualizarTiposDeUsuarios(ActualizarTiposDeUsuarios nuevoTiposDeUsuarios){

        TiposUsuarios tiposUsuarios = tiposUsuariosRepository.findById(nuevoTiposDeUsuarios.getIdTiposDeUsuario()).orElse(null);
        if (tiposUsuarios == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de Usuario no encontrado.");
        }else{
            tiposUsuarios.setCategoria_usuario(nuevoTiposDeUsuarios.getNombreTiposDeUsuarios());
            return tiposUsuariosRepository.save(tiposUsuarios);
        }

    }
}
