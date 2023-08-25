package com.gestion.club.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.Socio;
import com.gestion.club.servicio.SocioServicio;

@RestController
@RequestMapping("/socio")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080
public class SocioControlador {

	@Autowired
	private SocioServicio socioServicio;

	@PostMapping("/nuevo")
	public Socio nuevoSocio(@RequestBody Socio nuevoSocio){
		return this.socioServicio.nuevoSocio(nuevoSocio);
	}

	@GetMapping("/mostrar")
	public Iterable<Socio> mostrarSocios() {
		return socioServicio.mostrarSocios();
	}

	@GetMapping("/buscarPorDocumento/{documento}")
	public Boolean buscarPorDocumento(@PathVariable(value = "documento") Long documento) {
		System.out.println("HOLA ACA ESTOY");
		System.out.println(socioServicio.buscarSocioPorDocumento(documento));
		return socioServicio.buscarSocioPorDocumento(documento);
	}

	@PostMapping("/modificar")
	public Socio modificarSocio(@RequestBody Socio socio){
		return this.socioServicio.modificarSocio(socio);
	}
	@PostMapping(value ="/{id}")
	public Boolean eliminarSocio(@PathVariable(value = "id") Long id){
		return this.socioServicio.eliminarSocio(id);
	}
}
