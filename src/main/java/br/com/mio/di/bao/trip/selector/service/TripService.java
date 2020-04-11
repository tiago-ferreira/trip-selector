package br.com.mio.di.bao.trip.selector.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mio.di.bao.trip.selector.converter.TripConverter;
import br.com.mio.di.bao.trip.selector.dao.TripDAO;
import br.com.mio.di.bao.trip.selector.model.Trip;
import br.com.mio.di.bao.trip.selector.util.FileReader;

@Service
public class TripService {

	@Autowired
	private TripDAO tripDAO;
	
	@Autowired
	private FileReader fileReader;
	
	@Autowired
	private TripConverter tripConverter;
	
	
	public List<Trip> listTrips() throws IOException {
		Stream<String> data = fileReader.readFile("input-file.txt", true);
		data.forEach(System.out::println);
		data.forEach( a -> tripDAO.add(tripConverter.convert(a)));
		return tripDAO.get();
	}
}