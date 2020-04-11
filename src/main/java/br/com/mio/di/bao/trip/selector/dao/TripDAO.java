package br.com.mio.di.bao.trip.selector.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import br.com.mio.di.bao.trip.selector.model.Trip;

@Component
public class TripDAO {

	private List<Trip> trips = new CopyOnWriteArrayList<>();
	
	public void add(Trip trip) {
		trips.add(trip);
	}
	
	public void set(List<Trip> trips) {
		this.trips = trips;
	}
	
	public List<Trip> get() {
		return this.trips;
	}
}
