package br.com.mio.di.bao.trip.selector.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mio.di.bao.trip.selector.model.Trip;
import br.com.mio.di.bao.trip.selector.service.TripService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private  TripService tripService;
	
	@ApiOperation(value = "Retorna um json com as informações no arquivo de entrada")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna as informações do arquivo de entrada"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping
	public List<Trip> list() throws IOException {
		return tripService.listTrips();
	}
	
	@ApiOperation(value = "Adiciona informações no arquivo de entrada")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Adiciona informações no arquivo de entrada"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
	public Trip create(@RequestBody Trip trip) throws URISyntaxException {
		return tripService.create(trip);
	}
	
	@ApiOperation(value = "Retorna a melhor rota de acordo com as possiveis informadas no arquivo de entrada")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a melhor rota"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("/best-route/{from}/{to}")
	public String bestRoute(@PathVariable("from") String from, @PathVariable("to") String to) throws IOException {
		return tripService.bestRoute(from, to);
	}
}
