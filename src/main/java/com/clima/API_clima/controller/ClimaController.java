package com.clima.API_clima.controller;

import com.clima.API_clima.dto.ClimaDTO;
import com.clima.API_clima.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

	private final ClimaService climaService;

	public ClimaController(ClimaService climaService) {
		this.climaService = climaService;
	}

	@GetMapping("/clima")
	public ClimaDTO testarApi() {
		return climaService.testarApi();
	}
}
