package com.gestion.club.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.club.modelo.Cuota;
import com.gestion.club.repositorio.CuotaRepositorio;

@Service
public class CuotaServicioImpl implements CuotaServicio {

	@Autowired
	private CuotaRepositorio cuotaRepositorio;
	@Override
	public Cuota nuevaCuota(Cuota nuevaCuota)
	{
		return this.cuotaRepositorio.save(nuevaCuota);
	}

	@Override
	public List<Cuota> mostrarCuotas()
	{
		return cuotaRepositorio.findAll();
	}

	@Override
	public List<Cuota> mostrarCuotaPorParametros(int año, int mes)
	{
		return cuotaRepositorio.findAllByAnioAndMes(año, mes);
	}

	@Override
	public Boolean existeCuotaPorAnioYMes(int anio, int mes) {

		List<Cuota> cuotas;
		cuotas = this.cuotaRepositorio.findAllByAnioAndMes(anio, mes);

		if (cuotas.size() > 0) {
			return true;

		}
		return false;
	}


	@Override
	public Cuota modificarCuota(Cuota cuota) {

		Optional<Cuota> cuotaEncontrada = cuotaRepositorio.findById(cuota.getId_cuota());
		if(cuotaEncontrada .get() != null){
			cuotaEncontrada .get().setAnio(cuota.getAnio());
			cuotaEncontrada .get().setMes(cuota.getMes());

			return this.nuevaCuota(cuotaEncontrada.get());
		}
		return null;
	}

	@Override
	public void eliminarCuota(Long idCuota) {

		cuotaRepositorio.deleteById(idCuota);
	}
}
