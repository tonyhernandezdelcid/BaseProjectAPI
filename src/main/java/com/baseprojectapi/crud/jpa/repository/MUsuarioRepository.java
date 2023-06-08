package com.baseprojectapi.crud.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.baseprojectapi.crud.jpa.model.MUsuario;

public interface MUsuarioRepository extends MongoRepository<MUsuario, String> {
	


}
