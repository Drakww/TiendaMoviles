/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.modelo;

import gm.tm.dto.ProductoRequest;
import gm.tm.patrones_comportamiento.memento.CarritoMemento;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

/**
 *
 * @author jorge
 */
@NoArgsConstructor
public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public CarritoMemento guardar() {
        return new CarritoMemento(productos);
    }

    public void restaurar(CarritoMemento memento) {
        productos = memento.getEstado();
    }
    
}
