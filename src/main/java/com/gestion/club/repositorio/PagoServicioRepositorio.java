package com.gestion.club.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.PagoServicio;

public interface PagoServicioRepositorio extends JpaRepository<PagoServicio, Long> {

	List<PagoServicio> findAllByDescripcionAndFecha(String descripcion, LocalDate fecha);

	List<PagoServicio> findAllByDescripcionAndFechaAndImporteAndMedioPago(String descripcion, LocalDate fecha,
			float importe, String medioPago);
}
