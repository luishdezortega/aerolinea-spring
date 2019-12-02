package com.aerolinea.api.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.api.business.ReservaBusiness;
import com.aerolinea.api.business.UsuarioBusiness;
import com.aerolinea.api.business.VueloBusiness;
import com.aerolinea.api.domain.Response;
import com.aerolinea.api.domain.UserDTO;
import com.aerolinea.api.model.Reserva;
import com.aerolinea.api.model.Vuelo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SwaggerDefinition(tags = { @Tag(name = "general", description = "RestController") })
public class AerolineaRest {

	private UsuarioBusiness userBusiness;

	private VueloBusiness vuelosBusiness;

	private ReservaBusiness reservBusiness;

	public AerolineaRest(UsuarioBusiness userBusiness, VueloBusiness vuelosBusiness, ReservaBusiness reservaBusiness) {
		super();
		this.userBusiness = userBusiness;
		this.vuelosBusiness = vuelosBusiness;
		this.reservBusiness = reservaBusiness;
	}

	@ApiOperation(value = "Permite crear un usuario", notes = "Crea un nuevo usuario en la base de datos"
			+ " sobre la tabla usuario, con base en el JSON recibido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiParam(name = "usuario", value = "JSON con la informacion del usuario", required = true, type = "userDTO")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "El usuario fue creado exitosamente", response = Response.class),
			@ApiResponse(code = 400, message = "Error en la creacion del usuario, debido a un error en los datos de la peticion recibida", response = Response.class),
			@ApiResponse(code = 500, message = "Error en la creacion del usuario, generado por un error en el servidor", response = Response.class) })
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Void> createUser(@RequestBody UserDTO userDTO) {
		return userBusiness.createUser(userDTO);
	}

	@ApiOperation(value = "Permite listar los vuelos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado de vuelos", response = Response.class),
			@ApiResponse(code = 400, message = "Error en la consulta de vuelos, debido a un error en los datos de la peticion recibida", response = Response.class),
			@ApiResponse(code = 500, message = "Error en la la consulta, generado por un error en el servidor", response = Response.class) })
	@GetMapping("/vuelos")
	public Response<List<Vuelo>> checkFlights() {
		return vuelosBusiness.checkFlight();
	}

	@ApiOperation(value = "Permite crear una reserva", notes = "Crea una reserva en la base de datos"
			+ " sobre la tabla reservas, con base en el JSON recibido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiParam(name = "usuario", value = "JSON con la informacion para la reserva", required = true, type = "UserReservaDTO")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Reserva creada exitosamente", response = Response.class),
			@ApiResponse(code = 400, message = "Error en la consulta, debido a un error en los datos de la peticion recibida", response = Response.class),
			@ApiResponse(code = 500, message = "Error en la la consulta, generado por un error en el servidor", response = Response.class) })
	@PostMapping("/reserva/create")
	public ResponseEntity<Response<Long>> createReservation(@RequestHeader String idVuelo,
			@RequestBody UserDTO userReserva) {
		return reservBusiness.createReservation(userReserva, idVuelo);
	}

	@ApiOperation(value = "Permite consultar una reserva", notes = "consulta de acuerdo la identificacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiParam(name = "identification", value = "Long", required = true, type = "Long")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosamente", response = Response.class),
			@ApiResponse(code = 400, message = "Error en la consulta, debido a un error en los datos de la peticion recibida", response = Response.class),
			@ApiResponse(code = 500, message = "Error en la la consulta, generado por un error en el servidor", response = Response.class) })
	@GetMapping("/reserva")
	public ResponseEntity<Response<List<Reserva>>> checkReserva(@RequestParam Long identification) {
		return reservBusiness.checkReservation(identification);
	}

}
