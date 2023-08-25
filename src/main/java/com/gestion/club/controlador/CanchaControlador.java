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

import com.gestion.club.modelo.Cancha;
import com.gestion.club.servicio.CanchaServicio;

@RestController
@RequestMapping("/cancha")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class CanchaControlador {

	@Autowired
	private CanchaServicio canchaServicio;

	@PostMapping("/nueva")
	public Cancha nuevaCancha(@RequestBody Cancha nuevaCancha) {
		return this.canchaServicio.nuevaCancha(nuevaCancha);
	}

	@GetMapping("/mostrar")
	public Iterable<Cancha> mostrarCategorias() {
		return canchaServicio.mostrarCanchas();
	}

	@GetMapping("/mostrar/{numero}")
	public List<Cancha> mostrarCanchasPorNumero(@PathVariable(value = "numero") int numero) {
		return canchaServicio.mostrarCanchasPorNumero(numero);
	}

	@PostMapping("/modificar")
	public Cancha modificarCancha(@RequestBody Cancha cancha) {
		return this.canchaServicio.modificarCancha(cancha);
	}

	@PostMapping(value = "/{id}")
	public void eliminarCancha(@PathVariable(value = "id") Long id) {
		this.canchaServicio.eliminarCancha(id);
	}
}
