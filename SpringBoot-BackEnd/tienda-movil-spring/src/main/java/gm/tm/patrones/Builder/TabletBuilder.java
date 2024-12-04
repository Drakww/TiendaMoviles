/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.tm.patrones.Builder;

import gm.tm.dto.ProductoDTO;
import gm.tm.patrones.factorymeth.Smartphone;
import gm.tm.patrones.factorymeth.Tablet;

/**
 *
 * @author jorge
 */
public class TabletBuilder implements ProductoBuilder<Tablet>{
    private final Tablet tablet;
    
    public TabletBuilder(){
        this.tablet = new Tablet();
    }

    @Override
    public ProductoBuilder<Tablet> setNombre(String nombre) {
        tablet.setNombre(nombre);
        return this;
        
    }

    @Override
    public ProductoBuilder<Tablet> setDescripcion(String descripcion) {
        tablet.setDescripcion(descripcion);
        return this;
    }

    @Override
    public ProductoBuilder<Tablet> setPrecio(double precio) {
        tablet.setPrecio(precio);
        return this;
    }

    @Override
    public ProductoBuilder<Tablet> setImageUrl(String imagenUrl) {
        tablet.setImagen_url(imagenUrl);
        return this;
    }

    @Override
    public ProductoBuilder<Tablet> setStock(int stock) {
        tablet.setStock(stock);
        return this;
    }
    
    @Override
    public ProductoBuilder<Tablet> aplicarAtributoEspecifico(ProductoDTO dto) {
        tablet.setTamanoPantalla(dto.getTamanoPantalla());
        return this;
    }

    @Override
    public Tablet build() {
        return tablet;
    }
    
}
