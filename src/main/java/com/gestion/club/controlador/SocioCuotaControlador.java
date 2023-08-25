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
import com.gestion.club.modelo.Socio;
import com.gestion.club.modelo.SocioCuota;
import com.gestion.club.servicio.CuotaServicio;
import com.gestion.club.servicio.SocioCuotaServicio;

@RestController
@RequestMapping("/socioCuota")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class SocioCuotaControlador {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConvertida;
	@Autowired
	private SocioCuotaServicio socioCuotaServicio;

	@Autowired
	private CuotaServicio cuotaServicio;

	@PostMapping("/nuevo/{idCuota}/{idSocio}/{nombre}/{apellido}/{precio}/{medioPago}/{fecha}")
	public SocioCuota nuevoSocioCuota(@PathVariable(value = "idCuota") Long idCuota,
			@PathVariable(value = "idSocio") Long idSocio, @PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "apellido") String apellido, @PathVariable(value = "precio") float precio,
			@PathVariable(value = "medioPago") String medioPago, @PathVariable(value = "fecha") String fecha) {
		return this.socioCuotaServicio.nuevoSocioCuota(idCuota, idSocio, nombre, apellido, precio, medioPago, fecha);
	}

	@GetMapping("/mostrar")
	public Iterable<SocioCuota> mostrarSocioCuota() {
		return socioCuotaServicio.mostrarSocioCuota();

	}


	@GetMapping("/mostrar/socios")
	public Iterable<Socio> mostrarSocios() {
		return socioCuotaServicio.mostrarSocios();
	}

	@GetMapping("/buscarPorDocumento/{documento}")
	public Socio buscarSocioPorDocumento(@PathVariable(value ="documento") Long documento) {
		return socioCuotaServicio.buscarSocioPorDocumento(documento);
	}

	@GetMapping("/buscarPorId/{idCuota}/{documento}")
	public Boolean buscarPorCuotaYIdJugador(@PathVariable(value = "idCuota") Long id,
			@PathVariable(value = "documento") Long documento) {

		return socioCuotaServicio.buscarPorId(id, documento);
	}

	/*
	 * @PostMapping("/modificar") public SocioCuota modificarSocioCuota(@RequestBody
	 * SocioCuota socioCuota){ return
	 * this.socioCuotaServicio.modificarSocioCuota(socioCuota); }
	 */

	@GetMapping("/cuota/{anio}/{mes}")
	public Cuota mostrarCuotaPorParametros(@PathVariable(value = "anio") int anio,
			@PathVariable(value = "mes") int mes) {
		List<Cuota> cuotas;
		Cuota cuota = new Cuota();
		cuotas = this.cuotaServicio.mostrarCuotaPorParametros(anio, mes);

		if (cuotas.size() > 0) {
			cuota = cuotas.get(0);
		}
		return cuota;
	}

	@PostMapping(value ="eliminar/{idCuota}/{idSocio}")
	public Boolean eliminarSocioCuota(@PathVariable(value = "idCuota") Long idCuota, @PathVariable(value = "idSocio") Long idSocio){

		return this.socioCuotaServicio.eliminarSocioCuota(idCuota, idSocio);
	}

}
