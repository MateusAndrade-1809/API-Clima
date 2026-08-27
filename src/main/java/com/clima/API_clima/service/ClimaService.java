package com.clima.API_clima.service;

import com.clima.API_clima.dto.ClimaDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

@Service
public class ClimaService {

	private static final String CIDADE = "Belo Horizonte - MG";
	private static final String OPEN_METEO_URL = "https://api.open-meteo.com/v1/forecast"
			+ "?latitude=-19.9167"
			+ "&longitude=-43.9345"
			+ "&current=temperature_2m,wind_speed_10m"
			+ "&timezone=auto";

	private final RestClient restClient = RestClient.create();

	public ClimaDTO buscarClimaAtual() {
		JsonNode resposta = restClient.get()
				.uri(OPEN_METEO_URL)
				.retrieve()
				.body(JsonNode.class);

		JsonNode climaAtual = resposta.path("current");
		JsonNode unidades = resposta.path("current_units");

		return new ClimaDTO(
				CIDADE,
				climaAtual.path("temperature_2m").asDouble(),
				unidades.path("temperature_2m").asString(),
				climaAtual.path("wind_speed_10m").asDouble(),
				unidades.path("wind_speed_10m").asString(),
				climaAtual.path("time").asString());
	}
}
