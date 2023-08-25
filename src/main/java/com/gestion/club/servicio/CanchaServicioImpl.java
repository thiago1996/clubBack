package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Cancha;
import com.gestion.club.repositorio.CanchaRepositorio;

@Service

public class CanchaServicioImpl implements CanchaServicio {

	@Autowired
	private CanchaRepositorio canchaRepositorio;

	@Override
	public Cancha nuevaCancha(Cancha nuevaCancha) {
		return this.canchaRepositorio.save(nuevaCancha);
	}

	@Override
	public List<Cancha> mostrarCanchas() {
		return canchaRepositorio.findAll();
	}

	@Override
	public List<Cancha> mostrarCanchasPorNumero(int numero) {

		return canchaRepositorio.findAllByNumero(numero);

	}

	@Override
	public Cancha modificarCancha(Cancha cancha) {

		Optional<Cancha> canchaEncontrada = canchaRepositorio.findById(cancha.getId());
		if (canchaEncontrada.get() != null) {
			canchaEncontrada.get().setNumero(cancha.getNumero());
			canchaEncontrada.get().setDescripcion(cancha.getDescripcion());

			return this.nuevaCancha(canchaEncontrada.get());
		}
		return null;
	}

	@Override
	public void eliminarCancha(Long idCancha) {

		canchaRepositorio.deleteById(idCancha);
	}
}
