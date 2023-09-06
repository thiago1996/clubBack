package com.gestion.club.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Partido;
import com.gestion.club.modelo.Transaccion;
import com.gestion.club.servicio.EntrenadorServicio;
import com.gestion.club.servicio.TransaccionServicio;

@RestController
@RequestMapping("/transaccion")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class TransaccionControlador {

	@Autowired
	private TransaccionServicio transaccionServicio;

	@Autowired
	private EntrenadorServicio entrenadorServicio;

	@PostMapping("/nueva")
	public Transaccion nuevaTransaccion(@RequestBody Transaccion nuevaTransaccion) {
		return this.transaccionServicio.nuevaTransaccion(nuevaTransaccion);
	}

	@GetMapping("/mostrar")
	public Iterable<Transaccion> mostrarTransacciones() {
		return transaccionServicio.mostrarTransacciones();
	}

	@PostMapping("/mostrarPorPartido")
	public List<Transaccion> mostrarTransaccionessPorPartido(@RequestBody Partido partido) {
		return transaccionServicio.mostrarTransaccionesPorPartido(partido);
	}

	@PostMapping("/mostrarPorPartidoYTipo/{tipo}")
	public List<Transaccion> mostrarTransaccionessPorPartidoYTipo(@PathVariable(value = "tipo") String tipo,
			@RequestBody Partido partido) {
		return transaccionServicio.mostrarTransaccionesPorPartidoYTipo(partido, tipo);
	}

	@GetMapping("/mostrarPorIdAlquilerBufe/{idAlquilerBufe}")
	public List<Transaccion> mostrarTransaccionesPorAlquilerBufe(
			@PathVariable(value = "idAlquilerBufe") Long idAlquilerBufe) 
	{
		return transaccionServicio.buscarTransaccionPorAlquilerBufe(idAlquilerBufe);
	}

	@GetMapping("/mostrarPorIdAlquilerCancha/{idAlquilerCancha}")
	public List<Transaccion> mostrarTransaccionesPorAlquilerCancha(
			@PathVariable(value = "idAlquilerCancha") Long idAlquilerCancha) {
		return transaccionServicio.buscarTransaccionPorAlquilerCancha(idAlquilerCancha);
	}

	@GetMapping("/mostrarPorIdPagoServicio/{idPagoServicio}")
	public List<Transaccion> mostrarTransaccionesPorPagoServicio(
			@PathVariable(value = "idPagoServicio") Long idPagoServicio) {
		return transaccionServicio.buscarTransaccionPorPagoServicio(idPagoServicio);
	}

	@GetMapping("/mostrarPorDocumentoSocioIdCuota/{documento}/{idCuota}")
	public List<Transaccion> mostrarPorDocumentoSocioIdCuota(@PathVariable(value = "documento") Long documento,
			@PathVariable(value = "idCuota") Long idCuota) {
		return transaccionServicio.buscarTransaccionPorSocioYCuota(documento, idCuota);
	}

	@GetMapping("/mostrarPorDocumentoJugadorIdCuota/{documento}/{idCuota}")
	public List<Transaccion> mostrarPorDocumentoJugadorIdCuota(
			@PathVariable(value = "documento") Long documento, @PathVariable(value = "idCuota") Long idCuota) {
		return transaccionServicio.buscarTransaccionPorJugadorYCuota(documento, idCuota);
	}

	@GetMapping("/mostrarPorDocumentoEntrenadorIdCuota/{documento}/{idCuota}")
	public List<Transaccion> obtenerPorDocumentoEntrenadorIdCuota(@PathVariable(value = "documento") Long documento,
			@PathVariable(value = "idCuota") Long idCuota) {
		return transaccionServicio.buscarTransaccionPorEntrenadorYCuota(documento, idCuota);
	}

	@PostMapping("/modificar")
	public Transaccion modificarTransaccion(@RequestBody Transaccion transaccion) {
		return this.transaccionServicio.modificarTransaccion(transaccion);
	}

	@PostMapping(value = "/{id}")
	public void eliminarTransaccion(@PathVariable(value = "id") Long id) {
		this.transaccionServicio.eliminarTransaccion(id);
	}

	@GetMapping("/mostrarTransaccionesCuotaJugador")
	public Iterable<Transaccion> transaccionesCuotaJugador() {
		return transaccionServicio.transaccionesCuotaJugador();
	}

	@GetMapping("/mostrarTransaccionesCuotaEntrenador")
	public Iterable<Transaccion> transaccionesCuotaEntrenador() {
		return transaccionServicio.transaccionesCuotaEntrenador();
	}

	@GetMapping("/mostrarTransaccionesCuotaSocio")
	public Iterable<Transaccion> transaccionesCuotaSocio() {
		return transaccionServicio.transaccionesCuotaSocio();
	}

	@GetMapping("/mostrarTransaccionesPagoServicio")
	public Iterable<Transaccion> transaccionesPagoServicio() {
		return transaccionServicio.transaccionesPagoServicio();
	}

	@GetMapping("/mostrarTransaccionesPartidoIngreso")
	public Iterable<Transaccion> transaccionesPartidoIngreso() {
		return transaccionServicio.transaccionesPartidoIngreso();
	}

	@GetMapping("/mostrarTransaccionesPartidoEgreso")
	public Iterable<Transaccion> transaccionesPartidoEgreso() {
		return transaccionServicio.transaccionesPartidoEgreso();
	}

	@GetMapping("/mostrarTransaccionesAlquilerCancha")
	public Iterable<Transaccion> transaccionesAlquilerCancha() {
		return transaccionServicio.transaccionesAlquilerCancha();
	}

	@GetMapping("/mostrarTransaccionesAlquilerBufe")
	public Iterable<Transaccion> transaccionesAlquilerBufe() {
		return transaccionServicio.transaccionesAlquilerBufe();
	}
}
