package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import com.gestion.club.modelo.AlquilerBufe;

public interface AlquilerBufeServicio {

	AlquilerBufe nuevoAlquilerBufé(AlquilerBufe alquilerBufé);

	List<AlquilerBufe> mostrarAlquileresBufés();

	List<AlquilerBufe> buscarPorParametros(LocalDate fecha, Long idBufe);

	void eliminarAlquilerBufé(Long idAlquilerBufé);

	AlquilerBufe modificarAlquilerBufé(AlquilerBufe alquilerBufé);
}
