package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.JugadorCuota;
import com.gestion.club.modelo.JugadorCuotaPk;

public interface JugadorCuotaRepositorio extends JpaRepository<JugadorCuota, JugadorCuotaPk> {

	List<JugadorCuota> findAllByid(JugadorCuotaPk id);
}
