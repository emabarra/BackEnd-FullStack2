package com.duoc.huerto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.duoc.huerto.model.entities.CategoriaProduto;
import com.duoc.huerto.model.entities.Producto;
import com.duoc.huerto.model.request.ActualizarCategoriaProducto;
import com.duoc.huerto.model.request.ActualizarProducto;
import com.duoc.huerto.model.request.AgregarCategoriaProducto;
import com.duoc.huerto.model.request.AgregarProducto;
import com.duoc.huerto.repositories.CategoriaProductoRepository;

@Service 
public class CategoriaProductosService {
    
    @Autowired 
    private CategoriaProductoRepository categoriaProductoRepository;

    //Obtener todas las categorias
    public List<CategoriaProduto> obtenerTodasLasCategorias(){
        return categoriaProductoRepository.findAll();
    }

    //obtener la categoria por id
    public CategoriaProduto obtenerCategoriaPorId(int idCategoria){
        CategoriaProduto categoriaProduto = categoriaProductoRepository.findById(idCategoria).orElse(null);

        if (categoriaProduto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la Categoría");
        }

        return categoriaProduto;
    }

    //Agregar categoría
    public CategoriaProduto agregarCategoria(AgregarCategoriaProducto nuevo){
        CategoriaProduto categoriaNueva = new CategoriaProduto();

        categoriaNueva.setNombre_categoria(nuevo.getNombreCategoria());

        return categoriaProductoRepository.save(categoriaNueva);

    }

    //Eliminar categoría
    public String eliminarCategoria(int idCategoria){
        if (categoriaProductoRepository.existsById(idCategoria)) {
            categoriaProductoRepository.deleteById(idCategoria);
            return "Se ha eliminado la categoría correctamente";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el ID de la categoría");
        }
    }

    //Actualizar categoría
    public CategoriaProduto actualizarCategoria(ActualizarCategoriaProducto nuevaCategoria){

        CategoriaProduto categoriaProduto = categoriaProductoRepository.findById(nuevaCategoria.getIdCategoria()).orElse(null);

        if (categoriaProduto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el ID de la categoría");
        }else{
            categoriaProduto.setNombre_categoria(nuevaCategoria.getNombreCategoria());
            return categoriaProductoRepository.save(categoriaProduto);
        }

    }
    
    // Agregar producto a una categoría existente
    public CategoriaProduto agregarProductoACategoria(AgregarProducto req) {
        CategoriaProduto categoria = categoriaProductoRepository.findById(req.getIdCategoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la Categoría"));

        Producto nuevoProd = new Producto();
        nuevoProd.setCodigoProducto(req.getCodigoProducto());
        nuevoProd.setNombreProducto(req.getNombreProducto());
        nuevoProd.setDescripcionProducto(req.getDescripcionProducto());
        nuevoProd.setPrecioProductos(req.getPrecioProductos());
        nuevoProd.setStockProducto(req.getStockProducto());
        nuevoProd.setStockCritico(req.getStockCritico());
        nuevoProd.setCategoriaProduto(categoria); // Enlaza la llave foránea id_categoria

        categoria.getProductos().add(nuevoProd);
        return categoriaProductoRepository.save(categoria);
    }

    // Actualizar un producto dentro de una categoría
    public CategoriaProduto actualizarProductoEnCategoria(ActualizarProducto req) {
        CategoriaProduto categoria = categoriaProductoRepository.findById(req.getIdCategoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado la Categoría"));

        Producto productoEncontrado = null;
        for (Producto p : categoria.getProductos()) {
            if (p.getId_productos() == req.getIdProductos()) {
                productoEncontrado = p;
                break;
            }
        }

        if (productoEncontrado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el Producto en esta Categoría");
        }

        productoEncontrado.setCodigoProducto(req.getCodigoProducto());
        productoEncontrado.setNombreProducto(req.getNombreProducto());
        productoEncontrado.setDescripcionProducto(req.getDescripcionProducto());
        productoEncontrado.setPrecioProductos(req.getPrecioProductos());
        productoEncontrado.setStockProducto(req.getStockProducto());
        productoEncontrado.setStockCritico(req.getStockCritico());

        return categoriaProductoRepository.save(categoria);
    }
}
