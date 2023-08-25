package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.PagoCuotaEntrenador;
import com.gestion.club.modelo.PagoCuotaEntrenadorPk;

public interface PagoCuotaEntrenadorRepositorio extends JpaRepository<PagoCuotaEntrenador, PagoCuotaEntrenadorPk> {

	List<PagoCuotaEntrenador> findAllByCuota(Cuota cuota);

	// List<PagoCuotaEntrenador> findAllByCuotaAndidEntrenador(Cuota cuota, Long
	// idEntrenador);
	List<PagoCuotaEntrenador> findAllByid(PagoCuotaEntrenadorPk id);
}
