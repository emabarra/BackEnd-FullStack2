package com.duoc.huerto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.huerto.model.entities.Usuarios;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByUsername(String nombre_usuario);

    boolean existsByUsername(String nombre_usuario);

}
