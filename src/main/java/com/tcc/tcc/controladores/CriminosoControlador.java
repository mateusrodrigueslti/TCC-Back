package com.tcc.tcc.controladores;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.tcc.entidades.Ocorrencia;
import com.tcc.tcc.repositorios.OcorrenciaRepositorio;

@CrossOrigin("*")
@RestController
public class CriminosoControlador {

	@Autowired
	private OcorrenciaRepositorio ocorrenciaReposiorio;
	
    @RequestMapping(value = "/ocorrencia", method = RequestMethod.POST)
    @ResponseBody
    public Ocorrencia save(@RequestBody Ocorrencia ocorrencia){

        return ocorrenciaReposiorio.save(ocorrencia);
    }

    @RequestMapping(value = "/ocorrencia", method = RequestMethod.GET)
    @ResponseBody
    public List<Ocorrencia> getAll(){

        return (List<Ocorrencia>) ocorrenciaReposiorio.findAll();
    }
}
