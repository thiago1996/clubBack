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

import com.gestion.club.modelo.Categoria;
import com.gestion.club.servicio.CategoriaServicio;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class CategoriaControlador {

	@Autowired
	private CategoriaServicio categoriaServicio;

	@PostMapping("/nuevo")
	public Categoria nuevaCategoria(@RequestBody Categoria nuevaCategoria){
		return this.categoriaServicio.nuevaCategoria(nuevaCategoria);
	}

	@GetMapping("/mostrar")
	public Iterable<Categoria> mostrarCategorias() {
		return categoriaServicio.mostrarCategorias();
	}

	@GetMapping("/buscarPorId/{id}")
	public Boolean buscarCategoriaPorId(@PathVariable(value = "id") Long id) {
		return categoriaServicio.existeCategoria(id);
	}

	@GetMapping("/mostrar/{nombre}/{tipo}/{deporte}")
	public List<Categoria> mostrarCategoriasPorParametros(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "tipo") String tipo, @PathVariable(value = "deporte") String deporte) {
		return categoriaServicio.mostrarCategoriasPorParametros(nombre, tipo, deporte);
	}

	@PostMapping("/modificar")
	public Categoria modificarCategoria(@RequestBody Categoria categoria){
		return this.categoriaServicio.modificarCategoria(categoria);
	}
	@PostMapping(value ="/{id}")
	public void eliminarCategoria(@PathVariable(value = "id") Long id){
		this.categoriaServicio.eliminarCategoria(id);
	}
}