package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Bufe;

public interface BuféServicio {

	Bufe nuevoBufé(Bufe nuevoBufé);

	List<Bufe> mostrarBufés();

	List<Bufe> mostrarBufésPorNumero(int numero);


	Bufe modificarBufé(Bufe bufé);

	void eliminarBufé(Long idBufé);

}
