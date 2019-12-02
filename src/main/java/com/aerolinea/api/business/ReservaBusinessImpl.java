package com.aerolinea.api.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.domain.UserDTO;
import com.aerolinea.api.exception.ReservaException;
import com.aerolinea.api.model.Reserva;
import com.aerolinea.api.model.Usuario;
import com.aerolinea.api.model.Vuelo;
import com.aerolinea.api.repository.ReservaRepository;
import com.aerolinea.api.repository.UsuarioRepository;
import com.aerolinea.api.repository.VueloRepository;

@Service
public class ReservaBusinessImpl implements ReservaBusiness {

	private static final Logger logger = LoggerFactory.getLogger(ReservaBusinessImpl.class);

	private final ReservaRepository reservaRepository;

	private final VueloRepository vueloRepository;

	private final UsuarioRepository userRepostory;

	public ReservaBusinessImpl(ReservaRepository reservaRepository, VueloRepository vueloRepository,
			UsuarioRepository userRepostory) {
		this.reservaRepository = reservaRepository;
		this.vueloRepository = vueloRepository;
		this.userRepostory = userRepostory;

	}

	@Override
	public ResponseEntity<Response<Long>> createReservation(UserDTO userReservation, String idVuelo) {

		logger.info("Init create reservation with params {}", userReservation);
		ResponseEntity<Response<Long>> response = null;

		try {
			validateInfoReservation(userReservation, idVuelo);

			Reserva reserva = null;
			Usuario user = null;
			List<Reserva> reservasUsuario = null;

			validateInfoReservation(userReservation, idVuelo);

			Optional<Usuario> userSelected;
			userSelected = userRepostory.getUser(userReservation.getIdentification());

			if (userSelected.isPresent()) {

				if (reservaRepository.countReservation(userReservation.getIdentification(),
						Long.valueOf(idVuelo)) != 0) {
					throw new ReservaException("Ya realizo una reserva para este dia");
				}

				user = userSelected.get();
			} else {
				LocalDate dateNow = LocalDate.now();

				Period periodo = Period.between(
						userReservation.getDateBorn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
						dateNow);

				if (periodo.getYears() <= 18) {
					throw new ReservaException("Solo los mayores de edad pueden reservar");
				}
				user = new Usuario();
			}

			Optional<Vuelo> vueloSelected = vueloRepository.findById(Long.parseLong(idVuelo));
			if (vueloSelected.isPresent()) {

				reserva = new Reserva();
				reserva.setVuelo(vueloSelected.get());
				reserva.setFechaReserva(LocalDateTime.now());

				reservasUsuario = user.getReservas();

				if (reservasUsuario == null) {
					reservasUsuario = new ArrayList<>();
				}

				reservasUsuario.add(reserva);
				user.setName(userReservation.getName());
				user.setIdentification(userReservation.getIdentification());
				user.setNationality(userReservation.getNationality());
				user.setCellphone(userReservation.getCellphone());
				user.setReservas(reservasUsuario);
				user.setDateBorn(
						userReservation.getDateBorn().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

				reservaRepository.save(reserva);
				userRepostory.save(user);
				response = new ResponseEntity<>(
						new Response<>(HttpStatus.OK.value(), "Reserva exitosa", "", "", "", reserva.getId()),
						HttpStatus.OK);
			} else {
				throw new ReservaException("No se encontro el vuelo");
			}

		} catch (ReservaException e) {
			logger.info("create reservation failed for don´t pass the validations {}", e);
			response = new ResponseEntity<>(
					new Response<>(HttpStatus.BAD_REQUEST.value(), "No se pudo realizar la reseva", "", "", ""),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.info("create reservation failed internal {}", e);
			response = new ResponseEntity<>(new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"No se pudo realizar la reseva", "", "", ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public ResponseEntity<Response<List<Reserva>>> checkReservation(Long identification) {

		ResponseEntity<Response<List<Reserva>>> response = null;

		try {

			Long id = null;
			Optional<Long> idSelected = userRepostory.getIdUser(identification);

			if (idSelected.isPresent()) {
				id = idSelected.get();
			} else {
				throw new ReservaException("No se encontro el usuario");
			}
			List<Reserva> reservas = reservaRepository.findReservationByUsuario(id);
			
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


			reservas.stream().forEach(reserva -> {
				String dateTime = reserva.getFechaReserva().toString();
				reserva.setFechaReserva(LocalDateTime.parse(dateTime, formatter));
			});

			if (!reservas.isEmpty()) {

				response = new ResponseEntity<>(
						new Response<>(HttpStatus.OK.value(), "Reserva encontrada", "", "", "", reservas),
						HttpStatus.OK);

			} else {
				throw new ReservaException("No se encontraron reservas");
			}

		} catch (ReservaException e) {
			logger.info("create reservation failed {}", e);
			response = new ResponseEntity<>(
					new Response<>(HttpStatus.BAD_REQUEST.value(), "Reserva no encontrada", "", "", ""),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.info("create reservation failed {}", e);
			response = new ResponseEntity<>(
					new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Reserva no encontrada", "", "", ""),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	private void validateInfoReservation(UserDTO userDTO, String idVuelo) throws ReservaException {

		if (userDTO == null) {
			throw new ReservaException("inputs invalids");
		}

	}

}
