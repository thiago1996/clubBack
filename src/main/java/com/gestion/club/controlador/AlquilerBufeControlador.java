package com.gestion.club.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.AlquilerBufe;
import com.gestion.club.servicio.AlquilerBufeServicio;

@RestController
@RequestMapping("/alquilerBufe")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class AlquilerBufeControlador {

	@Autowired
	private AlquilerBufeServicio alquilerBufeServicio;

	@PostMapping("/nuevo")
	public AlquilerBufe nuevoAlquerBufé(@RequestBody AlquilerBufe nuevoAlquilerBufé) {
		return alquilerBufeServicio.nuevoAlquilerBufé(nuevoAlquilerBufé);
	}

	@GetMapping("/mostrar")
	public List<AlquilerBufe> mostrarAlquileresBufé() {
		return alquilerBufeServicio.mostrarAlquileresBufés();
	}

	@PostMapping("/modificar")
	public AlquilerBufe modificarAlquilerBufé(@RequestBody AlquilerBufe alquilerBufé) {
		return this.alquilerBufeServicio.modificarAlquilerBufé(alquilerBufé);
	}

	@PostMapping(value = "/{id}")
	public void eliminarAlquilerBufé(@PathVariable(value = "id") Long id) {
		this.alquilerBufeServicio.eliminarAlquilerBufé(id);
	}

	@GetMapping("/buscarPorParametros/{fecha}/{idBufe}")
	public List<AlquilerBufe> buscarBufePorParametros(@PathVariable(value = "fecha") LocalDate fecha,
			@PathVariable(value = "idBufe") Long idBufe) {
		return alquilerBufeServicio.buscarPorParametros(fecha, idBufe);
	}

}
