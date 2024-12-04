/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.dto.ProductoDTO;
import gm.tm.modelo.Producto;
import gm.tm.patrones.factorymeth.ProductoFactory;
import gm.tm.servicio.IProductoServicio;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Producto crearProducto(@RequestBody ProductoDTO productoDTO) {
        //Creando producto usando el Factory y el Build

            Producto producto = ProductoFactory.crearProducto(productoDTO.getTipo())
                    .setNombre(productoDTO.getNombre())
                    .setDescripcion(productoDTO.getDescripcion())
                    .setPrecio(productoDTO.getPrecio())
                    .setImageUrl(productoDTO.getImagen_url())
                    .setStock(productoDTO.getStock())
                    .aplicarAtributoEspecifico(productoDTO)
                    .build();

            logger.info("Empleado a agregar: " + producto);
            // Guardar producto en la base de datos
            productoServicio.guardarProducto(producto);

            // Devolver el producto creado
            return producto;
    }
}
