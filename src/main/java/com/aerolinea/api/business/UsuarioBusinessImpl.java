package com.aerolinea.api.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aerolinea.api.domain.Response;
import com.aerolinea.api.domain.UserDTO;
import com.aerolinea.api.mapper.DomainMapper;
import com.aerolinea.api.repository.UsuarioRepository;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioBusinessImpl.class);

	private final UsuarioRepository userRepostory;

	private final DomainMapper mapper;

	public UsuarioBusinessImpl(UsuarioRepository userRepostory, DomainMapper mapper) {
		this.userRepostory = userRepostory;
		this.mapper = mapper;

	}

	@Override
	public Response<Void> createUser(UserDTO userDTO) {
		logger.info("Init create user with param: {}", userDTO);

		try {
			userRepostory.save(mapper.fromDtoToEntity(userDTO));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
