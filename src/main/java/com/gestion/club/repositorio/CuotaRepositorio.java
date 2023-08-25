package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Cuota;

public interface CuotaRepositorio extends JpaRepository<Cuota, Long> {

	List<Cuota> findAllByAnioAndMes(int año, int mes);
}
