package com.tcc.tcc.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcc.tcc.entidades.Criminoso;

@Repository
public interface CriminosoRepositorio extends CrudRepository<Criminoso, Long> {

}
