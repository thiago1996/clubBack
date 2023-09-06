package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Bufe;
import com.gestion.club.repositorio.BuféRepositorio;

@Service

public class BuféServicioImpl implements BuféServicio {

	@Autowired
	private BuféRepositorio buféRepositorio;

	@Override
	public Bufe nuevoBufé(Bufe nuevoBufé) {
		return this.buféRepositorio.save(nuevoBufé);
	}

	@Override
	public List<Bufe> mostrarBufés() {
		return buféRepositorio.findAll();
	}

	@Override
	public List<Bufe> mostrarBufésPorNumero(int numero) {

		return buféRepositorio.findAllByNumeroBufe(numero);

	}

	@Override
	public Bufe modificarBufé(Bufe bufé) {

		Optional<Bufe> buféEncontrado = buféRepositorio.findById(bufé.getId());
		if (buféEncontrado.get() != null) {
			buféEncontrado.get().setNumeroBufe(bufé.getNumeroBufe());

			return this.nuevoBufé(buféEncontrado.get());
		}
		return null;
	}

	@Override
	public void eliminarBufé(Long idBufé) {

		buféRepositorio.deleteById(idBufé);
	}

}
