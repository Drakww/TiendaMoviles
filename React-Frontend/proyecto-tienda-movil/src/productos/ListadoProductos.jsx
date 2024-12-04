import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './ListaProducto.css';

export default function ListadoProductos() {

  const urlBase = "http://localhost:8080/movil-app/productos";

  //Hooks en react - Para establecer valores de Producto
  const[productos, setProductos] = useState([])

  useEffect(() =>{
    cargarProductos();
  }, []);

  //Peticiones de manera asincrona
  const cargarProductos = async () =>{
    const resultado = await axios.get(urlBase);
    console.log("Resultado de carga de productos");
    console.log(resultado.data);
    setProductos(resultado.data)
  }

  return (
    <div className='producto-lista'>
      <h1>Productos Disponibles</h1>
      <br/>
      <h4>Lista de productos</h4>
      <br/>
      <div className='producto-cards'>
        {productos.length > 0 ? (
          productos.map(producto => (
            <div key={producto.id} className='producto-card'>
              <img 
              src={producto.imagen_url} 
              alt='{producto.nombre}' 
              className='producto-imagen'
              />
              <div className='producto-info'>
                <h2>{producto.nombre}</h2>
                <p>{producto.descripcion}</p>
                <p><strong>Precio: </strong>{producto.precio}</p>
                <p><strong>Stock:</strong>{producto.stock}</p>
                {/* Condicionalmente mostrar atributos dependiente del tipo de producto*/ }
                {
                  producto.tipo === "smartphone" && (
                    <>
                    <p><strong>RAM:</strong> {producto.ram}</p>
                    </>
                  )
                }
                {
                  producto.tipo === "tablet" && (
                    <>
                    <p><strong>Pantalla:</strong> {producto.tamanoPantalla}</p>
                    </>
                  )
                }

                <button className='btn-agregar'>Agregar al carrito</button>
              </div>
            </div>
          ))
        ) : (
          <p className='mensaje'>No hay productos disponibles</p>
        )}
      </div>
    </div>
  )
}
