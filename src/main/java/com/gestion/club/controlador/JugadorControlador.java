package com.gestion.club.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.modelo.Jugador;
import com.gestion.club.servicio.CategoriaServicio;
import com.gestion.club.servicio.JugadorServicio;

@RestController
@RequestMapping("/jugador")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class JugadorControlador {

	@Autowired
	private JugadorServicio jugadorServicio;

	@Autowired
	private CategoriaServicio categoriaServicio;

	@PostMapping("/nuevo")
	public ResponseEntity<Jugador> nuevoJugador(@RequestBody Jugador nuevoJugador){
		return new ResponseEntity<>(jugadorServicio.nuevoJugador(nuevoJugador), HttpStatus.CREATED);
	}

	@GetMapping("/mostrar")
	public ResponseEntity<List<Jugador>> mostrarJugadores() {
		return new ResponseEntity<>(jugadorServicio.mostrarJugadores(), HttpStatus.OK);
	}

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> mostrarCategorias() {
		return new ResponseEntity<>(categoriaServicio.mostrarCategorias(), HttpStatus.OK);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<Jugador> modificarJugador(@PathVariable Long id, @RequestBody Jugador jugador){

		Jugador jugadorEncontrado = jugadorServicio.buscarPorId(id);

		if(jugadorEncontrado == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {
			jugadorEncontrado.setNombre(jugador.getNombre());
			jugadorEncontrado.setApellido(jugador.getApellido());
			jugadorEncontrado.setCategoria(jugador.getCategoria());
			jugadorEncontrado.setDomicilio(jugador.getDomicilio());
			jugadorEncontrado.setTelefono(jugador.getTelefono());
			jugadorEncontrado.setFechaNacimiento(jugador.getFechaNacimiento());
			jugadorEncontrado.setFechaAlta(jugador.getFechaAlta());

			return new ResponseEntity<>(jugadorServicio.nuevoJugador(jugadorEncontrado), HttpStatus.CREATED);
		} catch(DataAccessException e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

		@GetMapping("/buscarPorDocumento/{documento}")
		public Boolean buscarPorDocumento(@PathVariable(value = "documento") Long documento) {

			return jugadorServicio.buscarJugadorPorDocumento(documento);
		}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?>eliminarJugador(@PathVariable Long id){
		jugadorServicio.eliminarJugador(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
