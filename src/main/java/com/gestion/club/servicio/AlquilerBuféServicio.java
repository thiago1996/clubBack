package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import com.gestion.club.modelo.AlquilerBufé;

public interface AlquilerBuféServicio {

	AlquilerBufé nuevoAlquilerBufé(AlquilerBufé alquilerBufé);

	List<AlquilerBufé> mostrarAlquileresBufés();

	List<AlquilerBufé> buscarPorParametros(LocalDate fecha, Long idBufe);

	void eliminarAlquilerBufé(Long idAlquilerBufé);

	AlquilerBufé modificarAlquilerBufé(AlquilerBufé alquilerBufé);
}
