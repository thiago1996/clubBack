package com.gestion.club.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.modelo.Partido;
import com.gestion.club.servicio.CategoriaServicio;
import com.gestion.club.servicio.PartidoServicio;

@RestController
@RequestMapping("/partido")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class PartidoControlador {

	@Autowired
	private PartidoServicio partidoServicio;

	@Autowired
	private CategoriaServicio categoriaServicio;

	@PostMapping("/nuevo")
	public Partido nuevoPartido(@RequestBody Partido nuevoPartido) {
		return this.partidoServicio.nuevoPartido(nuevoPartido);
	}

	@GetMapping("/mostrar")
	public Iterable<Partido> mostrarPartidos() {
		return partidoServicio.mostrarPartidos();

	}

	@GetMapping("/buscarPorParametros/{descripcion}/{idCategoria}/{cancha}/{fecha}")
	public Partido buscarPartidoPorParametros(@PathVariable(value ="descripcion") String descripcion, @PathVariable(value ="idCategoria") Long idCategoria, @PathVariable(value ="cancha") String cancha, @PathVariable(value ="fecha") LocalDate fecha) {
		return partidoServicio.buscarPartidoPorParametros(descripcion, idCategoria, cancha, fecha);
	}
	@PostMapping("/modificar")
	public Partido modificarPartido(@RequestBody Partido partido) {
		return this.partidoServicio.modificarPartido(partido);
	}

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> mostrarCategorias() {
		return new ResponseEntity<>(categoriaServicio.mostrarCategorias(), HttpStatus.OK);
	}

	@PostMapping(value = "/{id}")
	public void eliminarPartido(@PathVariable(value = "id") Long id) {
		this.partidoServicio.eliminarPartido(id);
	}
}
