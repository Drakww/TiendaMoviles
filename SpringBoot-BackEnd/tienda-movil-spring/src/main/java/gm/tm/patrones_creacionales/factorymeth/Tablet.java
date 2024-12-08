/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones_creacionales.factorymeth;

import gm.tm.modelo.Producto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

/**
 *
 * @author jorge
 */
@Entity
@NoArgsConstructor
//JPA: usamos en el contexto de herencia de entindades
@DiscriminatorValue("tablet")

public class Tablet extends Producto{
    private double tamanoPantalla; // Tamaño de pantalla específico para la Tablet
    
    public Tablet(String nombre, String descripcion, double precio, String imagenUrl, int stock, Double tamanoPantalla) {
        super(nombre, descripcion, precio, imagenUrl, stock);
        this.tamanoPantalla = tamanoPantalla;
    }

    @Override
    public String getTipo() {
        return "tablet";
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    @Override
    public double getPrecio() {
        return super.precio;
    }
  
    
}
