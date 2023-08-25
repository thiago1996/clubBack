package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.modelo.PagoCuotaEntrenador;

public interface PagoCuotaEntrenadorServicio {

	PagoCuotaEntrenador nuevoPagoCuotaEntrenador(Long id_cuota, Long id_entrenador, String nombre, String apellido,
			float importe, String medioPago, String fecha);
	List<PagoCuotaEntrenador> mostrarPagoCuotaEntrenador();

	Boolean eliminarPagoCuotaEntrenador(Long id_cuota, Long id_entrenador);

	List<Entrenador> mostrarEntrenadores();

	Entrenador buscarEntrenadorPorDocumento(Long documento);

	Boolean buscarSiExisteCuota(Cuota cuota);

	// Boolean buscarSiExisteCuotaYDocumento(Cuota cuota, Long documento);
	Boolean buscarPorId(Long id_cuota, Long documento);
}
