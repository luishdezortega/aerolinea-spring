package com.aerolinea.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aerolinea.api.domain.VuelosDTO;
import com.aerolinea.api.model.Vuelo;

/**
 * Interface que permite realizar las operaciones CRUD sobre la entidad Vuelo O
 * 
 * @author luis.hernandez
 *
 */
@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

	@Query("select v.id, v.price,v.trayecto,v.avion from Vuelo v")
	Optional<List<VuelosDTO>> getFlight();

}