package com.aerolinea.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.api.model.Avion;

/**
 * Interface que permite realizar las operaciones CRUD sobre la entidad Avion
 * 
 * @author luis.hernandez
 *
 */
@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

}