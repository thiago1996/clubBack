package com.gestion.club.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Socio;


public interface SocioRepositorio extends JpaRepository<Socio, Long> {

	Socio findAllByDocumento(Long documento);
}
