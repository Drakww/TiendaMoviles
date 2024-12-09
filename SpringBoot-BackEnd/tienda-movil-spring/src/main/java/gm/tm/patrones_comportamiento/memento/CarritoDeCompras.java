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
public class CarritoDeCompras {
    private List<Producto> productos = new ArrayList<>();

    // Método para agregar productos al carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Guarda el estado del carrito en un memento
    public CarritoMemento guardarEstado() {
        return new CarritoMemento(productos);
    }

    // Restaura el estado del carrito desde un memento
    public void restaurarEstado(CarritoMemento memento) {
        this.productos = memento.getProductos();
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
