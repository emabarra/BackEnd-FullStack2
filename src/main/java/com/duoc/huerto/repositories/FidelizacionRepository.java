package com.duoc.huerto.repositories;

import com.duoc.huerto.model.entities.Fidelizacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface FidelizacionRepository extends JpaRepository<Fidelizacion, Integer> {

}