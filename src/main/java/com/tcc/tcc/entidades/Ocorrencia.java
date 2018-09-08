package com.tcc.tcc.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "ocorrencias")
public class Ocorrencia {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:mm")
    private Date hora;
}
