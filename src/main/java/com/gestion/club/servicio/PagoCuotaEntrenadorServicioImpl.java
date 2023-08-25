package com.gestion.club.servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.modelo.PagoCuotaEntrenador;
import com.gestion.club.modelo.PagoCuotaEntrenadorPk;
import com.gestion.club.repositorio.EntrenadorRepositorio;
import com.gestion.club.repositorio.PagoCuotaEntrenadorRepositorio;

@Service
public class PagoCuotaEntrenadorServicioImpl implements PagoCuotaEntrenadorServicio{

	@Autowired
	private PagoCuotaEntrenadorRepositorio pagoCuotaEntrenadorRepositorio;

	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;

	@Override
	public PagoCuotaEntrenador nuevoPagoCuotaEntrenador(Long id_cuota, Long id_entrenador, String nombre,
			String apellido, float importe, String medioPago, String fecha) {
		PagoCuotaEntrenador pagoCuotaEntrenador = new PagoCuotaEntrenador();
		PagoCuotaEntrenadorPk pagoCuotaEntrenadorPk = new PagoCuotaEntrenadorPk();
		pagoCuotaEntrenadorPk = pagoCuotaEntrenador.crearPagoCuotaEntrenadorPk(id_cuota, id_entrenador);

		pagoCuotaEntrenador.setNombre(nombre);
		pagoCuotaEntrenador.setApellido(apellido);
		pagoCuotaEntrenador.setId(pagoCuotaEntrenadorPk);
		pagoCuotaEntrenador.setImporte(importe);
		pagoCuotaEntrenador.setMedioPago(medioPago);
		pagoCuotaEntrenador.setFechaPago(LocalDate.parse(fecha));

		return pagoCuotaEntrenadorRepositorio.save(pagoCuotaEntrenador);
	}
	@Override
	public List<PagoCuotaEntrenador> mostrarPagoCuotaEntrenador(){

		return pagoCuotaEntrenadorRepositorio.findAll();
	}

	@Override
	public Boolean eliminarPagoCuotaEntrenador(Long id_cuota, Long id_entrenador){

		PagoCuotaEntrenador pagoCuotaEntrenador = new PagoCuotaEntrenador();
		PagoCuotaEntrenadorPk pagoCuotaEntrenadorPk = new PagoCuotaEntrenadorPk();
		pagoCuotaEntrenadorPk = pagoCuotaEntrenador.crearPagoCuotaEntrenadorPk(id_cuota, id_entrenador);
		pagoCuotaEntrenadorRepositorio.deleteById(pagoCuotaEntrenadorPk);
		return true;
	}

	@Override
	public Boolean buscarSiExisteCuota(Cuota cuota) {

		List<PagoCuotaEntrenador> sociosCuotas;
		sociosCuotas = pagoCuotaEntrenadorRepositorio.findAllByCuota(cuota);
		if (sociosCuotas.size() > 0) {
			return true;
		}
		return false;
	}
	/*
	 * @Override public Boolean buscarSiExisteCuotaYDocumento(Cuota cuota, Long
	 * documento) {
	 * 
	 * List<PagoCuotaEntrenador> sociosCuotas; sociosCuotas =
	 * pagoCuotaEntrenadorRepositorio.findAllByCuotaAndidEntrenador(cuota,
	 * documento); if (sociosCuotas.size() > 0) { return true; } return false; }
	 */

	@Override
	public Boolean buscarPorId(Long id_cuota, Long documento) {

		PagoCuotaEntrenadorPk pagoCuotaEntrenadorPk = new PagoCuotaEntrenadorPk();
		pagoCuotaEntrenadorPk.setIdCuota(id_cuota);
		pagoCuotaEntrenadorPk.setIdEntrenador(documento);
		List<PagoCuotaEntrenador> entrenadoresCuotas;
		entrenadoresCuotas = pagoCuotaEntrenadorRepositorio.findAllByid(pagoCuotaEntrenadorPk);
		if (entrenadoresCuotas.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Entrenador> mostrarEntrenadores(){

		return this.entrenadorRepositorio.findAll();
	}

	@Override
	public Entrenador buscarEntrenadorPorDocumento(Long documento) {
		return entrenadorRepositorio.findAllByDocumento(documento);
	}
}
