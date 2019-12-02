package com.aerolinea.api.business;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.domain.UserDTO;
import com.aerolinea.api.model.Reserva;

public interface ReservaBusiness {

	ResponseEntity<Response<Long>> createReservation(UserDTO userReservation, String idVuelo);

	ResponseEntity<Response<List<Reserva>>> checkReservation(Long reservaId);

}
