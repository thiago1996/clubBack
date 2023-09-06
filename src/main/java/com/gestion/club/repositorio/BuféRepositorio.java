package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Bufe;

public interface BuféRepositorio extends JpaRepository<Bufe, Long> {

	List<Bufe> findAllByNumeroBufe(int numeroBufe);
}
