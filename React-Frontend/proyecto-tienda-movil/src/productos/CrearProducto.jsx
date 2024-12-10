import React from 'react'
import { useState } from 'react'
import axios from "axios"

export default function CrearProducto() {

    

    const [producto,setProducto] = useState({
        tipo: "",
        nombre: "",
        descripcion: "",
        precio: "",
        imagen_url: "",
        stock: "",
        ram: "",
        tamanoPantalla: "",
        
    })

    //ManejarCambios
    const handleChange = (e) =>{
        //spread operator ...(expandir a los atributos)
        const {name, value} = e.target;
        setProducto({
            ...producto,
            [name]: value,
        });
    }

    // Manejar el envío del formulario al BackEnd
    const manejarEnvio = async (e) =>{
        e.preventDefault(); //Evitamos que la pagina se recargue al enviar el formulario
        const urlBase = "http://localhost:8080/movil-app/crear";
        //Validar que se haya seleccionado un tipo
        if(producto.tipo === ""){
            alert("Por favor, seleccione un tipo de producto.");
            return;
        }
        
        try{
            // Enviar los datos al backend usando Axios}
            const resultado = await axios.post(urlBase,producto);
            console.log("Producto creado exitosamente con ID: " + resultado.data.id);
        }catch(error) {
            console.error("Error al crear el producto: ", error);
            alert("Ocurrio un error al crear el producto.");
        }
    }

  return (
    <div>
        <h2>Crear Producto</h2>
        <form onSubmit={manejarEnvio}>
            <div>
                <label>Tipo de Producto:</label>
                <select name="tipo" value={producto.tipo} onChange={handleChange} required>
                    <option value="">Seleccione un tipo</option> {/*Opcion predeterminada*/}
                    <option value="smartphone">Smarthphone</option>
                    <option value="tablet">Tablet</option>
                </select>            
            </div>
            <div>
                <label>Nombre:</label>
                <input type="text" name="nombre" value={producto.nombre} onChange={handleChange} required/>
            </div>
            <div>
                <label>Descripcion:</label>
                <textarea 
                name='descripcion'
                value={producto.descripcion}
                onChange={handleChange}
                required
                />          
            </div>
            <div>
                <label>Precio:</label>
                <input type="number" name="precio" value={producto.precio} onChange={handleChange} required/>
            </div>
            <div>
                <label>URL de la Imagen:</label>
                <input type="text" name="imagen_url" value={producto.imagen_url} onChange={handleChange}/>
            </div>
            <div>
                <label>Stock:</label>
                <input type="text" name="stock" value={producto.stock} onChange={handleChange}/>
            </div>
            {/*Campos especificos  de acuerdo al tipo de producto*/}
            {
                producto.tipo === 'smartphone'&& (
                    <div>
                        <label>RAM (GB)</label>
                        <input type='number' name ='ram' value={producto.ram} onChange={handleChange} required/>
                    </div>
                )
            }
            {
                producto.tipo === 'tablet' && (
                    <div>
                        <label>Tamaño de Pantalla (pulgadas)</label>
                        <input type='number' name ='tamanoPantalla' value={producto.tamanoPantalla} onChange={handleChange} required/>
                    </div>
                )
            }
          
            <button type='submit'>Crear Producto</button>
        </form>
    </div>
  )
}
