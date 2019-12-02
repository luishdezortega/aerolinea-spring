package com.aerolinea.api.mapper;

import org.springframework.stereotype.Component;

import com.aerolinea.api.domain.UserDTO;
import com.aerolinea.api.model.Usuario;

@Component
public class DomainMapper {

	public Usuario fromDtoToEntity(UserDTO userDTO) {
		Usuario user = new Usuario();

		user.setName(userDTO.getName());
		user.setNationality(userDTO.getNationality());
		user.setCellphone(userDTO.getCellphone());

		return user;
	}



}
