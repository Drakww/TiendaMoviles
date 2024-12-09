/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.dto.DecoracionDTO;
import gm.tm.dto.ProductoRequest;

import gm.tm.modelo.Producto;
import gm.tm.patrones_creacionales.factorymeth.ProductoFactory;
import gm.tm.patrones_creacionales.factorymeth.Smartphone;
import gm.tm.patrones_creacionales.factorymeth.Tablet;

import gm.tm.servicio.IProductoServicio;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge
 */
@RestController
//http://localhost:8080/movil-app/
@RequestMapping("movil-app")
@CrossOrigin(value = "http://localhost:5173")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private IProductoServicio productoServicio;

    //htpp://localhost:8080/movil-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        var productos = productoServicio.listarProductos();
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;

    }

    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody ProductoRequest productoDTO) {
        // Crear el producto utilizando el Factory Method
        logger.info("Empleado a agregar: " + productoDTO);
        Producto producto = ProductoFactory.crearProducto(productoDTO);

        // Devolver el producto creado
        return productoServicio.guardarProducto(producto);
    }

    //Patron DECORATOR
    @PostMapping("/decorar/{id}")
    public ResponseEntity<ProductoRequest> aplicarDecoradores(@PathVariable Integer id, @RequestBody DecoracionDTO decoracionDTO) {
        logger.info("Solicitud para decorar producto con id: " + id);
        logger.info("Datos de decoración recibidos: " + decoracionDTO);
        var producto = productoServicio.buscarProductoPorId(id);

        if (producto == null) {
            logger.info("El producto no existe");
        }

        logger.info("Producto encontrado: " + producto);

        // Variables para almacenar los cambios
        double descuento = decoracionDTO.getDescuento();
        double garantiaExtendida = decoracionDTO.getGarantiaExtendida();

        // Aplicar descuento al producto base
        if (descuento > 0) {
            if (descuento > 100) {
                logger.warn("El porcentaje de descuento no es válido: " + descuento);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            producto.setPrecio(producto.getPrecio() * (1 - descuento / 100)); // Aplica el descuento al precio
            producto.setDescripcion(producto.getDescripcion() + " (Descuento aplicado: " + descuento + "%)");
            logger.info("Descuento aplicado: " + descuento + "%");
        }

        // Aplicar garantía extendida al producto base
        if (garantiaExtendida > 0) {
            producto.setPrecio(producto.getPrecio() + garantiaExtendida); // Añadir el costo de la garantía al precio
            producto.setDescripcion(producto.getDescripcion()
                    + " (Incluye garantía extendida por $" + garantiaExtendida + ")");
            logger.info("Garantía extendida aplicada: $" + garantiaExtendida);
        }
        // Guardar los cambios en la base de datos
        productoServicio.guardarProducto(producto);

        ProductoRequest productoDTO = new ProductoRequest(
                producto.getTipo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getImagen_url(),
                producto.getStock(),
                descuento, // Se pasa directamente como double
                garantiaExtendida,
                producto instanceof Smartphone ? ((Smartphone) producto).getRam() : 0, // Si es un Smartphone, pasa ram (int), si no, pasa 0
                producto instanceof Tablet ? ((Tablet) producto).getTamanoPantalla() : 0.0 // Si es una Tablet, pasa tamanoPantalla (double), si no, pasa 0.0
        );
        logger.info("Producto actualizo y decorado : " + productoDTO);

        return ResponseEntity.ok(productoDTO);

    }
}
