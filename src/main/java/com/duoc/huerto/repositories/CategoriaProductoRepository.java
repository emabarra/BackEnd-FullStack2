package com.duoc.huerto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.huerto.model.entities.CategoriaProduto;

@Repository 
public interface  CategoriaProductoRepository extends JpaRepository<CategoriaProduto, Integer> {
    
}
