package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import com.gestion.club.modelo.Partido;

public interface PartidoServicio {

	Partido nuevoPartido(Partido nuevoPartido);

	List<Partido> mostrarPartidos();

	Partido buscarPartidoPorParametros(String descripcion, Long idCategoria, String cancha, LocalDate fecha);

	Partido modificarPartido(Partido partido);

	void eliminarPartido(Long idPartido);
}
