package controller;

import Requisicao.FazerRequisicao;

public class ParlamentarController {
	
	FazerRequisicao fazerRequisicao;
	
	public ParlamentarController(){
		
		fazerRequisicao = new FazerRequisicao();
	
	}
	
	public String requisicao(String nome){
		
		String url;
		String resposta;
		
		url = "http://127.0.0.1:3306/OlhaMinhaMesadaServer/parlamentar?nome=" + nome;
		resposta = fazerRequisicao.fazerRequisicao(url);
		
		return resposta;
		
	}
	

}
