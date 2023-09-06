package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	List<Usuario> findAllByNombre(String nombre);

	List<Usuario> findAllByNombreAndContrasenia(String nombre, String contrasenia);
}
