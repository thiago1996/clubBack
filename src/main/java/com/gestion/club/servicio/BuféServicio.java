package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Bufé;

public interface BuféServicio {

	Bufé nuevoBufé(Bufé nuevoBufé);

	List<Bufé> mostrarBufés();

	List<Bufé> mostrarBufésPorNumero(int numero);


	Bufé modificarBufé(Bufé bufé);

	void eliminarBufé(Long idBufé);

}
