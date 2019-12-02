package com.aerolinea.api.business;

import java.util.List;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.model.Vuelo;

public interface VueloBusiness {

	Response<List<Vuelo>> checkFlight();

}
