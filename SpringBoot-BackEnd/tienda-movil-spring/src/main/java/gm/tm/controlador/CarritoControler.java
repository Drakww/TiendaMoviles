/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.controlador;

import gm.tm.dto.ProductoDTO;
import gm.tm.modelo.Producto;
import gm.tm.patrones_comportamiento.memento.CarritoDeCompras;

import gm.tm.patrones_comportamiento.memento.CarritoMemento;
import gm.tm.patrones_comportamiento.memento.HistorialCarritoService;

import java.util.List;
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
//http://localhost:8080/movil-app
@RequestMapping("movil-app/carrito")
@CrossOrigin(value = "http://localhost:5173")

public class CarritoControler {

    private final CarritoDeCompras carritoDeCompras = new CarritoDeCompras();
    private final HistorialCarritoService historialCarritosService;

    @Autowired
    public CarritoControler(HistorialCarritoService historialCarritosService) {
        this.historialCarritosService = historialCarritosService;
    }

//    @PostMapping("/agregar")
//    public ResponseEntity<String> agregarProducto(@RequestBody ProductoDTO  productoDTO) {
//        try {
//            carritoDeCompras.agregarProducto(producto);
//            return ResponseEntity.ok("Producto agregado al carrito");
//        } catch (Exception e) {
//            e.printStackTrace(); // Para obtener más detalles del error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar producto: " + e.getMessage());
//        }
//    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarCarrito() {
        CarritoMemento memento = carritoDeCompras.guardarEstado();
        historialCarritosService.agregarMemento(memento);
        return ResponseEntity.ok("Carrito guardado");
    }

    @PostMapping("/restaurar")
    public ResponseEntity<String> restaurarCarrito() {
        CarritoMemento memento = historialCarritosService.obtenerUltimoMemento();
        if (memento != null) {
            carritoDeCompras.restaurarEstado(memento);
            return ResponseEntity.ok("Carrito restaurado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró historial de carrito");
        }
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return ResponseEntity.ok(carritoDeCompras.getProductos());
    }
}
