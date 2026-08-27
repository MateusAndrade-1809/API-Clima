package com.clima.API_clima.dto;

public class ErroDTO {

	private final String mensagem;
	private final String detalhe;

	public ErroDTO(String mensagem, String detalhe) {
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhe() {
		return detalhe;
	}
}
