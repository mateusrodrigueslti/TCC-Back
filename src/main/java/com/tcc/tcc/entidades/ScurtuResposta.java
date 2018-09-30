package com.tcc.tcc.entidades;

import lombok.Data;

@Data
public class ScurtuResposta implements Comparable<ScurtuResposta> {
	
	private Long id;
	
	private String status;
	
	private Double result;
	
	private Criminoso criminoso;

	@Override
	public int compareTo(ScurtuResposta scurtuResposta) {
		
		if (this.result > scurtuResposta.getResult()) {
	          return -1;
	     }
	    
		if (this.result < scurtuResposta.getResult()) {
	          return 1;
	     }
		return 0;
	}
	
}
