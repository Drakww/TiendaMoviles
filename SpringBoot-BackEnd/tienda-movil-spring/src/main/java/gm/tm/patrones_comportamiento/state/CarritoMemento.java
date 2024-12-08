/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_comportamiento.memento;

import gm.tm.dto.ProductoRequest;
import gm.tm.modelo.Producto;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class CarritoMemento {
    private List<Producto> estado;
    
    public CarritoMemento(List<Producto> estado){
        this.estado = new ArrayList<>(estado);
    }
    
    public List<Producto> getEstado(){
        return estado;
    }
}
