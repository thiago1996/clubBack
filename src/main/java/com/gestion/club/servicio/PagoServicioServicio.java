package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import com.gestion.club.modelo.PagoServicio;

public interface PagoServicioServicio {

	PagoServicio nuevoPagoServicio(PagoServicio pagoServicio);

	List<PagoServicio> mostrarPagosServicio();

	List<PagoServicio> mostrarPagoServicioPorDescripcionYFecha(String descripcion, LocalDate fecha);

	List<PagoServicio> mostrarPagoServicioPorDescripcionFechaImporteYMedioPago(String descripcion, LocalDate fecha,
			float importe, String medioPago);

	PagoServicio modificarPagoServicio(PagoServicio pagoServicio);

	void eliminarPagoServicio(Long idPagoServicio);
}
