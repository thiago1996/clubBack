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
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.modelo.PagoCuotaEntrenador;
import com.gestion.club.servicio.CuotaServicio;
import com.gestion.club.servicio.PagoCuotaEntrenadorServicio;

@RestController
@RequestMapping("/pagoCuotaEntrenador")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class PagoCuotaEntrenadorControlador {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConvertida;
	@Autowired
	private PagoCuotaEntrenadorServicio pagoCuotaEntrenadorServicio;

	@Autowired
	private CuotaServicio cuotaServicio;

	@PostMapping("/nuevo/{idCuota}/{idEntrenador}/{nombre}/{apellido}/{importe}/{medioPago}/{fecha}")
	public PagoCuotaEntrenador nuevoSocioCuota(@PathVariable(value = "idCuota") Long idCuota,
			@PathVariable(value = "idEntrenador") Long idEntrenador, @PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "apellido") String apellido, @PathVariable(value = "importe") float importe,
			@PathVariable(value = "medioPago") String medioPago,
			@PathVariable(value = "fecha") String fecha) {
		return this.pagoCuotaEntrenadorServicio.nuevoPagoCuotaEntrenador(idCuota, idEntrenador, nombre, apellido,
				importe, medioPago, fecha);
	}

	@GetMapping("/mostrar")
	public Iterable<PagoCuotaEntrenador> mostrarPagoCuotaEntrenador() {
		return pagoCuotaEntrenadorServicio.mostrarPagoCuotaEntrenador();
	}

	@GetMapping("/buscarPorDocumento/{documento}")
	public Entrenador buscarEntrenadorPorDocumento(@PathVariable(value = "documento") Long documento) {
		return pagoCuotaEntrenadorServicio.buscarEntrenadorPorDocumento(documento);
	}

	@GetMapping("/mostrar/entrenadores")
	public Iterable<Entrenador> mostrarEntrenadores() {
		return pagoCuotaEntrenadorServicio.mostrarEntrenadores();
	}

	@GetMapping("/buscarPorId/{idCuota}/{documento}")
	public Boolean buscarPorId(@PathVariable(value = "idCuota") Long idCuota,
			@PathVariable(value = "documento") Long documento) {
		return pagoCuotaEntrenadorServicio.buscarPorId(idCuota, documento);
	}

	@GetMapping("/buscarPorCuota/{anio}/{mes}")
	public Boolean buscarSiExisteCuota(@PathVariable(value = "anio") int anio, @PathVariable(value = "mes") int mes) {

		List<Cuota> cuotas;
		cuotas = this.cuotaServicio.mostrarCuotaPorParametros(anio, mes);
		if (cuotas.size() > 0) {
			return true;
		} else {
			return false;
		}
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

	@PostMapping(value ="eliminar/{idCuota}/{idEntrenador}")
	public Boolean eliminarPagoCuotaEntrenador(@PathVariable(value = "idCuota") Long idCuota, @PathVariable(value = "idEntrenador") Long idEntrenador){

		return this.pagoCuotaEntrenadorServicio.eliminarPagoCuotaEntrenador(idCuota, idEntrenador);
	}
}
