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

import com.gestion.club.modelo.Bufe;
import com.gestion.club.servicio.BuféServicio;

@RestController
@RequestMapping("/bufe")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class BuféControlador {

	@Autowired
	private BuféServicio buféServicio;

	@PostMapping("/nuevo")
	public Bufe nuevoBufé(@RequestBody Bufe nuevoBufé) {
		return this.buféServicio.nuevoBufé(nuevoBufé);
	}

	@GetMapping("/mostrar")
	public Iterable<Bufe> mostrarBufés() {
		return buféServicio.mostrarBufés();
	}

	@GetMapping("/mostrar/{numeroBufe}")
	public List<Bufe> mostrarCanchasPorNumero(@PathVariable(value = "numeroBufe") int numeroBufe) {
		return buféServicio.mostrarBufésPorNumero(numeroBufe);
	}

	@PostMapping("/modificar")
	public Bufe modificarBufé(@RequestBody Bufe bufé) {
		return this.buféServicio.modificarBufé(bufé);
	}

	@PostMapping(value = "/{id}")
	public void eliminarBufé(@PathVariable(value = "id") Long id) {
		this.buféServicio.eliminarBufé(id);
	}

}
