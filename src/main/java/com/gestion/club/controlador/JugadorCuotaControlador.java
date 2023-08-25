package com.gestion.club.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.Jugador;
import com.gestion.club.modelo.JugadorCuota;
import com.gestion.club.servicio.CuotaServicio;
import com.gestion.club.servicio.JugadorCuotaServicio;

@RestController

@RequestMapping("/jugadorCuota")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class JugadorCuotaControlador {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConvertida;
	@Autowired
	private JugadorCuotaServicio jugadorCuotaServicio;

	@Autowired
	private JugadorCuotaServicio jugadorServicio;

	@Autowired
	private CuotaServicio cuotaServicio;

	@PostMapping("/nuevo/{idCuota}/{idJugador}/{nombre}/{apellido}/{precio}/{medioPago}/{fecha}")
	public JugadorCuota nuevoJugadorCuota(@PathVariable(value = "idCuota") Long idCuota,
			@PathVariable(value = "idJugador") Long idJugador, @PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "apellido") String apellido, @PathVariable(value = "precio") float precio,
			@PathVariable(value = "medioPago") String medioPago,
			@PathVariable(value = "fecha") String fecha) {
		return this.jugadorCuotaServicio.nuevoJugadorCuota(idCuota, idJugador, nombre, apellido, precio, medioPago, fecha);
	}

	@GetMapping("/mostrar")
	public Iterable<JugadorCuota> mostrarJugadorCuota() {
		return jugadorCuotaServicio.mostrarJugadorCuota();
	}


	@GetMapping("/mostrar/jugadores")
	public Iterable<Jugador> mostrarJugadores() {
		return jugadorServicio.mostrarJugadores();
	}

	@GetMapping("/buscarPorDocumento/{documento}")
	public Jugador buscarSocioPorDocumento(@PathVariable(value = "documento") Long documento) {
		return jugadorCuotaServicio.buscarJugadorPorDocumento(documento);
	}

	/*
    @PostMapping("/modificar")
    public SocioCuota modificarSocioCuota(@RequestBody SocioCuota socioCuota){
        return this.socioCuotaServicio.modificarSocioCuota(socioCuota);
    }*/

	@GetMapping("/buscarPorId/{idCuota}/{documento}")
	public Boolean buscarPorCuotaYIdJugador(@PathVariable(value = "idCuota") Long id,
			@PathVariable(value = "documento") Long documento) {

		return jugadorCuotaServicio.buscarPorId(id, documento);
	}

	@GetMapping("/cuota/{anio}/{mes}")
	public Cuota mostrarCuotasPorParametros(@PathVariable(value = "anio") int anio,
			@PathVariable(value = "mes") int mes) {

		List<Cuota> cuotas;
		Cuota cuota = new Cuota();
		cuotas = this.cuotaServicio.mostrarCuotaPorParametros(anio, mes);
		if (cuotas.size() > 0) {
			cuota = cuotas.get(0);
		}
		return cuota;
	}

	@PostMapping(value ="eliminar/{idCuota}/{idJugador}")
	public Boolean eliminarJugadorCuota(@PathVariable(value = "idCuota") Long idCuota, @PathVariable(value = "idJugador") Long idJugador){

		return this.jugadorCuotaServicio.eliminarJugadorCuota(idCuota, idJugador);
	}

}
