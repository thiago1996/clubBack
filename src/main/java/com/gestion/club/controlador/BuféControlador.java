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

import com.gestion.club.modelo.Bufé;
import com.gestion.club.servicio.BuféServicio;

@RestController
@RequestMapping("/bufe")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class BuféControlador {

	@Autowired
	private BuféServicio buféServicio;

	@PostMapping("/nuevo")
	public Bufé nuevoBufé(@RequestBody Bufé nuevoBufé) {
		return this.buféServicio.nuevoBufé(nuevoBufé);
	}

	@GetMapping("/mostrar")
	public Iterable<Bufé> mostrarBufés() {
		return buféServicio.mostrarBufés();
	}

	@GetMapping("/mostrar/{numero}")
	public List<Bufé> mostrarCanchasPorNumero(@PathVariable(value = "numero") int numero) {
		return buféServicio.mostrarBufésPorNumero(numero);
	}

	@PostMapping("/modificar")
	public Bufé modificarBufé(@RequestBody Bufé bufé) {
		return this.buféServicio.modificarBufé(bufé);
	}

	@PostMapping(value = "/{id}")
	public void eliminarBufé(@PathVariable(value = "id") Long id) {
		this.buféServicio.eliminarBufé(id);
	}

}
