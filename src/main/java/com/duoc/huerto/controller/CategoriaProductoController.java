package com.duoc.huerto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.huerto.model.entities.CategoriaProduto;
import com.duoc.huerto.model.entities.Producto;
import com.duoc.huerto.model.request.ActualizarCategoriaProducto;
import com.duoc.huerto.model.request.ActualizarProducto;
import com.duoc.huerto.model.request.AgregarCategoriaProducto;
import com.duoc.huerto.services.CategoriaProductosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.duoc.huerto.model.request.AgregarProducto;




@RestController
@RequestMapping("/api/categoria") 
public class CategoriaProductoController {
    
    @Autowired 
    private CategoriaProductosService categoriaProductosService;

    @GetMapping("")
    public List<CategoriaProduto> obtenerTodasLasCategorias() {
        return categoriaProductosService.obtenerTodasLasCategorias();
    }
    
    @GetMapping("/{idCategoria}")
    public EntityModel<CategoriaProduto> obtenerCategoriaPorId(@PathVariable  int idCategoria) {
        CategoriaProduto categoriaProducto = categoriaProductosService.obtenerCategoriaPorId(idCategoria);
        Link selfLink = linkTo(methodOn(CategoriaProductoController.class).obtenerTodasLasCategorias()).withRel("Obtener-todas-las-categorias");
        Link eliminarLink = linkTo(CategoriaProductoController.class).slash(idCategoria).withRel("Eliminar-categoria-producto-por-id");

        return EntityModel.of(categoriaProducto, selfLink, eliminarLink);
    }

    @GetMapping("/producto")
    public List<Producto> obtenerTodosLosProductos() {
        return categoriaProductosService.obtenerTodosLosProductos();
    }

    @GetMapping("/producto/{idProducto}")
    public Producto obtenerProductoPorId(@PathVariable int idProducto) {
        return categoriaProductosService.obtenerProductoPorId(idProducto);
    }
    
    @PostMapping("")
    public CategoriaProduto agregarCategoria(@RequestBody AgregarCategoriaProducto nuevo) {
        return categoriaProductosService.agregarCategoria(nuevo);
    }

    @PostMapping ("/producto")
    public CategoriaProduto agregarProducto(@RequestBody AgregarProducto nuevoProducto){
        return categoriaProductosService.agregarProductoACategoria(nuevoProducto);
    }
    
    @PutMapping("")
    public CategoriaProduto actualizarCategoria(@RequestBody ActualizarCategoriaProducto nuevo) {
        return categoriaProductosService.actualizarCategoria(nuevo);
    }

    @PutMapping("/producto")
    public CategoriaProduto actualizarProducto(@RequestBody ActualizarProducto productoActualizado) {
        return categoriaProductosService.actualizarProductoEnCategoria(productoActualizado);
    }

    @DeleteMapping("/{idCategoria}")
    public String eliminarCategoria(@PathVariable  int idCategoria){
        return categoriaProductosService.eliminarCategoria(idCategoria);
    }

}
