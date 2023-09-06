package com.gestion.club.servicio;

import com.gestion.club.modelo.Socio;

public interface SocioServicio {

	Socio nuevoSocio(Socio nuevoSocio);
	Iterable<Socio> mostrarSocios();
	Socio modificarSocio(Socio Socio);
	Boolean eliminarSocio(Long idSocio);
	Boolean buscarSocioPorDocumento(Long idSocio);

	Socio obtenerSocioPorDocumento(Long idSocio);

}
