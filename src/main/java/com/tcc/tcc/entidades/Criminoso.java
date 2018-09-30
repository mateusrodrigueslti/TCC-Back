package com.tcc.tcc.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "crimonosos")
public class Criminoso implements Serializable {
    
	private static final long serialVersionUID = -5349733951470544210L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Column
	private String nome;

	@Column
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	private LocalDate dataNascimento;

	@Column
	private String rg;

	@Column
	private String cpf;

	@Column
	private String profissao;

	@Column
	private String genero;

	@Column
	private String estadoCivil;

	@Column
	private String celular;

	@Column
	private String nomePai;

	@Column
	private String nomeMae;

	@Column
	private String nacionalidade;

	@Column
	private String naturalidade;

	@Column(columnDefinition = "TEXT")
	private String padraoAtuacaoCriminal;

}
