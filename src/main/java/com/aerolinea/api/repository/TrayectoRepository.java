package com.aerolinea.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.api.model.Trayecto;

/**
 * Interface que permite realizar las operaciones CRUD sobre la entidad Trayecto
 * 
 * 
 * @author luis.hernandez
 *
 */
@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Long> {

}