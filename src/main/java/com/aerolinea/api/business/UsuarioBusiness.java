package com.aerolinea.api.business;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.domain.UserDTO;

public interface UsuarioBusiness {

	Response<Void> createUser(UserDTO userDTO);

}
