package com.gestion.club.servicio;

import java.util.List;

import com.gestion.club.modelo.Cuota;

public interface CuotaServicio {

	Cuota nuevaCuota(Cuota nuevaCuota);
	List<Cuota> mostrarCuotas();
	List<Cuota> mostrarCuotaPorParametros(int año, int mes);
	Boolean existeCuotaPorAnioYMes(int anio, int mes);
	Cuota modificarCuota(Cuota cuota);
	void eliminarCuota(Long idCuota);
}
