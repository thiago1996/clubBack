package com.gestion.club.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.club.modelo.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {

}
