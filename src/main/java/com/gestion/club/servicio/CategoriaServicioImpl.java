package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio{

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Override
	public Categoria nuevaCategoria(Categoria nuevaCategoria)
	{
		return this.categoriaRepositorio.save(nuevaCategoria);
	}

	@Override
	public List<Categoria> mostrarCategorias()
	{
		return categoriaRepositorio.findAll();
	}

	@Override
	public List<Categoria> mostrarCategoriasPorParametros(String nombre, String tipo, String deporte)
	{

		return categoriaRepositorio.findAllByNombreAndTipoAndDeporte(nombre, tipo, deporte);

	}

	@Override
	public Categoria modificarCategoria(Categoria categoria) {

		Optional<Categoria> categoriaEncontrada = categoriaRepositorio.findById(categoria.getId());
		if(categoriaEncontrada .get() != null){
			categoriaEncontrada .get().setNombre(categoria.getNombre());
			categoriaEncontrada .get().setTipo(categoria.getTipo());
			categoriaEncontrada.get().setDeporte(categoria.getDeporte());


			return this.nuevaCategoria(categoriaEncontrada.get());
		}
		return null;
	}

	@Override
	public Boolean existeCategoria(Long id_categoria) {

		List<Categoria> categorias;
		categorias = categoriaRepositorio.findAllByid(id_categoria);
		if (categorias.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void eliminarCategoria(Long idCategoria) {

		categoriaRepositorio.deleteById(idCategoria);
	}
}