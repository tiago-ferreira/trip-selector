package br.com.mio.di.bao.trip.selector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripSelectorController {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
				
				
	}
}
