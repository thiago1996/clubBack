package com.gestion.club.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Jugador;

public interface JugadorRepositorio extends JpaRepository<Jugador, Long>{

	Jugador findAllByDocumento(Long documento);

}
