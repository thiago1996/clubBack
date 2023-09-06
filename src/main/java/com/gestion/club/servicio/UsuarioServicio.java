package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Usuario;

public interface UsuarioServicio {

	Usuario nuevoUsuario(Usuario nuevoUsuario);

	List<Usuario> mostrarUsuarios();

	List<Usuario> mostrarUsuariosPorNombre(String nombre);

	boolean buscarUsuario(String nombre, String contrasenia);

	Usuario modificarUsuario(Usuario usuario);

	void eliminarUsuario(Long idUsuario);
}
