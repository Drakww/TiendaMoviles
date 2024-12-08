/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_estructura.facade;

import gm.tm.dto.ProductoDTO;
import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;
import gm.tm.servicio.ComprarServicio;
import gm.tm.servicio.ProductoServicio;
import gm.tm.servicio.UsuarioServicio;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 *
 * @author jorge
 */
@AllArgsConstructor
public class TiendaFacade {

    private ProductoServicio productoServicio;
    private ComprarServicio comprarServicio;
    private UsuarioServicio usuarioServicio;

    // Método para obtener el catálogo de productos
    public List<ProductoRequest> obtenerCatalogo() {
//        return productoServicio.obtenerCatalogo();
        return null;
    }

    // Método para realizar una compra
    public void realizarCompra(int usuarioId, List<Integer> productosIds) {
        usuarioServicio.verificarUsuario(usuarioId);  // Verifica al usuario
        comprarServicio.procesarCompra(usuarioId, productosIds); // Procesa la compra
    }

}
