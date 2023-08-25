package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Socio;
import com.gestion.club.modelo.SocioCuota;
import com.gestion.club.modelo.SocioCuotaPk;
import com.gestion.club.repositorio.SocioCuotaRepositorio;
import com.gestion.club.repositorio.SocioRepositorio;

@Service

public class SocioCuotaServicioImpl implements SocioCuotaServicio{

	@Autowired
	private SocioCuotaRepositorio socioCuotaRepositorio;
	@Autowired
	private SocioRepositorio socioRepositorio;

	@Override
	public SocioCuota nuevoSocioCuota(Long id_cuota, Long id_socio, String nombre, String apellido, float precio,
			String medioPago, String fecha) {

		SocioCuota socioCuota = new SocioCuota();
		SocioCuotaPk socioCuotaPk = new SocioCuotaPk();
		socioCuotaPk = socioCuota.crearSocioCuotaPk(id_cuota, id_socio);

		socioCuota.setId(socioCuotaPk);
		socioCuota.setNombre(nombre);
		socioCuota.setApellido(apellido);
		socioCuota.setPrecio(precio);
		socioCuota.setMedioPago(medioPago);
		socioCuota.setFechaPago(LocalDate.parse(fecha));

		return socioCuotaRepositorio.save(socioCuota);
	}

	@Override
	public List<SocioCuota> mostrarSocioCuota() {
		return socioCuotaRepositorio.findAll();
	}

	@Override
	public List<Socio> mostrarSocios() {
		return socioRepositorio.findAll();
	}

	@Override
	public Socio buscarSocioPorDocumento(Long documento) {
		return socioRepositorio.findAllByDocumento(documento);
	}
	@Override
	public Boolean eliminarSocioCuota(Long id_cuota, Long id_socio) {

		SocioCuota socioCuota = new SocioCuota();
		SocioCuotaPk socioCuotaPk = new SocioCuotaPk();
		socioCuotaPk = socioCuota.crearSocioCuotaPk(id_cuota, id_socio);
		socioCuotaRepositorio.deleteById(socioCuotaPk);
		return true;
	}

	@Override
	public Boolean buscarPorId(Long id_cuota, Long documento) {

		SocioCuotaPk socioCuotaPk = new SocioCuotaPk();
		socioCuotaPk.setIdCuota(id_cuota);
		socioCuotaPk.setIdSocio(documento);
		List<SocioCuota> sociosCuotas;
		sociosCuotas = socioCuotaRepositorio.findAllByid(socioCuotaPk);
		if (sociosCuotas.size() > 0) {
			return true;
		}
		return false;
	}

	/*
	 * @Override public SocioCuota modificarSocioCuota(SocioCuota socioCuota) {
	 * 
	 * System.out.println(socioCuota); return socioCuota; socioCuotaRepositorio. }
	 */

}

