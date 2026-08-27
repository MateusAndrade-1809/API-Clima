package com.clima.API_clima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

	@GetMapping("/clima")
	public String testarApi() {
		return "API de clima funcionando";
	}
}
