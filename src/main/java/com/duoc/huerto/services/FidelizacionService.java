package com.duoc.huerto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.duoc.huerto.model.entities.Fidelizacion;
import com.duoc.huerto.model.request.ActualizarFidelizacion;
import com.duoc.huerto.model.request.AgregarFidelizacion;
import com.duoc.huerto.repositories.FidelizacionRepository;

@Service 
public class FidelizacionService {

    @Autowired 
    private FidelizacionRepository fidelizacionRepository;

    //Obtener todas las fidelizaciones disponibles
    public List<Fidelizacion> obtenerFidelizaciones(){
        return fidelizacionRepository.findAll();
    }

    //Obtener fidelizacion según id
    public Fidelizacion obtenerFidelizacionPorId(int idFidelizacion){
        Fidelizacion fidelizacion = fidelizacionRepository.findById(idFidelizacion).orElse(null);

        if (fidelizacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la fidelizacion deseada");
        }

        return fidelizacion;
    }

    //Agregar fidelizacion
    public Fidelizacion agregarFidelizacion(AgregarFidelizacion nueva){
        Fidelizacion nuevaFidelizacion = new Fidelizacion();

        nuevaFidelizacion.setCorreo_fidelizado(nueva.getCorreoFidelizado());

        return fidelizacionRepository.save(nuevaFidelizacion);

    }

    //Eliminar fidelizacion
    public String eliminarFidelizacion(int id_fidelizacion){
        if (fidelizacionRepository.existsById(id_fidelizacion)) {
            fidelizacionRepository.deleteById(id_fidelizacion);
            return "Se ha eliminado la fidelizacion correctamente";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el ID de la fidelizacion");
        }
    }

    //Actualizar fidelizacion
    public Fidelizacion actualizarFidelizacion(ActualizarFidelizacion nuevaFidelizacion){

        Fidelizacion fidelizacion = fidelizacionRepository.findById(nuevaFidelizacion.getIdFidelizacion()).orElse(null);

        if (fidelizacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el ID de la fidelizacion");
        }else{
            fidelizacion.setCorreo_fidelizado(nuevaFidelizacion.getCorreoFidelizado());
            return fidelizacionRepository.save(fidelizacion);
        }

    }


}
