import React from 'react'
import { useState } from 'react'
import axios from "axios"

export default function CrearProducto() {

    const urlBase = "http://localhost:8080/movil-app/crear";

    const [formData,setFormData] = useState({
        nombre: "",
        descripcion: "",
        precio: "",
        imagen_url: "",
        stock: "",
        tipo: "",
    })

    //ManejarCambios
    const handleChange = (e) =>{
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    }

    // Manejar el envío del formulario al BackEnd
    const manejarEnvio = async (e) =>{
        e.preventDefault(); //Evitamos que la pagina se recargue al enviar el formulario

        //Validar que se haya seleccionado un tipo
        if(formData.tipo === ""){
            alert("Por favor, seleccione un tipo de producto.");
            return;
        }
        
        try{
            // Enviar los datos al backend usando Axios}
            const resultado = await axios.post(urlBase,formData);
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
                <label>Nombre:</label>
                <input type="text" name="nombre" value={formData.nombre} onChange={handleChange} required/>
            </div>
            <div>
                <label>Descripcion:</label>
                <textarea 
                name='descripcion'
                value={formData.descripcion}
                onChange={handleChange}
                required
                />          
            </div>
            <div>
                <label>Precio:</label>
                <input type="number" name="precio" value={formData.precio} onChange={handleChange} required/>
            </div>
            <div>
                <label>URL de la Imagen:</label>
                <input type="text" name="imagen_url" value={formData.imagen_url} onChange={handleChange}/>
            </div>
            <div>
                <label>Stock:</label>
                <input type="text" name="stock" value={formData.stock} onChange={handleChange}/>
            </div>
            <div>
                <label>Tipo de Producto:</label>
                <select name="tipo" value={formData.tipo} onChange={handleChange} required>
                    <option value="">Seleccione un tipo</option> {/*Opcion predeterminada*/}
                    <option value="smartphone">Smarthphone</option>
                    <option value="tablet">Tablet</option>
                </select>            
            </div>
            <button type='submit'>Crear Producto</button>
        </form>
    </div>
  )
}
