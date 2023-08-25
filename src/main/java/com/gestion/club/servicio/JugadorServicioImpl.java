package com.gestion.club.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Jugador;
import com.gestion.club.repositorio.JugadorRepositorio;

@Service

public class JugadorServicioImpl implements JugadorServicio{

	@Autowired
	private JugadorRepositorio jugadorRepositorio;
	@Override
	public Jugador nuevoJugador(Jugador nuevoJugador)
	{
		return jugadorRepositorio.save(nuevoJugador);
	}

	@Override
	public List<Jugador> mostrarJugadores()
	{
		return jugadorRepositorio.findAll();
	}

	@Override
	public Jugador buscarPorId(Long id){

		return jugadorRepositorio.findById(id).orElse(null);
	}

	@Override
	public Boolean buscarJugadorPorDocumento(Long idJugador) {

		Jugador jugador = new Jugador();
		jugador = this.jugadorRepositorio.findAllByDocumento(idJugador);

		if (jugador != null) {
			return true;

		}
		return false;
	}

	@Override
	public void eliminarJugador(Long idJugador) {

		jugadorRepositorio.deleteById(idJugador);
	}

}
