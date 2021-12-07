package com.newton.av2.aawav2.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.av2.aawav2.domain.entity.MicroEmpresa;

public interface MicroEmpresaRepository extends MongoRepository<MicroEmpresa, String> {

}
