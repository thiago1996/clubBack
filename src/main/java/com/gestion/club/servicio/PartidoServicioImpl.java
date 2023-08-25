package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.modelo.Partido;
import com.gestion.club.repositorio.CanchaRepositorio;
import com.gestion.club.repositorio.CategoriaRepositorio;
import com.gestion.club.repositorio.PartidoRepositorio;

@Service

public class PartidoServicioImpl implements PartidoServicio {

	@Autowired
	private PartidoRepositorio partidoRepositorio;

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Autowired
	private CanchaRepositorio canchaRepositorio;

	@Override
	public Partido nuevoPartido(Partido nuevoPartido) {
		return this.partidoRepositorio.save(nuevoPartido);
	}

	@Override
	public List<Partido> mostrarPartidos() {
		return partidoRepositorio.findAll();
	}

	@Override
	public Partido buscarPartidoPorParametros(String descripcion, Long idCategoria, String cancha, LocalDate fecha) {

		Optional<Categoria> categoria = categoriaRepositorio.findById(idCategoria);

		List<Partido> partidos;
		partidos = partidoRepositorio.findAllByDescripcionAndCategoriaAndCanchaAndFecha(descripcion, categoria.get(),
				cancha, fecha);

		return partidos.get(0);
	}


	@Override
	public Partido modificarPartido(Partido partido) {

		Optional<Partido> partidoEncontrado = partidoRepositorio.findById(partido.getId());
		if (partidoEncontrado.get() != null) {
			partidoEncontrado.get().setDescripcion(partido.getDescripcion());
			partidoEncontrado.get().setCategoria(partido.getCategoria());
			partidoEncontrado.get().setCancha(partido.getCancha());
			partidoEncontrado.get().setFecha(partido.getFecha());
			partidoEncontrado.get().setIngresoEntradas(partido.getIngresoEntradas());
			partidoEncontrado.get().setGastoArbitros(partido.getGastoArbitros());
			partidoEncontrado.get().setGastoMedicos(partido.getGastoMedicos());
			partidoEncontrado.get().setGastoSeguridad(partido.getGastoSeguridad());
			partidoEncontrado.get().setGastoExtra(partido.getGastoExtra());
			partidoEncontrado.get().setObservaciones(partido.getObservaciones());

			return this.nuevoPartido(partidoEncontrado.get());
		}
		return null;
	}

	@Override
	public void eliminarPartido(Long idPartido) {

		partidoRepositorio.deleteById(idPartido);

	}
}
