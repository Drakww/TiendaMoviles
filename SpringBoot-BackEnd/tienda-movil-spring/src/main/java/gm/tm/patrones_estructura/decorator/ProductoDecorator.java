/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.decorator;

import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
public abstract class ProductoDecorator extends Producto {

    protected Producto producto;

    public ProductoDecorator(Producto producto) {
        // El constructor llama al constructor padre con valores por defecto.
        super(producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getImagen_url(), producto.getStock());
        this.producto = producto;
    }
    
    @Override
    public String getTipo() {
        return producto.getTipo();
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }
    @Override
    public String getDescripcion() {
        return producto.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio();
    }
    
    // Añadir la propagación del valor de imagen_url
    @Override
    public String getImagen_url() {
        return producto.getImagen_url();
    }
    
}
