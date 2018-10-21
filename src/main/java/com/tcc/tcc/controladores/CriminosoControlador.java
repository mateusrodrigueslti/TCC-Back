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

import com.tcc.tcc.entidades.Criminoso;
import com.tcc.tcc.repositorios.CriminosoRepositorio;

@CrossOrigin("*")
@RestController
public class CriminosoControlador {

	@Autowired
	private CriminosoRepositorio criminosoReposiorio;
	
    @RequestMapping(value = "/criminoso", method = RequestMethod.POST)
    @ResponseBody
    public Criminoso save(@RequestBody Criminoso criminoso){

        return criminosoReposiorio.save(criminoso);
    }

    @RequestMapping(value = "/criminoso", method = RequestMethod.GET)
    @ResponseBody
    public List<Criminoso> getAll(){

        return (List<Criminoso>) criminosoReposiorio.findAll();
    }
    
    @RequestMapping(value = "/criminoso", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> apagar(@RequestParam(value="id", required=true) Long id){

    	try {

    		criminosoReposiorio.deleteById(id);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
}
