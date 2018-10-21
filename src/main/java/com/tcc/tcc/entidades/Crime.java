package com.tcc.tcc.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "crimes")
@Data
public class Crime implements Serializable  {

	private static final long serialVersionUID = -2079042939164115938L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ocorrencia_id")
	private Ocorrencia ocorrencia;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "criminoso_id")
	private Criminoso criminoso;
}
