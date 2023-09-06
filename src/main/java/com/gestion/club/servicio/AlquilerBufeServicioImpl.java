package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.AlquilerBufe;
import com.gestion.club.modelo.Bufe;
import com.gestion.club.repositorio.AlquilerBufeRepositorio;

@Service

public class AlquilerBufeServicioImpl implements AlquilerBufeServicio {

	@Autowired
	private AlquilerBufeRepositorio alquilerBuféRepositorio;

	@Override
	public AlquilerBufe nuevoAlquilerBufé(AlquilerBufe nuevoAlquilerBufé) {
		return alquilerBuféRepositorio.save(nuevoAlquilerBufé);

	}

	@Override
	public List<AlquilerBufe> mostrarAlquileresBufés() {
		return alquilerBuféRepositorio.findAll();
	}

	@Override
	public void eliminarAlquilerBufé(Long idAlquilerBufé) {

		alquilerBuféRepositorio.deleteById(idAlquilerBufé);
	}

	@Override
	public List<AlquilerBufe> buscarPorParametros(LocalDate fecha, Long idBufe) {

		Bufe bufe = new Bufe();
		bufe.setId(idBufe);

		return alquilerBuféRepositorio.findAllByFechaAndBufe(fecha, bufe);
	}

	@Override
	public AlquilerBufe modificarAlquilerBufé(AlquilerBufe alquilerBufé) {

		Optional<AlquilerBufe> alquilerBuféEncontrado = this.alquilerBuféRepositorio.findById(alquilerBufé.getId());
		if (alquilerBuféEncontrado.get() != null) {
			alquilerBuféEncontrado.get().setFecha(alquilerBufé.getFecha());

			alquilerBuféEncontrado.get().setImporte(alquilerBufé.getImporte());
			alquilerBuféEncontrado.get().setMedioPago(alquilerBufé.getMedioPago());

			return this.nuevoAlquilerBufé(alquilerBufé);
		}
		return null;
	}

}
