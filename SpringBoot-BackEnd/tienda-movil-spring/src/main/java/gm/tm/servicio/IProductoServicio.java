/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.tm.servicio;

import gm.tm.modelo.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IProductoServicio {
    public List<Producto> listarProductos();
    
    public Producto buscarProductoPorId(Integer idProducto);
    
    public Producto guardarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
}
