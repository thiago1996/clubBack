package com.gestion.club.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.repositorio.CategoriaRepositorio;
import com.gestion.club.repositorio.EntrenadorRepositorio;

@Service
public class EntrenadorServicioImpl implements EntrenadorServicio{

	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Override
	public Entrenador nuevoEntrenador(Entrenador nuevoEntrenador)
	{
		return this.entrenadorRepositorio.save(nuevoEntrenador);
	}

	@Override
	public Iterable<Entrenador> mostrarEntrenadores()
	{
		return this.entrenadorRepositorio.findAll();
	}

	@Override
	public Entrenador modificarEntrenador(Entrenador entrenador) {

		Optional<Entrenador> entrenadorEncontrado = this.entrenadorRepositorio.findById(entrenador.getDocumento());
		if(entrenadorEncontrado.get() != null){
			entrenadorEncontrado.get().setNombre(entrenador.getNombre());
			entrenadorEncontrado.get().setApellido(entrenador.getApellido());
			entrenadorEncontrado.get().setDomicilio(entrenador.getDomicilio());
			entrenadorEncontrado.get().setTelefono(entrenador.getTelefono());
			entrenadorEncontrado.get().setFechaNacimiento(entrenador.getFechaNacimiento());
			entrenadorEncontrado.get().setFechaAlta(entrenador.getFechaAlta());

			return this.nuevoEntrenador(entrenadorEncontrado.get());
		}
		return null;
	}

	@Override
	public Boolean eliminarEntrenador(Long idEntrenador) {

		this.entrenadorRepositorio.deleteById(idEntrenador);
		return true;
	}

	@Override
	public Entrenador agregarCategoria(Long documentoEntrenador, Long idCategoria)
	{
		Categoria categoria = categoriaRepositorio.findById(idCategoria).get();
		Entrenador entrenador = entrenadorRepositorio.findById(documentoEntrenador).get();

		entrenador.agregarCategoria(categoria);
		return this.nuevoEntrenador(entrenador);
	}

	@Override
	public Entrenador eliminarCategoria(Long documentoEntrenador, Long idCategoria) {
		Categoria categoria = categoriaRepositorio.findById(idCategoria).get();
		Entrenador entrenador = entrenadorRepositorio.findById(documentoEntrenador).get();

		entrenador.eliminarCategoria(categoria);
		return this.nuevoEntrenador(entrenador);
	}

	@Override
	public Boolean buscarEntrenadorPorId(Long idEntrenador) {

		Entrenador entrenador = new Entrenador();
		entrenador = this.entrenadorRepositorio.findAllByDocumento(idEntrenador);

		if (entrenador != null) {
			return true;

		}
		return false;
	}

	@Override
	public Entrenador obtenerEntrenadorPorId(Long idEntrenador) {

		return this.entrenadorRepositorio.findByDocumento(idEntrenador);

	}

}
