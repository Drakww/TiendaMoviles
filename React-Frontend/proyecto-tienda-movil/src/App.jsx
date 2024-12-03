import {BrowserRouter, Route,Routes} from "react-router-dom";
import './App.css'
import ListadoProductos from './productos/ListadoProductos'
import Nav from './template/Nav'
import Login from "./login/Login";
import AgregarProducto from "./productos/AgregarProducto";
import CrearProducto from "./productos/CrearProducto";



function App() {
  return (
    <>
      <BrowserRouter>
      <div>      
        <Nav/>
        <Routes>
        <Route exact path='/productos' element={<ListadoProductos/>}/>
        <Route exact path='/agregar' element={<AgregarProducto/>}/>
        <Route exact path='/login' element ={<Login/>}/>
        <Route exact path='/crear' element={<CrearProducto/>}/>
          
        </Routes>
        
      </div>
      </BrowserRouter>
    </>
  )
}

export default App
