package com.aerolinea.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aerolinea.api.model.Usuario;

/**
 * Interface que permite realizar las operaciones CRUD sobre la entidad Usuario
 * 
 * 
 * @author luis.hernandez
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u.id from Usuario u where u.identification = :identification")
	Optional<Long> getIdUser(@Param("identification") Long id);

	@Query("select user from Usuario user where user.identification = :identification")
	Optional<Usuario> getUser(@Param("identification") Long identification);

}