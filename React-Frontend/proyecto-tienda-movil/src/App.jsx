import {BrowserRouter, Route,Routes} from "react-router-dom";
import './App.css'
import ListadoProductos from './productos/ListadoProductos'
import Nav from './template/Nav'
import Login from "./login/Login";
import CrearProducto from "./productos/CrearProducto";
import DecorarProducto from "./productos/DecorarProducto"
import Nosotros from "./nosotros/Nosotros";
import Blog from "./blog/Blog";





function App() {
  return (
    <>
      <BrowserRouter>
      <div>      
        <Nav/>

        <Routes>
          <Route exact path='/blog' element={<Blog/>}/>
          <Route exact path='/nosotros' element={<Nosotros/>}/>
          <Route exact path='/productos' element={<ListadoProductos/>}/>
          <Route exact path='/login' element ={<Login/>}/>
          <Route exact path='/crear' element={<CrearProducto/>}/>
          <Route exact path='/decorar' element={<DecorarProducto/>}/>
        </Routes>
        
      </div>
      </BrowserRouter>
    </>
  )
}

export default App
