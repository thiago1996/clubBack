package com.gestion.club.servicio;

import com.gestion.club.modelo.Entrenador;

public interface EntrenadorServicio {

	Entrenador nuevoEntrenador(Entrenador nuevoEntrenador);
	Iterable<Entrenador> mostrarEntrenadores();
	Entrenador modificarEntrenador(Entrenador entrenador);
	Boolean eliminarEntrenador(Long idEntrenador);

	Entrenador agregarCategoria(Long idEntrenador, Long idCategoria);

	Entrenador eliminarCategoria(Long documentoEntrenador, Long idCategoria);

	Boolean buscarEntrenadorPorId(Long idEntrenador);

	Entrenador obtenerEntrenadorPorId(Long idEntrenador);

}
