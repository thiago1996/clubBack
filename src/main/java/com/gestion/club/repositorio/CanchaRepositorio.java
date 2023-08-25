package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Cancha;

public interface CanchaRepositorio extends JpaRepository<Cancha, Long> {

	List<Cancha> findAllByNumero(int numero);
}
