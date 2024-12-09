import React from 'react'
import './Nosotros.css'
export default function Nosotros() {
  return (
      <div className="nosotros-container">
      <h1 className="nosotros-title">Sobre Nosotros</h1>
      <p className="nosotros-text">
        Bienvenidos a <span className="brand-name">Ion</span>, tu tienda confiable de celulares. Nos apasiona
        conectar a las personas con tecnología de última generación, ofreciendo productos de calidad,
        precios competitivos y un servicio al cliente excepcional.
      </p>
      <p className="nosotros-text">
        Nuestro equipo está dedicado a proporcionarte la mejor experiencia de compra, desde la selección de
        tu dispositivo ideal hasta el soporte técnico.<br/> <strong>¡Gracias por confiar en nosotros para tus necesidades
        tecnológicas!</strong>
      </p>
      <img
        src="./src/assets/Logo.png"
        alt="Equipo Ion"
        className="nosotros-image"
      />
      </div>

  )
}
