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

import com.gestion.club.modelo.AlquilerBufé;
import com.gestion.club.servicio.AlquilerBuféServicio;

@RestController
@RequestMapping("/alquilerBufe")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class AlquilerBuféControlador {

	@Autowired
	private AlquilerBuféServicio alquilerBuféServicio;

	@PostMapping("/nuevo")
	public AlquilerBufé nuevoAlquerBufé(@RequestBody AlquilerBufé nuevoAlquilerBufé) {
		return alquilerBuféServicio.nuevoAlquilerBufé(nuevoAlquilerBufé);
	}

	@GetMapping("/mostrar")
	public List<AlquilerBufé> mostrarAlquileresBufé() {
		return alquilerBuféServicio.mostrarAlquileresBufés();
	}

	@PostMapping("/modificar")
	public AlquilerBufé modificarAlquilerBufé(@RequestBody AlquilerBufé alquilerBufé) {
		return this.alquilerBuféServicio.modificarAlquilerBufé(alquilerBufé);
	}

	@PostMapping(value = "/{id}")
	public void eliminarAlquilerBufé(@PathVariable(value = "id") Long id) {
		this.alquilerBuféServicio.eliminarAlquilerBufé(id);
	}

	@GetMapping("/buscarPorParametros/{fecha}/{idBufe}")
	public List<AlquilerBufé> buscarBufePorParametros(@PathVariable(value = "fecha") LocalDate fecha,
			@PathVariable(value = "idBufe") Long idBufe) {
		return alquilerBuféServicio.buscarPorParametros(fecha, idBufe);
	}

}
