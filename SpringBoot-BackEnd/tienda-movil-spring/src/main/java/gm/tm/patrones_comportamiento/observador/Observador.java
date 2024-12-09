/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.tm.patrones_comportamiento.observador;

import gm.tm.modelo.Producto;

/**
 *
 * @author jorge
 */
//Cada observador implementará esta interfaz para recibir las notificaciones.
public interface Observador {
    
    void actualizar(String mensaje);
}
