
import axios from 'axios'
import './DecorarProducto.css';
import { useEffect, useState } from 'react';

export default function DecorarProducto() {
  const [descuento, setDescuento] = useState(0); // ID del producto a decorar
  const [garantiaExtendida, setGarantiaExtendida] = useState(0); // Costo de garantía extendida
  const [productoId, setProductoId] = useState(""); // ID del producto a decorar
  const [resultado, setResultado] = useState(null); // Producto decorado o mensaje de error

  const urlBase = "http://localhost:8080/movil-app/catalogo";

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

  // Función para manejar el envío del formulario
  const handleSubmit = async (event) => {
    event.preventDefault();

    // Verificar si puso un id
    if (!productoId) {
      alert("Por favor, ingresa un ID de producto.");
      return;
    }

    // Construir la URL correctamente con la interpolación
    const urlBase = `http://localhost:8080/movil-app/decorar/${productoId}`;

    try {
      // Enviar los datos de descuento y garantía extendida al backend
      const response = await axios.post(urlBase, {
        descuento: parseFloat(descuento),
        garantiaExtendida: parseFloat(garantiaExtendida),
      });

      // Si la respuesta es exitosa, actualizar el estado con el producto decorado
      setResultado(response.data);
      alert('Producto decorado correctamente');
    } catch (error) {
      console.error('Error al decorar el producto:', error);
      alert('Error al decorar el producto');
    }
  };

  return (
    <div className='container'>
      <div>
        <table border="1">
          <thead>
              <tr>
              <th>Id</th>
              <th>Tipo</th>
              <th>Nombre</th>
              <th>Descripción</th>
              <th>Url(imagenes)</th>
              <th>Precio</th>
              <th>Ram</th>
              <th>Tamaño de pantalla</th>
              <th>Stock</th>
            </tr>
          </thead>
                <tbody>
                    {
                        //Iteramos el arreglo de empleados
                        productos.map((producto, indice) => (
                            <tr key={indice}>
                            <td>{producto.id}</td>
                            <td>{producto.tipo}</td>
                            <td>{producto.nombre}</td>
                            <td>{producto.descripcion}</td>
                            <td><img 
              src={producto.imagen_url} 
              alt='{producto.nombre}' 
              className='producto-imagen'
              /></td>
                            <td>{producto.precio}</td>
                            <td>{producto.ram}</td>
                            <td>{producto.tamanoPantalla}</td>
                            <td>{producto.stock}</td>
                            </tr>  
                        ))
                    }
                    
                </tbody>
        </table>
      </div>
      <div className='container-decorador'>
      <h1>Decorar Producto</h1>

        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="productoId">ID del producto: </label>
            <input
              type="text"
              id="productoId"
              value={productoId}
              onChange={(e) => setProductoId(e.target.value)}
              required
            />
          </div>

          <div>
            <label htmlFor="descuento">Descuento(%): </label>
            <input
              type="number"
              id="descuento"
              value={descuento}
              onChange={(e) => setDescuento(e.target.value)}
              min="0"
              max="100"
              required
            />
          </div>

          <div>
            <label htmlFor="garantiaExtendida">Garantía Extendida (S/.): </label>
            <input
              type="number"
              id="garantiaExtendida"
              value={garantiaExtendida}
              onChange={(e) => setGarantiaExtendida(e.target.value)}
              min="0"
              required
            />
          </div>

          <button type="submit">Aplicar Decoraciones</button>
        </form>
        
        {resultado && (
          <div style={{ marginTop: "20px", padding: "10px", border: "1px solid #ccc" }}>
            <h3>Resultado:</h3>
            {resultado.error ? (
              <p style={{ color: "red" }}>{resultado.error}</p>
            ) : (
              <div>
                <p><strong>Tipo:</strong> {resultado.tipo}</p>
                <p><strong>Nombre:</strong> {resultado.nombre}</p>
                <p><strong>Descripción:</strong> {resultado.descripcion}</p>
                <p><strong>Precio Final:</strong> ${resultado.precio.toFixed(2)}</p>
                <p><strong>Stock:</strong> {resultado.stock}</p>
                {resultado.tipo === "smartphone" && <p><strong>RAM:</strong> {resultado.ram} GB</p>}
                {resultado.tipo === "tablet" && <p><strong>Tamaño de Pantalla:</strong> {resultado.tamanoPantalla} pulgadas</p>}
                <p><strong>Descuento Aplicado:</strong> {resultado.descuento}%</p>
                <p><strong>Garantía Extendida:</strong> ${resultado.garantiaExtendida.toFixed(2)}</p>
              </div>
            )}
          </div>
        )}
      </div>
    </div>
  );
}
