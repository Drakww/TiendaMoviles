/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.facade;

import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;
import gm.tm.patrones_estructura.proxy.InventarioProxy;
import gm.tm.patrones_estructura.proxy.InventarioServiceImpl;
import gm.tm.patrones_estructura.proxy.InventarioServicio;

import gm.tm.servicio.ComprarServicio;
import gm.tm.servicio.IProductoServicio;


import java.util.List;


import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service  // Anotación que registra la clase como un bean de Spring
public class TiendaFacade {

    private IProductoServicio productoServicio;
    private final InventarioServicio inventarioProxy;

    public TiendaFacade(IProductoServicio productoServicio, InventarioServiceImpl inventarioReal) {
        this.productoServicio = productoServicio;
        // Aquí creamos una instancia del Proxy utilizando el servicio real
        this.inventarioProxy = new InventarioProxy(inventarioReal);
    }
    
    // Método para obtener el catálogo de productos
    public List<Producto> obtenerCatalogo() {
        return productoServicio.listarProductos();
    }
    
    // Método para actualizar stock
    public void actualizarStock(Integer productoId, int nuevaCantidad){
        if (nuevaCantidad < 0 ) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        inventarioProxy.actualizarStock(productoId, nuevaCantidad);
    }
}
