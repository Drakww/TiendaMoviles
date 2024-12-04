/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.Builder;

import gm.tm.dto.ProductoDTO;
import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
public interface ProductoBuilder<T extends Producto>{
    
    ProductoBuilder<T> setNombre(String nombre);
    
    ProductoBuilder<T> setDescripcion(String descripcion);
    
    ProductoBuilder<T> setPrecio(double precio);
    
    ProductoBuilder<T> setImageUrl(String imagenUrl);
    
    ProductoBuilder<T> setStock(int stock);
    
    ProductoBuilder<T> aplicarAtributoEspecifico(ProductoDTO dto);
    T build();
}
