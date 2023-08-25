package com.gestion.club.controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.AlquilerCancha;
import com.gestion.club.servicio.AlquilerCanchaServicio;

@RestController
@RequestMapping("/alquilerCancha")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class AlquilerCanchaControlador {

	@Autowired
	private AlquilerCanchaServicio alquilerCanchaServicio;

	@PostMapping("/nuevo")
	public AlquilerCancha nuevoAlquilerCancha(@RequestBody AlquilerCancha nuevoAlquilerCancha) {
		return alquilerCanchaServicio.nuevoAlquilerCancha(nuevoAlquilerCancha);
	}

	@GetMapping("/mostrar")
	public List<AlquilerCancha> mostrarAlquileresCancha() {
		return alquilerCanchaServicio.mostrarAlquileresCancha();
	}

	@PostMapping("/modificar")
	public AlquilerCancha modificarAlquilerCancha(@RequestBody AlquilerCancha alquilerCancha) {
		return this.alquilerCanchaServicio.modificarAlquilerCancha(alquilerCancha);
	}

	@PostMapping(value ="/{id}")
	public void eliminarAlquilerCancha(@PathVariable(value = "id") Long id){
		this.alquilerCanchaServicio.eliminarAlquilerCancha(id);
	}

	@GetMapping("/buscarPorParametros/{fecha}/{horaInicio}/{horaFin}/{idCancha}")
	public List<AlquilerCancha> buscarSocioPorDocumento(@PathVariable(value = "fecha") LocalDate fecha,
			@PathVariable(value = "horaInicio") LocalTime horaInicio,
			@PathVariable(value = "horaFin") LocalTime horaFin, @PathVariable(value = "idCancha") Long idCancha) {
		return alquilerCanchaServicio.buscarPorParametros(fecha, horaInicio, horaFin, idCancha);
	}

}

