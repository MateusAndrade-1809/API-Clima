package com.clima.API_clima.controller;

import com.clima.API_clima.dto.ClimaDTO;
import com.clima.API_clima.dto.ErroDTO;
import com.clima.API_clima.exception.ClimaIndisponivelException;
import com.clima.API_clima.service.ClimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

	private final ClimaService climaService;

	public ClimaController(ClimaService climaService) {
		this.climaService = climaService;
	}

	@GetMapping("/clima")
	public ClimaDTO buscarClimaAtual() {
		return climaService.buscarClimaAtual();
	}

	@ExceptionHandler(ClimaIndisponivelException.class)
	public ResponseEntity<ErroDTO> tratarErroClima(ClimaIndisponivelException erro) {
		ErroDTO resposta = new ErroDTO(
				"Nao foi possivel buscar o clima agora.",
				erro.getMessage());

		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(resposta);
	}
}
