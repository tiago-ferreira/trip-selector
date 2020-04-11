package br.com.mio.di.bao.trip.selector.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mio.di.bao.trip.selector.model.Trip;
import br.com.mio.di.bao.trip.selector.service.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private  TripService tripService;
	
	@GetMapping
	public List<Trip> list() throws IOException {
		return tripService.listTrips();
	}
}
