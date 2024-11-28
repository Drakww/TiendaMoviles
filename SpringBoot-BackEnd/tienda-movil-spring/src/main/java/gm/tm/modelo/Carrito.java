/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author jorge
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @OneToMany
    private List<Producto> productos = new ArrayList<>(); //Lista de productos en el carrito
    
    private double total;// Total del carrito (suma de los precios de los productos)
    
    
//    public void agregarProducto(Producto producto){
//        this.productos.add(producto);
//        this.total += producto.getPrecio();
//    }
//    
//    public void eliminarProducto(Producto producto){
//        this.productos.remove(producto);
//        this.total -= producto.getPrecio();
//    }
    
}
