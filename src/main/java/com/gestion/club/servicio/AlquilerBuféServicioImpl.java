package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.AlquilerBufé;
import com.gestion.club.modelo.Bufé;
import com.gestion.club.repositorio.AlquilerBuféRepositorio;

@Service

public class AlquilerBuféServicioImpl implements AlquilerBuféServicio {

	@Autowired
	private AlquilerBuféRepositorio alquilerBuféRepositorio;

	@Override
	public AlquilerBufé nuevoAlquilerBufé(AlquilerBufé nuevoAlquilerBufé) {
		return alquilerBuféRepositorio.save(nuevoAlquilerBufé);

	}

	@Override
	public List<AlquilerBufé> mostrarAlquileresBufés() {
		return alquilerBuféRepositorio.findAll();
	}

	@Override
	public void eliminarAlquilerBufé(Long idAlquilerBufé) {

		alquilerBuféRepositorio.deleteById(idAlquilerBufé);
	}

	@Override
	public List<AlquilerBufé> buscarPorParametros(LocalDate fecha, Long idBufe) {

		Bufé bufe = new Bufé();
		bufe.setId(idBufe);

		return alquilerBuféRepositorio.findAllByFechaAndBufe(fecha, bufe);
	}

	@Override
	public AlquilerBufé modificarAlquilerBufé(AlquilerBufé alquilerBufé) {

		Optional<AlquilerBufé> alquilerBuféEncontrado = this.alquilerBuféRepositorio.findById(alquilerBufé.getId());
		if (alquilerBuféEncontrado.get() != null) {
			alquilerBuféEncontrado.get().setFecha(alquilerBufé.getFecha());

			alquilerBuféEncontrado.get().setImporte(alquilerBufé.getImporte());
			alquilerBuféEncontrado.get().setMedioPago(alquilerBufé.getMedioPago());

			return this.nuevoAlquilerBufé(alquilerBufé);
		}
		return null;
	}

}
