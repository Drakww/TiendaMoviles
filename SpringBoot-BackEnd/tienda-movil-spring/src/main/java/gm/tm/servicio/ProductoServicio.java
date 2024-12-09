/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.servicio;


import gm.tm.dto.ProductoDTO;
import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;

import gm.tm.repositorio.ProductoRepositorio;
import java.util.ArrayList;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class ProductoServicio implements IProductoServicio{
    
    //AutoInyectamos la capa de Repositorio
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
       Producto producto = productoRepositorio.findById(idProducto).orElse(null);
       return producto;
    }
    @Override
    public Producto guardarProducto(Producto producto) {
        //Convertir el ProductoDTO en la entidad Producto
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }

    @Override
    public boolean actualizarStock(Integer idProducto, int cantidad) {
        Optional<Producto> productoOpt = productoRepositorio.findById(idProducto);
        
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            if (producto.getStock() >= cantidad) {
                producto.setStock(producto.getStock() - cantidad);
                productoRepositorio.save(producto);
                return true;
            } else {
                throw new RuntimeException("Stock insuficiente para el producto con ID " + idProducto);
            }
        } else {
            throw new RuntimeException("Producto con ID " + idProducto + " no encontrado.");
        }
    }
    
    

    
    
    
}
