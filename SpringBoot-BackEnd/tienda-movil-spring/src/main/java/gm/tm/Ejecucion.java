/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm;

import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;

import gm.tm.patrones_estructura.facade.TiendaFacade;
import gm.tm.servicio.ComprarServicio;
import gm.tm.servicio.ProductoServicio;
import gm.tm.servicio.UsuarioServicio;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jorge
 */
public class Ejecucion {

    public static void main(String[] args) {
        // Crear instancias de servicios
        ProductoServicio productoService = new ProductoServicio();
        ComprarServicio compraService = new ComprarServicio();
        UsuarioServicio usuarioService = new UsuarioServicio();

        // Crear instancia de la fachada
        TiendaFacade tiendaFacade = new TiendaFacade(productoService, compraService, usuarioService);

        // Probar obtener catálogo
        System.out.println("Obteniendo catálogo de productos...");
        List<ProductoRequest> catalogo = tiendaFacade.obtenerCatalogo();
        catalogo.forEach(System.out::println);

        // Probar realizar una compra
        System.out.println("\nRealizando una compra...");
        int usuarioId = 1; // ID de prueba
        List<Integer> productosIds = Arrays.asList(1, 2); // IDs de productos de prueba
        tiendaFacade.realizarCompra(usuarioId, productosIds);
    }
}
