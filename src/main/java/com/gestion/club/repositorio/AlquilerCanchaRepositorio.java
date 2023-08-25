package com.gestion.club.repositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.AlquilerCancha;
import com.gestion.club.modelo.Cancha;

public interface AlquilerCanchaRepositorio extends JpaRepository<AlquilerCancha, Long> {

	List<AlquilerCancha> findAllByFechaAndHoraInicioAndHoraFinAndCancha(LocalDate fecha, LocalTime horaInicio,
			LocalTime horaFin, Cancha cancha);
}
