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

import com.gestion.club.modelo.Cuota;
import com.gestion.club.servicio.CuotaServicio;

@RestController
@RequestMapping("/cuota")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class CuotaControlador {

	@Autowired
	private CuotaServicio cuotaServicio;

	@PostMapping("/nuevo")
	public Cuota nuevaCuota(@RequestBody Cuota nuevaCuota){
		return this.cuotaServicio.nuevaCuota(nuevaCuota);
	}

	@GetMapping("/mostrar")
	public List<Cuota> mostrarCuotas() {
		return cuotaServicio.mostrarCuotas();
	}

	@GetMapping("/mostrar/{año}/{mes}")
	public Cuota mostrarCuotasPorParametros(@PathVariable(value = "año") int año,
			@PathVariable(value = "mes") int mes) {
		List<Cuota> cuotas;
		Cuota cuota = new Cuota();
		cuotas = cuotaServicio.mostrarCuotaPorParametros(año, mes);

		if (cuotas.size() > 0) {
			cuota = cuotas.get(0);
		}
		return cuota;
	}

	@GetMapping("/existeCuota/{anio}/{mes}")
	public Boolean buscarCuotaPorAnioYMes(@PathVariable(value = "anio") int anio,
			@PathVariable(value = "mes") int mes) {
		return cuotaServicio.existeCuotaPorAnioYMes(anio, mes);
	}

	@PostMapping("/modificar")
	public Cuota modificarCuota(@RequestBody Cuota cuota){
		return this.cuotaServicio.modificarCuota(cuota);
	}
	@PostMapping(value ="/{id}")
	public void eliminarCuota(@PathVariable(value = "id") Long id){
		this.cuotaServicio.eliminarCuota(id);
	}
}