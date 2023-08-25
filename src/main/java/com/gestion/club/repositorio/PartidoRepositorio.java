package com.gestion.club.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Categoria;
import com.gestion.club.modelo.Partido;

public interface PartidoRepositorio extends JpaRepository<Partido, Long> {

	List<Partido> findAllByDescripcionAndCategoriaAndCanchaAndFecha(String descripcion, Categoria categoria,
			String cancha, LocalDate fecha);
}
