package com.gestion.club.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.SocioCuota;
import com.gestion.club.modelo.SocioCuotaPk;

public interface SocioCuotaRepositorio extends JpaRepository<SocioCuota, SocioCuotaPk> {

	List<SocioCuota> findAllByid(SocioCuotaPk id);

}
