package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Bufé;

public interface BuféRepositorio extends JpaRepository<Bufé, Long> {

	List<Bufé> findAllByNumero(int numero);
}
