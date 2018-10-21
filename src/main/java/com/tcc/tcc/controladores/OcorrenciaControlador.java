package com.tcc.tcc.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.tcc.entidades.Ocorrencia;
import com.tcc.tcc.repositorios.OcorrenciaRepositorio;

@CrossOrigin("*")
@RestController
public class OcorrenciaControlador {

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
    
    @RequestMapping(value = "/ocorrencia", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> apagar(@RequestParam(value="id", required=true) Long id){
    	
    	try {

    		ocorrenciaReposiorio.deleteById(id);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
}
