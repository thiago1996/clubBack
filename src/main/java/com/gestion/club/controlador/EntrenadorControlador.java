package com.gestion.club.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Entrenador;
import com.gestion.club.servicio.EntrenadorServicio;

@RestController
@RequestMapping("/entrenador")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class EntrenadorControlador {

	@Autowired
	private EntrenadorServicio entrenadorServicio;

	@PostMapping("/nuevo")
	public Entrenador nuevoEntrenador(@RequestBody Entrenador nuevoEntrenador){
		return this.entrenadorServicio.nuevoEntrenador(nuevoEntrenador);
	}

	@GetMapping("/mostrar")
	public Iterable<Entrenador> mostrarEntrenadores() {
		return entrenadorServicio.mostrarEntrenadores();
	}

	@GetMapping("/buscarPorDocumento/{documento}")
	public Boolean buscarPorDocumento(@PathVariable(value = "documento") Long documento) {

		return entrenadorServicio.buscarEntrenadorPorId(documento);

	}

	@GetMapping("/obtenerPorDocumento/{documento}")
	public Entrenador obtenerPorDocumento(@PathVariable(value = "documento") Long documento) {

		return entrenadorServicio.obtenerEntrenadorPorId(documento);

	}

	@PostMapping("/modificar")
	public Entrenador modificarEntrenador(@RequestBody Entrenador entrenador){
		return this.entrenadorServicio.modificarEntrenador(entrenador);
	}

	@PostMapping("/agregarCategoria/{id}")
	public Entrenador agregarCategoria(@PathVariable(value = "id") Long id, @RequestBody Long idCategoria ){
		return this.entrenadorServicio.agregarCategoria(id, idCategoria);
	}

	@PostMapping("/eliminarCategoria/{id}")
	public Entrenador eliminarCategoria(@PathVariable(value = "id") Long id, @RequestBody Long idCategoria) {
		return this.entrenadorServicio.eliminarCategoria(id, idCategoria);
	}

	@PostMapping(value ="/{id}")
	public Boolean eliminarEntrenador(@PathVariable(value = "id") Long id){
		return this.entrenadorServicio.eliminarEntrenador(id);
	}
}
