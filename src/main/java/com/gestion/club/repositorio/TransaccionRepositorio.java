package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.club.modelo.AlquilerBufe;
import com.gestion.club.modelo.AlquilerCancha;
import com.gestion.club.modelo.Cuota;
import com.gestion.club.modelo.Entrenador;
import com.gestion.club.modelo.Jugador;
import com.gestion.club.modelo.PagoServicio;
import com.gestion.club.modelo.Partido;
import com.gestion.club.modelo.Socio;
import com.gestion.club.modelo.Transaccion;

public interface TransaccionRepositorio extends JpaRepository<Transaccion, Long> {

	List<Transaccion> findAllByPartido(Partido partido);

	List<Transaccion> findAllByPartidoAndTipo(Partido partido, String tipo);

	List<Transaccion> findAllByAlquilerBufe(AlquilerBufe alquilerBufe);

	List<Transaccion> findAllByAlquilerCancha(AlquilerCancha alquilerCancha);

	List<Transaccion> findAllByJugadorAndCuota(Jugador jugador, Cuota cuota);

	List<Transaccion> findAllBySocioAndCuota(Socio socio, Cuota cuota);

	List<Transaccion> findAllByPagoServicio(PagoServicio pagoServicio);

	List<Transaccion> findAllByCuotaAndEntrenador(Cuota cuota, Entrenador entrenador);

	@Query(
			value = "SELECT t.* FROM transaccion t, cuota c, jugador j WHERE t.id_cuota = c.id_cuota AND t.documento_jugador = j.documento_jugador ORDER by t.id_transaccion DESC;", nativeQuery = true)

	List<Transaccion> transaccionesCuotaJugador();



	@Query(
			value = "SELECT t.* FROM transaccion t, cuota c, entrenador e WHERE t.id_cuota = c.id_cuota AND t.documento_entrenador = e.documento_entrenador ORDER by t.id_transaccion DESC;", nativeQuery = true)

	List<Transaccion> transaccionesCuotaEntrenador();


	@Query(value = "SELECT t.* FROM transaccion t, cuota c, socio s WHERE t.id_cuota = c.id_cuota AND t.documento_socio = s.documento_socio ORDER by t.id_transaccion DESC;", nativeQuery = true)

	List<Transaccion> transaccionesCuotaSocio();

	@Query(value = "SELECT t.* FROM transaccion t, pago_servicio ps WHERE  t.id_pago_servicio = ps.id_pago_servicio ORDER by t.fecha DESC;", nativeQuery = true)

	List<Transaccion> transaccionesPagoServicio();

	@Query(value = "SELECT t.* FROM transaccion t, partido p WHERE t.id_partido = p.id_partido AND t.tipo = 'Ingreso' ORDER by t.fecha DESC;", nativeQuery = true)

	List<Transaccion> transaccionesPartidoIngreso();

	@Query(value = "SELECT t.* FROM transaccion t, partido p WHERE t.id_partido = p.id_partido AND t.tipo = 'Egreso' ORDER by t.fecha DESC;", nativeQuery = true)

	List<Transaccion> transaccionesPartidoEgreso();

	@Query(value = "SELECT t.* FROM transaccion t, alquiler_cancha ac WHERE t.id_alquiler_cancha = ac.id_alquiler_cancha ORDER by t.fecha DESC;", nativeQuery = true)

	List<Transaccion> transaccionesAlquilerCancha();

	@Query(value = "SELECT t.* FROM transaccion t, alquiler_bufe ab WHERE t.id_alquiler_bufe = ab.id_alquiler_bufe ORDER by t.fecha DESC;", nativeQuery = true)

	List<Transaccion> transaccionesAlquilerBufe();

}

