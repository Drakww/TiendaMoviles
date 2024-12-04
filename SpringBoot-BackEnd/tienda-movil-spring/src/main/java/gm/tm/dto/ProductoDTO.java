/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jorge
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String tipo; //tipo de producto (smartphone, tablet, etc)
    
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagen_url;
    private int stock;
    
    // Atributos específicos para productos
    private Integer ram; // Para Smartphone
    private Double tamanoPantalla; // Para Tablet
}
    

