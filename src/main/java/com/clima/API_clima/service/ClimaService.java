package com.clima.API_clima.service;

import com.clima.API_clima.dto.ClimaDTO;
import com.clima.API_clima.exception.ClimaIndisponivelException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
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
		JsonNode resposta;

		try {
			resposta = restClient.get()
					.uri(OPEN_METEO_URL)
					.retrieve()
					.body(JsonNode.class);
		} catch (RestClientException erro) {
			throw new ClimaIndisponivelException("Erro ao consultar a Open-Meteo.", erro);
		}

		if (resposta == null) {
			throw new ClimaIndisponivelException("A Open-Meteo nao retornou dados.");
		}

		JsonNode climaAtual = resposta.path("current");
		JsonNode unidades = resposta.path("current_units");

		if (climaAtual.isMissingNode() || unidades.isMissingNode()) {
			throw new ClimaIndisponivelException("A Open-Meteo retornou dados incompletos.");
		}

		JsonNode temperatura = climaAtual.path("temperature_2m");
		JsonNode unidadeTemperatura = unidades.path("temperature_2m");
		JsonNode velocidadeVento = climaAtual.path("wind_speed_10m");
		JsonNode unidadeVento = unidades.path("wind_speed_10m");
		JsonNode horario = climaAtual.path("time");

		if (temperatura.isMissingNode() || unidadeTemperatura.isMissingNode() || velocidadeVento.isMissingNode()
				|| unidadeVento.isMissingNode() || horario.isMissingNode()) {
			throw new ClimaIndisponivelException("A Open-Meteo retornou dados incompletos.");
		}

		return new ClimaDTO(
				CIDADE,
				temperatura.asDouble(),
				unidadeTemperatura.asString(),
				velocidadeVento.asDouble(),
				unidadeVento.asString(),
				horario.asString());
	}
}
