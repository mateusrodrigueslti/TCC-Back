package com.tcc.tcc.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcc.tcc.entidades.Crime;

@Repository
public interface CrimeRepositorio  extends CrudRepository<Crime, Long>, CrimeRepositorioCustom {

}
