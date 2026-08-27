package com.clima.API_clima.service;

import com.clima.API_clima.dto.ClimaDTO;
import org.springframework.stereotype.Service;

@Service
public class ClimaService {

	public ClimaDTO testarApi() {
		return new ClimaDTO("Belo Horizonte - MG", "API de clima funcionando");
	}
}
