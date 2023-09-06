package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Jugador;

public interface JugadorServicio {

	Jugador nuevoJugador(Jugador nuevoJugador);
	//Iterable<Jugador> mostrarJugadores();
	List<Jugador> mostrarJugadores();

	public Jugador buscarPorId(Long id);
	//Jugador modificarJugador(Jugador jugador);
	void eliminarJugador(Long idJugador);

	Boolean buscarJugadorPorDocumento(Long idJugador);

	Jugador obtenerJugadorPorDocumento(Long idJugador);
}
