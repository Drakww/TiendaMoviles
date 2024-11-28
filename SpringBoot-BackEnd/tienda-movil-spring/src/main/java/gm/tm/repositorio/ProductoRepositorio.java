/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.tm.repositorio;

import gm.tm.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jorge
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
