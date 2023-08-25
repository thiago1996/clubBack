package com.gestion.club.servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.gestion.club.modelo.AlquilerCancha;

public interface AlquilerCanchaServicio {

	AlquilerCancha nuevoAlquilerCancha(AlquilerCancha alquilerCancha);

	List<AlquilerCancha> mostrarAlquileresCancha();

	void eliminarAlquilerCancha(Long alquilerCancha);

	// AlquilerCancha buscarPorId(Long id);

	AlquilerCancha modificarAlquilerCancha(AlquilerCancha alquilerCancha);

	List<AlquilerCancha> buscarPorParametros(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Long idCancha);

}
