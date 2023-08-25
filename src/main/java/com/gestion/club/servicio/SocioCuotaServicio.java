package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Socio;
import com.gestion.club.modelo.SocioCuota;

public interface SocioCuotaServicio {
	SocioCuota nuevoSocioCuota(Long id_cuota, Long id_socio, String nombre, String apellido, float precio,
			String medioPago,
			String fecha);
	List<SocioCuota> mostrarSocioCuota();

	Boolean eliminarSocioCuota(Long id_cuota, Long id_socio);

	List<Socio> mostrarSocios();

	Socio buscarSocioPorDocumento(Long documento);

	// SocioCuota modificarSocioCuota(SocioCuota socioCuota);

	Boolean buscarPorId(Long id_cuota, Long documento);

}

