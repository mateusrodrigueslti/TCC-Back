package com.tcc.tcc.repositorios;

import java.util.List;

import com.tcc.tcc.entidades.Ocorrencia;

public interface CrimeRepositorioCustom  {

	List<Ocorrencia> buscarCrimes(Long criminosoID);
}
