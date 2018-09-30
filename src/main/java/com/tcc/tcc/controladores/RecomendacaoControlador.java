package com.tcc.tcc.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.tcc.entidades.ScurtuResposta;
import com.tcc.tcc.servicos.RecomendacaoService;

@CrossOrigin("*")
@RestController
public class RecomendacaoControlador {

	@Autowired
    private RecomendacaoService recomendacaoService;

	@RequestMapping(value = "/recomendacao", method = RequestMethod.GET)
    @ResponseBody
    public List<ScurtuResposta> gerarRecomendacaoDeCriminoso(@RequestParam(value="padraoCriminal", required=true) String padraoCriminal){
    	
        return recomendacaoService.gerar(padraoCriminal);
    }
}
