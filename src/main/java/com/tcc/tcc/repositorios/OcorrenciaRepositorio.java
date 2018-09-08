package com.tcc.tcc.repositorios;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcc.tcc.entidades.Ocorrencia;

@Repository
public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {

}
