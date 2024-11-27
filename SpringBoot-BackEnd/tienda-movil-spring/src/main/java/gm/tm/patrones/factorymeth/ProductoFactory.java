/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.factorymeth;

import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 * Factory Method
 */
public abstract class ProductoFactory {
    public abstract Producto crearProducto(String nombre, double precio, String descripcion, int stock);

    public static ProductoFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "alta":
                return new ProductoGamaAltaFactory();
            case "media":
                return new ProductoGamaMediaFactory();
            case "baja":
                return new ProductoGamaBajaFactory();
            default:
                throw new IllegalArgumentException("Tipo de producto desconocido");
        }
    }
}

