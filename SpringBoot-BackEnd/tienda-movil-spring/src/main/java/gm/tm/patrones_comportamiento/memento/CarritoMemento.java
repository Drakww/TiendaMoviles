/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.memento;

import gm.tm.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
// Memento para el carrito de compras
public class CarritoMemento {

    private final List<Producto> productos;

    public CarritoMemento(List<Producto> productos) {
        this.productos = new ArrayList<>(productos); // Clonamos para evitar que se modifique directamente

    }

    public List<Producto> getProductos() {
        return productos;
    }
}
