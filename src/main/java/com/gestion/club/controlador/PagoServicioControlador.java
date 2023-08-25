package com.gestion.club.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.club.modelo.PagoServicio;
import com.gestion.club.servicio.PagoServicioServicio;

@RestController
@RequestMapping("/pagoServicio")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
// para que la ruta frontend (4200) pueda acceder a nuestro backend en 8080

public class PagoServicioControlador {

	@Autowired
	private PagoServicioServicio pagoServicioServicio;

	@PostMapping("/nuevo")
	public PagoServicio nuevoPagoServicio(@RequestBody PagoServicio nuevoPagoServicio) {
		return this.pagoServicioServicio.nuevoPagoServicio(nuevoPagoServicio);
	}

	@GetMapping("/mostrar")
	public Iterable<PagoServicio> mostrarPagosServicio() {
		return pagoServicioServicio.mostrarPagosServicio();
	}

	@GetMapping("/mostrarPorDescripcionYFecha/{descripcion}/{fecha}")
	public Iterable<PagoServicio> mostrarPagosServicioPorDescripcionYFecha(
			@PathVariable(value = "descripcion") String descripcion, @PathVariable(value = "fecha") LocalDate fecha) {
		return pagoServicioServicio.mostrarPagoServicioPorDescripcionYFecha(descripcion, fecha);
	}

	@GetMapping("/mostrarPorDescripcionFechaImporteYMedioPago/{descripcion}/{fecha}/{importe}/{medioPago}")
	public Iterable<PagoServicio> mostrarPagosServicioPorDescripcionYFecha(
			@PathVariable(value = "descripcion") String descripcion, @PathVariable(value = "fecha") LocalDate fecha,
			@PathVariable(value = "importe") float importe, @PathVariable(value = "medioPago") String medioPago) {
		return pagoServicioServicio.mostrarPagoServicioPorDescripcionFechaImporteYMedioPago(descripcion, fecha, importe,
				medioPago);
	}

	@PostMapping("/modificar")
	public PagoServicio modificarPagoServicio(@RequestBody PagoServicio pagoServicio) {
		return this.pagoServicioServicio.modificarPagoServicio(pagoServicio);
	}

	@PostMapping(value = "/{id}")
	public void eliminarPagoServicio(@PathVariable(value = "id") Long id) {
		this.pagoServicioServicio.eliminarPagoServicio(id);
	}
}
