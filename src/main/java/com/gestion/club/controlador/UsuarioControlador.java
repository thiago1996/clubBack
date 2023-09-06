package com.gestion.club.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Usuario;
import com.gestion.club.servicio.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@PostMapping("/nuevo")
	public Usuario nuevoUsuario(@RequestBody Usuario nuevoUsuario) {
		return this.usuarioServicio.nuevoUsuario(nuevoUsuario);
	}

	@GetMapping("/mostrar")
	public Iterable<Usuario> mostrarUsuarios() {
		return usuarioServicio.mostrarUsuarios();
	}

	@GetMapping("/mostrar/{nombre}")
	public List<Usuario> mostrarUsuariosPorNombre(@PathVariable(value = "nombre") String nombre) {
		return usuarioServicio.mostrarUsuariosPorNombre(nombre);
	}

	@GetMapping("/buscar/{nombre}/{contrasenia}")
	public boolean buscarUsuario(@PathVariable(value = "nombre") String nombre,
			@PathVariable(value = "contrasenia") String contrasenia) {
		return usuarioServicio.buscarUsuario(nombre, contrasenia);
	}

	@PostMapping("/modificar")
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioServicio.modificarUsuario(usuario);
	}

	@PostMapping(value = "/{id}")
	public void eliminarUsuario(@PathVariable(value = "id") Long id) {
		this.usuarioServicio.eliminarUsuario(id);
	}

}
