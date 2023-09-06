package com.gestion.club.servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.AlquilerCancha;
import com.gestion.club.modelo.Cancha;
import com.gestion.club.repositorio.AlquilerCanchaRepositorio;

@Service

public class AlquilerCanchaServicioImpl implements AlquilerCanchaServicio {

	@Autowired
	private AlquilerCanchaRepositorio alquilerCanchaRepositorio;

	@Override
	public AlquilerCancha nuevoAlquilerCancha(AlquilerCancha nuevoAlquilerCancha) {
		return alquilerCanchaRepositorio.save(nuevoAlquilerCancha);

	}

	@Override
	public List<AlquilerCancha> mostrarAlquileresCancha() {
		return alquilerCanchaRepositorio.findAll();
	}

	@Override
	public void eliminarAlquilerCancha(Long idAlquilerCancha) {

		alquilerCanchaRepositorio.deleteById(idAlquilerCancha);
	}

	@Override
	public List<AlquilerCancha> buscarPorParametros(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
			Long idCancha) {

		Cancha cancha = new Cancha();
		cancha.setId(idCancha);

		return alquilerCanchaRepositorio.findAllByFechaAndHoraInicioAndHoraFinAndCancha(fecha, horaInicio, horaFin,
				cancha);
	}


	@Override
	public AlquilerCancha modificarAlquilerCancha(AlquilerCancha alquilerCancha) {

		Optional<AlquilerCancha> alquilerCanchaEncontrado = this.alquilerCanchaRepositorio
				.findById(alquilerCancha.getId());
		if (alquilerCanchaEncontrado.get() != null) {
			alquilerCanchaEncontrado.get().setFecha(alquilerCancha.getFecha());
			alquilerCanchaEncontrado.get().setHoraInicio(alquilerCancha.getHoraInicio());
			alquilerCanchaEncontrado.get().setHoraFin(alquilerCancha.getHoraFin());
			alquilerCanchaEncontrado.get().setImporte(alquilerCancha.getImporte());
			alquilerCanchaEncontrado.get().setMedioPago(alquilerCancha.getMedioPago());
			alquilerCanchaEncontrado.get().setObservaciones(alquilerCancha.getObservaciones());

			return this.nuevoAlquilerCancha(alquilerCancha);
		}
		return null;
	}

}
