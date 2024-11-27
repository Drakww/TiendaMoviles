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
 * @author jorge
 * Singleton
 */
@Service
@Scope("sesion")
public class ServicioCarrito {
    private static ServicioCarrito instancia;
    private Carrito carrito;
    
    private ServicioCarrito(){
        this.carrito = new Carrito();// Inicializa el carrito vacío
    }
    
    public static synchronized ServicioCarrito getIsntance(){
        if (instancia ==null) {
            instancia = new ServicioCarrito();
        }
        return instancia;
    }
    
    public Carrito getCarrito(){
        return carrito;
    }
    
    public void agregarProducto(Producto producto){
//        carrito.getProductos().add(producto);
    }
}
