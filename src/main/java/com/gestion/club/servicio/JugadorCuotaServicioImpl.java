package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Jugador;
import com.gestion.club.modelo.JugadorCuota;
import com.gestion.club.modelo.JugadorCuotaPk;
import com.gestion.club.repositorio.JugadorCuotaRepositorio;
import com.gestion.club.repositorio.JugadorRepositorio;

@Service

public class JugadorCuotaServicioImpl implements JugadorCuotaServicio{

	@Autowired
	private JugadorCuotaRepositorio jugadorCuotaRepositorio;
	@Autowired
	private JugadorRepositorio jugadorRepositorio;


	@Override
	public JugadorCuota nuevoJugadorCuota(Long id_cuota, Long id_jugador, String nombre, String apellido, float precio,
			String medioPago,
			String fecha) {


		JugadorCuota jugadorCuota = new JugadorCuota();
		JugadorCuotaPk jugadorCuotaPk = new JugadorCuotaPk();
		jugadorCuotaPk = jugadorCuota.crearJugadorCuotaPk(id_cuota, id_jugador);

		jugadorCuota.setId(jugadorCuotaPk);
		jugadorCuota.setNombre(nombre);
		jugadorCuota.setApellido(apellido);
		jugadorCuota.setPrecio(precio);
		jugadorCuota.setMedioPago(medioPago);
		jugadorCuota.setFechaPago(LocalDate.parse(fecha));

		return jugadorCuotaRepositorio.save(jugadorCuota);
	}

	@Override
	public List<JugadorCuota> mostrarJugadorCuota() {
		return jugadorCuotaRepositorio.findAll();
	}


	@Override
	public List<Jugador> mostrarJugadores() {
		return jugadorRepositorio.findAll();
	}

	@Override
	public Jugador buscarJugadorPorDocumento(Long documento) {
		return jugadorRepositorio.findAllByDocumento(documento);
	}

	@Override
	public Boolean buscarPorId(Long id_cuota, Long documento) {

		JugadorCuotaPk jugadorCuotaPk = new JugadorCuotaPk();
		jugadorCuotaPk.setIdCuota(id_cuota);
		jugadorCuotaPk.setIdJugador(documento);
		List<JugadorCuota> jugadoresCuotas;
		jugadoresCuotas = jugadorCuotaRepositorio.findAllByid(jugadorCuotaPk);
		if (jugadoresCuotas.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean eliminarJugadorCuota(Long id_cuota, Long id_jugador) {

		JugadorCuota jugadorCuota = new JugadorCuota();
		JugadorCuotaPk jugadorCuotaPk = new JugadorCuotaPk();
		jugadorCuotaPk = jugadorCuota.crearJugadorCuotaPk(id_cuota, id_jugador);
		jugadorCuotaRepositorio.deleteById(jugadorCuotaPk);
		return true;
	}

}
