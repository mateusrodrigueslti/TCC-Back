package com.tcc.tcc.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private LocalDate data;

	@DateTimeFormat(iso = ISO.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HHmm")
    private LocalTime hora;
	
    @OneToMany(mappedBy = "ocorrencia", fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Crime> crime;
}
