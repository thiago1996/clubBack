package com.gestion.club.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.AlquilerBufé;
import com.gestion.club.modelo.Bufé;

public interface AlquilerBuféRepositorio extends JpaRepository<AlquilerBufé, Long> {

	List<AlquilerBufé> findAllByFechaAndBufe(LocalDate fecha, Bufé bufe);

}
