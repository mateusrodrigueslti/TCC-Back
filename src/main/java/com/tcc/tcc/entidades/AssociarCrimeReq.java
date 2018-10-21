package com.tcc.tcc.entidades;

import java.util.List;

import lombok.Data;

@Data
public class AssociarCrimeReq {

	private List<Long> criminososId;
	
	private Long ocorrenciaId;

}
