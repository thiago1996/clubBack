package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Usuario;
import com.gestion.club.repositorio.UsuarioRepositorio;

@Service

public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Usuario nuevoUsuario(Usuario nuevoUsuario) {
		return this.usuarioRepositorio.save(nuevoUsuario);
	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public List<Usuario> mostrarUsuariosPorNombre(String nombre) {

		return usuarioRepositorio.findAllByNombre(nombre);
	}

	@Override
	public boolean buscarUsuario(String nombre, String contrasenia) {

		boolean control = false;
		List<Usuario> usuarios;

		usuarios = usuarioRepositorio.findAllByNombreAndContrasenia(nombre, contrasenia);

		if (usuarios.size() > 0) {
			control = true;
		}

		return control;
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {

		Optional<Usuario> usuarioEncontrado = usuarioRepositorio.findById(usuario.getId());
		if (usuarioEncontrado.get() != null) {
			usuarioEncontrado.get().setNombre(usuario.getNombre());
			usuarioEncontrado.get().setContrasenia(usuario.getContrasenia());
			usuarioEncontrado.get().setTipoUsuario(usuario.getTipoUsuario());

			return this.nuevoUsuario(usuarioEncontrado.get());
		}
		return null;
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {

		usuarioRepositorio.deleteById(idUsuario);
	}
}
