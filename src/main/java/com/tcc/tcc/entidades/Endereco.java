package com.tcc.tcc.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enderecos")
public class Endereco implements Serializable{

	private static final long serialVersionUID = -5254945212459711202L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String logradouro;

    @Column
    private String cep;

    @Column
    private String complemento;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String uf;
    
    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Criminoso criminoso;
    
    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Ocorrencia ocorrencia;
}
