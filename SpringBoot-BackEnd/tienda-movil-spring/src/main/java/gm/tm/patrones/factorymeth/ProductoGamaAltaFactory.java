/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.factorymeth;

import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
public class ProductoGamaAltaFactory extends ProductoFactory{

    @Override
    public Producto crearProducto(String nombre, double precio, String descripcion, int stock) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCategoria("Gama Alta");
        producto.setStock(stock);
        return producto;
    }

   
    
}
