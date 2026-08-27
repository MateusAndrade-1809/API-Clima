package com.clima.API_clima.dto;

public class ClimaDTO {

	private final String cidade;
	private final double temperatura;
	private final String unidadeTemperatura;
	private final double velocidadeVento;
	private final String unidadeVento;
	private final String horario;

	public ClimaDTO(String cidade, double temperatura, String unidadeTemperatura, double velocidadeVento, String unidadeVento,
			String horario) {
		this.cidade = cidade;
		this.temperatura = temperatura;
		this.unidadeTemperatura = unidadeTemperatura;
		this.velocidadeVento = velocidadeVento;
		this.unidadeVento = unidadeVento;
		this.horario = horario;
	}

	public String getCidade() {
		return cidade;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public String getUnidadeTemperatura() {
		return unidadeTemperatura;
	}

	public double getVelocidadeVento() {
		return velocidadeVento;
	}

	public String getUnidadeVento() {
		return unidadeVento;
	}

	public String getHorario() {
		return horario;
	}
}
