package com.tcc.tcc.controladores;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.tcc.entidades.AssociarCrimeReq;
import com.tcc.tcc.entidades.Crime;
import com.tcc.tcc.entidades.Criminoso;
import com.tcc.tcc.entidades.Ocorrencia;
import com.tcc.tcc.entidades.ScurtuResposta;
import com.tcc.tcc.repositorios.CrimeRepositorio;
import com.tcc.tcc.repositorios.CriminosoRepositorio;
import com.tcc.tcc.repositorios.OcorrenciaRepositorio;
import com.tcc.tcc.servicos.RecomendacaoService;

import br.com.twsoftware.alfred.object.Objeto;

@CrossOrigin("*")
@RestController
public class RecomendacaoControlador {

	@Autowired
    private RecomendacaoService recomendacaoService;
	
	@Autowired
    private OcorrenciaRepositorio ocorrenciaRepositorio;
	
	@Autowired
    private CriminosoRepositorio criminosoRepositorio;
	
	@Autowired
	private CrimeRepositorio crimeRepositorio;

	@RequestMapping(value = "/recomendacao", method = RequestMethod.GET)
    @ResponseBody
    public List<ScurtuResposta> gerarRecomendacaoDeCriminoso(@RequestParam(value="padraoCriminal", required=true) String padraoCriminal, @RequestParam(value="ocorrenciaID", required=true) Long ocorrenciaID){
    	
        return recomendacaoService.gerar(padraoCriminal, ocorrenciaID);
    }
	
	@RequestMapping(value = "/recomendacao", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> associarCrime(@RequestBody AssociarCrimeReq associarCrimeReq){
    	
		Ocorrencia ocorrencia = this.ocorrenciaRepositorio.findById(associarCrimeReq.getOcorrenciaId()).orElse(null);
		
		if(Objeto.isBlank(ocorrencia)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado ocorrencia para o identificador: " + associarCrimeReq.getOcorrenciaId());
		}
		
		for (Long criminosoId : associarCrimeReq.getCriminososId()) {
			
			Criminoso criminoso = this.criminosoRepositorio.findById(criminosoId).orElse(null);
			
			if(Objeto.isBlank(criminoso)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado um criminoso para o identificador: " + criminosoId);
			}
			
			Crime crime = new Crime();
			crime.setCriminoso(criminoso);
			crime.setOcorrencia(ocorrencia);
			
			crimeRepositorio.save(crime);
		}
		return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "/recomendacao/crimes", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> buscarCrimes(@RequestParam(value="criminosoID", required=true) Long criminosoID){
		
		return ResponseEntity.status(HttpStatus.OK).body(crimeRepositorio.buscarCrimes(criminosoID));
		
	}
}
