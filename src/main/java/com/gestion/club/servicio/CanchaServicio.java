package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Cancha;

public interface CanchaServicio {

	Cancha nuevaCancha(Cancha nuevaCancha);

	List<Cancha> mostrarCanchas();

	List<Cancha> mostrarCanchasPorNumero(int numero);

	Cancha modificarCancha(Cancha cancha);

	void eliminarCancha(Long idCancha);
}
