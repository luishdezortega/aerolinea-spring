package com.aerolinea.api.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.model.Vuelo;
import com.aerolinea.api.repository.VueloRepository;

@Service
public class VueloBusinessImpl implements VueloBusiness {

	private static final Logger logger = LoggerFactory.getLogger(VueloBusinessImpl.class);

	private final VueloRepository vueloRepository;

	public VueloBusinessImpl(VueloRepository vueloRepository) {
		this.vueloRepository = vueloRepository;

	}

	@Override
	public Response<List<Vuelo>> checkFlight() {

		logger.info("init consult of flight");
		List<Vuelo> vuelos;
		Response<List<Vuelo>> response = null;

		try {

			vuelos = vueloRepository.findAll();

			logger.info("finish consult of flight");
			response = new Response<>(HttpStatus.OK.value(), "Lista de vuelos", "", "", "", vuelos);

		} catch (Exception e) {
			logger.error("Error in the repositoty", e);
			response = new Response<>(HttpStatus.BAD_REQUEST.value(), "Error en la consulta", "", "", "");
		}

		return response;
	}

}
