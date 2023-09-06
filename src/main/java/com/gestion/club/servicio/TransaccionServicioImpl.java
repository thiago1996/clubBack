package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.AlquilerBufe;
import com.gestion.club.modelo.AlquilerCancha;
import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.modelo.Jugador;
import com.gestion.club.modelo.PagoServicio;
import com.gestion.club.modelo.Partido;
import com.gestion.club.modelo.Socio;
import com.gestion.club.modelo.Transaccion;
import com.gestion.club.repositorio.TransaccionRepositorio;

@Service

public class TransaccionServicioImpl implements TransaccionServicio {

	@Autowired
	private TransaccionRepositorio transaccionRepositorio;

	@Override
	public Transaccion nuevaTransaccion(Transaccion nuevaTransaccion) {
		return this.transaccionRepositorio.save(nuevaTransaccion);
	}

	@Override
	public List<Transaccion> mostrarTransacciones() {
		return transaccionRepositorio.findAll();
	}

	@Override
	public List<Transaccion> mostrarTransaccionesPorPartido(Partido partido) {

		return transaccionRepositorio.findAllByPartido(partido);
	}

	@Override
	public List<Transaccion> mostrarTransaccionesPorPartidoYTipo(Partido partido, String tipo) {

		return transaccionRepositorio.findAllByPartidoAndTipo(partido, tipo);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorAlquilerBufe(Long idAlquilerBufe) {

		AlquilerBufe alquilerBufe = new AlquilerBufe();
		alquilerBufe.setId(idAlquilerBufe);

		return transaccionRepositorio.findAllByAlquilerBufe(alquilerBufe);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorAlquilerCancha(Long idAlquilerCancha) {

		AlquilerCancha alquilerCancha = new AlquilerCancha();
		alquilerCancha.setId(idAlquilerCancha);

		return transaccionRepositorio.findAllByAlquilerCancha(alquilerCancha);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorJugadorYCuota(Long documentoJugador, Long idCuota) {

		Jugador jugador = new Jugador();
		jugador.setDocumento(documentoJugador);

		Cuota cuota = new Cuota();
		cuota.setId_cuota(idCuota);

		return transaccionRepositorio.findAllByJugadorAndCuota(jugador, cuota);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorSocioYCuota(Long documentoSocio, Long idCuota) {

		Socio socio = new Socio();
		socio.setDocumento(documentoSocio);

		Cuota cuota = new Cuota();
		cuota.setId_cuota(idCuota);

		return transaccionRepositorio.findAllBySocioAndCuota(socio, cuota);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorEntrenadorYCuota(Long documentoEntrenador, Long idCuota) {

		Entrenador entrenador = new Entrenador();
		entrenador.setDocumento(documentoEntrenador);

		Cuota cuota = new Cuota();
		cuota.setId_cuota(idCuota);

		return transaccionRepositorio.findAllByCuotaAndEntrenador(cuota, entrenador);
	}

	@Override
	public List<Transaccion> buscarTransaccionPorPagoServicio(Long idPagoServicio) {

		PagoServicio pagoServicio = new PagoServicio();
		pagoServicio.setId(idPagoServicio);

		return transaccionRepositorio.findAllByPagoServicio(pagoServicio);
	}

	@Override
	public Transaccion modificarTransaccion(Transaccion transaccion) {

		Optional<Transaccion> transaccionEncontrada = transaccionRepositorio.findById(transaccion.getId());
		if (transaccionEncontrada.get() != null) {
			transaccionEncontrada.get().setDescripcion(transaccion.getDescripcion());
			transaccionEncontrada.get().setImporte(transaccion.getImporte());
			transaccionEncontrada.get().setMedioPago(transaccion.getMedioPago());
			transaccionEncontrada.get().setFecha(transaccion.getFecha());
			transaccionEncontrada.get().setTipo(transaccion.getTipo());
			transaccionEncontrada.get().setAlquilerBufe(transaccion.getAlquilerBufe());
			transaccionEncontrada.get().setAlquilerCancha(transaccion.getAlquilerCancha());
			transaccionEncontrada.get().setCuota(transaccion.getCuota());
			transaccionEncontrada.get().setEntrenador(transaccion.getEntrenador());
			transaccionEncontrada.get().setJugador(transaccion.getJugador());
			transaccionEncontrada.get().setSocio(transaccion.getSocio());
			transaccionEncontrada.get().setPagoServicio(transaccion.getPagoServicio());
			transaccionEncontrada.get().setPartido(transaccion.getPartido());

			return this.nuevaTransaccion(transaccionEncontrada.get());
		}
		return null;
	}

	@Override
	public void eliminarTransaccion(Long idTransaccion) {

		transaccionRepositorio.deleteById(idTransaccion);
	}

	@Override
	public List<Transaccion> transaccionesCuotaJugador() {
		return transaccionRepositorio.transaccionesCuotaJugador();
	}

	@Override
	public List<Transaccion> transaccionesCuotaEntrenador() {
		return transaccionRepositorio.transaccionesCuotaEntrenador();
	}

	@Override
	public List<Transaccion> transaccionesCuotaSocio() {
		return transaccionRepositorio.transaccionesCuotaSocio();
	}

	@Override
	public List<Transaccion> transaccionesPagoServicio() {
		return transaccionRepositorio.transaccionesPagoServicio();
	}

	@Override
	public List<Transaccion> transaccionesPartidoIngreso() {
		return transaccionRepositorio.transaccionesPartidoIngreso();
	}

	@Override
	public List<Transaccion> transaccionesPartidoEgreso() {
		return transaccionRepositorio.transaccionesPartidoEgreso();
	}

	@Override
	public List<Transaccion> transaccionesAlquilerBufe() {
		return transaccionRepositorio.transaccionesAlquilerBufe();
	}

	@Override
	public List<Transaccion> transaccionesAlquilerCancha() {
		return transaccionRepositorio.transaccionesAlquilerCancha();
	}

}
