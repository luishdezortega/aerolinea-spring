package com.aerolinea.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aerolinea.api.model.Reserva;

/**
 * Interface que permite realizar las operaciones CRUD sobre la entidad Reserva
 * 
 * 
 * @author luis.hernandez
 *
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Query(value = "select * from reserva where reserva_id = (select reserva_id from Usuario_Reservas where usuario_id = :idUsuario)", nativeQuery = true)
	List<Reserva> findReservationByUsuario(@Param("idUsuario") Long idUsuario);

	@Query(value = "select count(*) from usuario usr join Usuario_Reservas ur on usr.usuario_id = ur.usuario_id join reserva r on r.reserva_id = ur.reserva_id join vuelo v on v.vuelo_id = r.vuelo_id_fk join trayecto t on t.trayecto_id = v.trayecto_id_fk where usr.identify_id= :identification and Date_format(t.hora_salida,'%Y/%m/%d')= Date_format((select t.hora_salida from trayecto t where t.trayecto_id = (select v.trayecto_id_fk from vuelo v where v.vuelo_id=:idVuelo)),'%Y/%m/%d')", nativeQuery = true)
	Long countReservation(@Param("identification") Long idUsuario, @Param("idVuelo") Long idVuelo);

}