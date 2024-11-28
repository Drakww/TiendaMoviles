/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.singleton;

import gm.tm.modelo.Carrito;
import gm.tm.modelo.Producto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge Singleton
 */
@Service
public class ServicioCarrito {

    private static ServicioCarrito instancia; // Instancia única (Singleton)
    private final Carrito carrito;

    // Constructor privado para Singleton
    private ServicioCarrito() {
        this.carrito = new Carrito(); // Inicializa un carrito vacío
    }

    // Método para obtener la instancia única del ServicioCarrito
    public static synchronized ServicioCarrito getInstance() {
        if (instancia == null) {
            instancia = new ServicioCarrito();
        }
        return instancia;
    }

    // Retorna el carrito único
    public Carrito getCarrito() {
        return carrito;
    }

    // Agrega un producto al carrito
    public void agregarProducto(Producto producto) {
        carrito.getProductos().add(producto);
        carrito.setTotal(carrito.getTotal() + producto.getPrecio()); // Actualiza el total
    }

    // Elimina un producto del carrito
    public void eliminarProducto(Producto producto) {
        carrito.getProductos().remove(producto);
        carrito.setTotal(carrito.getTotal() - producto.getPrecio()); // Actualiza el total
    }

    // Limpia el carrito (opcional)
    public void limpiarCarrito() {
        carrito.getProductos().clear();
        carrito.setTotal(0.0);
    }
}
