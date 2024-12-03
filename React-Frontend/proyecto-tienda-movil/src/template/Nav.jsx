import React from 'react'
import './Nav.css'
import { Link } from 'react-router-dom'


export default function Nav() {
  const ocultarBarraLateral = () =>{
    const sidebar = document.querySelector('.sidebar')
      sidebar.style.display = 'none'
  }

  const mostrarBarraLateral = () =>{
    const sidebar = document.querySelector('.sidebar')
      sidebar.style.display = 'flex'
  }


  return (
    <div>
        <nav>
            <ul className="sidebar">
            <li onClick={ocultarBarraLateral}><a href="#"><svg xmlns="http://www.w3.org/2000/svg" height="26" viewBox="0 96 960 960" width="26"><path d="m249 849-42-42 231-231-231-231 42-42 231 231 231-231 42 42-231 231 231 231-42 42-231-231-231 231Z"/></svg></a></li>
            <li><a href="/blog">Blog</a></li>
            <li><Link to="/productos">Productos</Link></li>
            <li><a href="#">Nosotros</a></li>
            <li><a href="#">Foro</a></li>
            <li><Link to="/login">Login</Link></li>
            </ul> 
            <ul>
            <li><a className= "logo" href="#"><img src='./src/assets/Logo.png'/>Ion</a></li>
            <li className="hideOnMobile"><a href="/blog">Blog</a></li>
            <li className="hideOnMobile"><Link to="/productos">Productos</Link></li>
            <li className="hideOnMobile"><a href="#">Nosotros</a></li>
            <li className="hideOnMobile"><a href="#">Foro</a></li>
            <li className="hideOnMobile"><Link to="/login">Login</Link></li>
            <li className="menu-button" onClick={mostrarBarraLateral}><a href="#"><svg xmlns="http://www.w3.org/2000/svg" height="26" viewBox="0 96 960 960" width="26"><path d="M120 816v-60h720v60H120Zm0-210v-60h720v60H120Zm0-210v-60h720v60H120Z"/></svg></a></li>
            </ul>
        </nav>
    </div>
  )
}
