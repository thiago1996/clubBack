package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Jugador;
import com.gestion.club.modelo.JugadorCuota;

public interface JugadorCuotaServicio {

	JugadorCuota nuevoJugadorCuota(Long id_cuota, Long id_jugador, String nombre, String apellido, float precio,
			String medioPago, String fecha);
	List<JugadorCuota> mostrarJugadorCuota();

	List<Jugador> mostrarJugadores();

	Jugador buscarJugadorPorDocumento(Long documento);

	Boolean eliminarJugadorCuota(Long id_cuota, Long id_Jugador);

	Boolean buscarPorId(Long id_cuota, Long documento);
}
