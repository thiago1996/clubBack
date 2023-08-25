package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

	List<Categoria> findAllByNombreAndTipoAndDeporte(String nombre, String tipo, String deporte);

	List<Categoria> findAllByid(Long id);
}
