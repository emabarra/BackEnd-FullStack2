package com.duoc.huerto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.huerto.model.entities.CategoriaProduto;
import com.duoc.huerto.model.request.ActualizarCategoriaProducto;
import com.duoc.huerto.model.request.AgregarCategoriaProducto;
import com.duoc.huerto.services.CategoriaProductosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController("categoria")
@RequestMapping 
public class CategoriaProductoController {
    
    @Autowired 
    private CategoriaProductosService categoriaProductosService;

    @GetMapping("")
    public List<CategoriaProduto> obtenerTodasLasCategorias() {
        return categoriaProductosService.obtenerTodasLasCategorias();
    }
    
    @GetMapping("/{idCategoria}")
    public CategoriaProduto obtenerCategoriaPorId(@PathVariable  int idCategoria) {
        return categoriaProductosService.obtenerCategoriaPorId(idCategoria);
    }
    
    @PostMapping("")
    public CategoriaProduto agregarCategoria(@RequestBody AgregarCategoriaProducto nuevo) {
        return categoriaProductosService.agregarCategoria(nuevo);
    }
    
    @PutMapping("")
    public CategoriaProduto actualizarCategoria(@RequestBody ActualizarCategoriaProducto nuevo) {
        return categoriaProductosService.actualizarCategoria(nuevo);
    }

    @DeleteMapping("/{idCategoria}")
    public String eliminarCategoria(@PathVariable  int idCategoria){
        return categoriaProductosService.eliminarCategoria(idCategoria);
    }

}
