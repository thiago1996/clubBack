package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Categoria;

public interface CategoriaServicio {

	Categoria nuevaCategoria(Categoria nuevaCategoria);
	List<Categoria> mostrarCategorias();

	List<Categoria> mostrarCategoriasPorParametros(String nombre, String tipo, String deporte);
	Categoria modificarCategoria(Categoria categoria);
	void eliminarCategoria(Long idCategoria);

	Boolean existeCategoria(Long id_categoria);
}