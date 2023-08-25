package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.PagoServicio;
import com.gestion.club.repositorio.PagoServicioRepositorio;

@Service

public class PagoServicioServicioImpl implements PagoServicioServicio {

	@Autowired
	private PagoServicioRepositorio pagoServicioRepositorio;

	@Override
	public PagoServicio nuevoPagoServicio(PagoServicio nuevoPagoServicio) {
		return this.pagoServicioRepositorio.save(nuevoPagoServicio);
	}

	@Override
	public List<PagoServicio> mostrarPagosServicio() {
		return pagoServicioRepositorio.findAll();
	}

	@Override
	public List<PagoServicio> mostrarPagoServicioPorDescripcionYFecha(String descripcion, LocalDate fecha) {
		return pagoServicioRepositorio.findAllByDescripcionAndFecha(descripcion, fecha);
	}

	@Override
	public List<PagoServicio> mostrarPagoServicioPorDescripcionFechaImporteYMedioPago(String descripcion,
			LocalDate fecha, float importe, String medioPago) {
		return pagoServicioRepositorio.findAllByDescripcionAndFechaAndImporteAndMedioPago(descripcion, fecha, importe,
				medioPago);
	}

	@Override
	public PagoServicio modificarPagoServicio(PagoServicio pagoServicio) {

		Optional<PagoServicio> pagoServicioEncontrado = pagoServicioRepositorio.findById(pagoServicio.getId());
		if (pagoServicioEncontrado.get() != null) {
			pagoServicioEncontrado.get().setDescripcion(pagoServicio.getDescripcion());
			pagoServicioEncontrado.get().setFecha(pagoServicio.getFecha());
			pagoServicioEncontrado.get().setImporte(pagoServicio.getImporte());
			pagoServicioEncontrado.get().setMedioPago(pagoServicio.getMedioPago());

			return this.nuevoPagoServicio(pagoServicioEncontrado.get());
		}
		return null;
	}

	@Override
	public void eliminarPagoServicio(Long idPagoServicio) {

		pagoServicioRepositorio.deleteById(idPagoServicio);
	}


}
