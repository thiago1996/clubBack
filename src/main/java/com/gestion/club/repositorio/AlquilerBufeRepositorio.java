package com.gestion.club.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.AlquilerBufe;
import com.gestion.club.modelo.Bufe;

public interface AlquilerBufeRepositorio extends JpaRepository<AlquilerBufe, Long> {

	List<AlquilerBufe> findAllByFechaAndBufe(LocalDate fecha, Bufe bufe);

}
