package com.duoc.huerto.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.huerto.model.entities.TiposUsuarios;
import com.duoc.huerto.model.entities.Usuarios;

@Repository 
public interface TiposUsuariosRepository extends JpaRepository<TiposUsuarios, Integer> {

    Optional<Usuarios> findByUsername(String username);

    boolean existsByUsername(String username);

} 
