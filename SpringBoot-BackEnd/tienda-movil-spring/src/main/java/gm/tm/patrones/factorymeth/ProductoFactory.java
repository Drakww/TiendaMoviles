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
public class ProductoFactory {
    public static Producto crearProducto(String tipo){
        if ("smartphone".equalsIgnoreCase(tipo)) {
            return new Smartphone();
        } else if("tablet".equalsIgnoreCase(tipo)){
            return new Tablet();
        } else{
            throw new IllegalAccessError("Tipo de producto no sportado/no encontrado:" + tipo);
        }
    }
}
