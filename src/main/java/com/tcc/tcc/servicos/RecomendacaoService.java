package com.tcc.tcc.servicos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.tcc.entidades.Criminoso;
import com.tcc.tcc.entidades.Ocorrencia;
import com.tcc.tcc.entidades.ScurtuResposta;
import com.tcc.tcc.repositorios.CrimeRepositorio;
import com.tcc.tcc.repositorios.CriminosoRepositorio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecomendacaoService {

	@Autowired
	private CriminosoRepositorio criminosoRepositorio;
	
	@Autowired
	private CrimeRepositorio crimeRepositorio;
	
	private ScurtuResposta scurtuResposta;

	public List<ScurtuResposta> gerar(String padraoCriminal, Long ocorrenciaID) {

		List<Criminoso> criminosos = (List<Criminoso>) criminosoRepositorio.findAll();
		
		List<ScurtuResposta> scurtuRespostas = new ArrayList<>();
		
		for (Criminoso criminoso : criminosos) {

			ScurtuResposta resposta = compararPadroesCriminais(criminoso.getPadraoAtuacaoCriminal(), padraoCriminal);
			
			List<Ocorrencia> ocorrencias = this.crimeRepositorio.buscarCrimes(criminoso.getId());
			
			for (Ocorrencia ocorrencia : ocorrencias) {
				
				if(ocorrencia.getId() == ocorrenciaID) {
					resposta.setParticipouCrime(true);
				}
			}
			
			resposta.setCriminoso(criminoso);
			scurtuRespostas.add(resposta);
		}
		
		Collections.sort(scurtuRespostas);
		
		return scurtuRespostas;

	}

	private ScurtuResposta compararPadroesCriminais(String padraoAtuacaoCriminal, String padraoCriminal) {

		String urlToCall = "http://www.scurtu.it/apis/documentSimilarity";

		String content = "doc1=" + URLEncoder.encode(padraoAtuacaoCriminal) + "&doc2=" + URLEncoder.encode(padraoCriminal);
		
		try {
			
			URL url = new URL(urlToCall);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "text/plain");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();

			DataOutputStream output = new DataOutputStream(connection.getOutputStream());
			output.writeBytes(content);
			output.flush();
			output.close();

			StringBuilder strBuffer = new StringBuilder();
			String str = null;
			DataInputStream input = new DataInputStream(connection.getInputStream());
			
			while (null != ((str = input.readLine()))) {
				strBuffer.append(str);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			scurtuResposta = mapper.readValue(strBuffer.toString(), ScurtuResposta.class);
			
		} catch (MalformedURLException e) {
			
			log.error(e.getMessage());
			
		} catch (ProtocolException e) {
		
			log.error(e.getMessage());
			
		} catch (IOException e) {

			log.error(e.getMessage());
		}
		
		return scurtuResposta;
	}
}
