package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Bufé;
import com.gestion.club.repositorio.BuféRepositorio;

@Service

public class BuféServicioImpl implements BuféServicio {

	@Autowired
	private BuféRepositorio buféRepositorio;

	@Override
	public Bufé nuevoBufé(Bufé nuevoBufé) {
		return this.buféRepositorio.save(nuevoBufé);
	}

	@Override
	public List<Bufé> mostrarBufés() {
		return buféRepositorio.findAll();
	}

	@Override
	public List<Bufé> mostrarBufésPorNumero(int numero) {

		return buféRepositorio.findAllByNumero(numero);

	}

	@Override
	public Bufé modificarBufé(Bufé bufé) {

		Optional<Bufé> buféEncontrado = buféRepositorio.findById(bufé.getId());
		if (buféEncontrado.get() != null) {
			buféEncontrado.get().setNumero(bufé.getNumero());

			return this.nuevoBufé(buféEncontrado.get());
		}
		return null;
	}

	@Override
	public void eliminarBufé(Long idBufé) {

		buféRepositorio.deleteById(idBufé);
	}

}
