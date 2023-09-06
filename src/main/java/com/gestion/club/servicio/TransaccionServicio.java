package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Partido;
import com.gestion.club.modelo.Transaccion;

public interface TransaccionServicio {

	Transaccion nuevaTransaccion(Transaccion nuevaTransaccion);

	List<Transaccion> mostrarTransacciones();

	List<Transaccion> mostrarTransaccionesPorPartido(Partido partido);

	List<Transaccion> mostrarTransaccionesPorPartidoYTipo(Partido partido, String tipo);

	List<Transaccion> buscarTransaccionPorAlquilerBufe(Long idAlquilerBufe);

	List<Transaccion> buscarTransaccionPorAlquilerCancha(Long idAlquilerCancha);

	List<Transaccion> buscarTransaccionPorJugadorYCuota(Long documentoJugador, Long idCuota);

	List<Transaccion> buscarTransaccionPorSocioYCuota(Long documentoSocio, Long idCuota);

	List<Transaccion> buscarTransaccionPorPagoServicio(Long idPagoServicio);

	List<Transaccion> buscarTransaccionPorEntrenadorYCuota(Long documentoEntrenador, Long idCuota);

	Transaccion modificarTransaccion(Transaccion transaccion);

	void eliminarTransaccion(Long idTransaccion);

	List<Transaccion> transaccionesCuotaJugador();

	List<Transaccion> transaccionesCuotaEntrenador();

	List<Transaccion> transaccionesCuotaSocio();

	List<Transaccion> transaccionesPagoServicio();

	List<Transaccion> transaccionesPartidoIngreso();

	List<Transaccion> transaccionesPartidoEgreso();

	List<Transaccion> transaccionesAlquilerBufe();

	List<Transaccion> transaccionesAlquilerCancha();

}
