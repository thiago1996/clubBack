package com.gestion.club.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Socio;
import com.gestion.club.repositorio.SocioRepositorio;

@Service

public class SocioServicioImpl implements SocioServicio {

	@Autowired
	private SocioRepositorio socioRepositorio;
	@Override
	public Socio nuevoSocio(Socio nuevoSocio)
	{
		return this.socioRepositorio.save(nuevoSocio);
	}

	@Override
	public Iterable<Socio> mostrarSocios()
	{
		return this.socioRepositorio.findAll();
	}

	@Override
	public Socio modificarSocio(Socio socio) {

		Optional<Socio> socioEncontrado = this.socioRepositorio.findById(socio.getDocumento());
		if(socioEncontrado.get() != null){
			socioEncontrado.get().setNombre(socio.getNombre());
			socioEncontrado.get().setApellido(socio.getApellido());
			socioEncontrado.get().setDomicilio(socio.getDomicilio());
			socioEncontrado.get().setTelefono(socio.getTelefono());
			socioEncontrado.get().setFechaNacimiento(socio.getFechaNacimiento());
			socioEncontrado.get().setFechaAsociacion(socio.getFechaAsociacion());

			return this.nuevoSocio(socioEncontrado.get());
		}
		return null;
	}

	@Override
	public Boolean eliminarSocio(Long idSocio) {

		this.socioRepositorio.deleteById(idSocio);
		return true;
	}

	@Override
	public Boolean buscarSocioPorDocumento(Long idSocio) {

		Socio socio = new Socio();
		socio = this.socioRepositorio.findAllByDocumento(idSocio);

		if (socio != null) {
			return true;

		}
		return false;
	}

}