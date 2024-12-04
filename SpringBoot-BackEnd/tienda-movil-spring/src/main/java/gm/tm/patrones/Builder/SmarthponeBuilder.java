/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.Builder;

import gm.tm.dto.ProductoDTO;
import gm.tm.patrones.factorymeth.Smartphone;

/**
 *
 * @author jorge
 */
public class SmarthponeBuilder implements ProductoBuilder<Smartphone>{
    private final Smartphone smartphone;
    
    public SmarthponeBuilder(){
        this.smartphone = new Smartphone();
    }

    @Override
    public ProductoBuilder<Smartphone> setNombre(String nombre) {
        smartphone.setNombre(nombre);
        return this;
    }

    @Override
    public ProductoBuilder<Smartphone> setDescripcion(String descripcion) {
        smartphone.setDescripcion(descripcion);
        return this;
    }

    @Override
    public ProductoBuilder<Smartphone> setPrecio(double precio) {
        smartphone.setPrecio(precio);
        return this;
    }

    @Override
    public ProductoBuilder<Smartphone> setImageUrl(String imagenUrl) {
        smartphone.setImagen_url(imagenUrl);
        return this;
    }

    @Override
    public ProductoBuilder<Smartphone> setStock(int stock) {
        smartphone.setStock(stock);
        return this;
    }
    
    @Override
    public ProductoBuilder<Smartphone> aplicarAtributoEspecifico(ProductoDTO dto) {
        smartphone.setRam(dto.getRam());
        return this;
    }
    
    @Override
    public Smartphone build() {
        return smartphone;
    }
    
}
