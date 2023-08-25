package com.gestion.club.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Entrenador;

public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {

	Entrenador findAllByDocumento(Long documento);
}
