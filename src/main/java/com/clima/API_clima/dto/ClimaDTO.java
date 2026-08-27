package com.clima.API_clima.dto;

public class ClimaDTO {

	private String cidade;
	private String mensagem;

	public ClimaDTO(String cidade, String mensagem) {
		this.cidade = cidade;
		this.mensagem = mensagem;
	}

	public String getCidade() {
		return cidade;
	}

	public String getMensagem() {
		return mensagem;
	}
}
