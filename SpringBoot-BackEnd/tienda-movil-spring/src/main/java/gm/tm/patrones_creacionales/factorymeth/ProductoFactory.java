/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_creacionales.factorymeth;

import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
public class ProductoFactory {
    public static Producto crearProducto(ProductoRequest productoDTO){
        switch (productoDTO.getTipo().toLowerCase()) {
            case "smartphone":
                return new Smartphone(
                        productoDTO.getNombre(),
                        productoDTO.getDescripcion(),
                        productoDTO.getPrecio(),
                        productoDTO.getImagen_url(),
                        productoDTO.getStock(),
                        productoDTO.getRam()
                );
            case "tablet":
                return new Tablet(
                        productoDTO.getNombre(),
                        productoDTO.getDescripcion(),
                        productoDTO.getPrecio(), 
                        productoDTO.getImagen_url(), 
                        productoDTO.getStock(), 
                        productoDTO.getTamanoPantalla()
                );
            default:
                throw new IllegalArgumentException("Tipo de producto no soportado: " + productoDTO.getTipo());
            
        }
    }
}
