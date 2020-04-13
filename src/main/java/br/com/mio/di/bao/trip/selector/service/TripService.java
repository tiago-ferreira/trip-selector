package br.com.mio.di.bao.trip.selector.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mio.di.bao.trip.selector.converter.TripConverter;
import br.com.mio.di.bao.trip.selector.dao.TripDAO;
import br.com.mio.di.bao.trip.selector.model.Trip;
import br.com.mio.di.bao.trip.selector.util.FileReader;
import br.com.mio.di.bao.trip.selector.util.FileWriter;

@Service
public class TripService {

	@Autowired
	private TripDAO tripDAO;
	
	@Autowired
	private FileReader fileReader;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Autowired
	private TripConverter tripConverter;
	
	
	public List<Trip> listTrips() throws IOException {
		Stream<String> data = fileReader.readFile();
		data.map( a -> tripConverter.convert(a)   ).forEach( trip -> tripDAO.add(trip));
		System.out.println(tripDAO.get().size());
		return tripDAO.get();
	}


	public Trip create(Trip trip) throws URISyntaxException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n")
			.append(trip.getFrom().trim().toUpperCase())
			.append(",")
			.append(trip.getTo().trim().toUpperCase())
			.append(",")
			.append(trip.getPrice().toString().trim());
		fileWriter.writeEndOfAFile(buffer.toString());
		return trip;
	}
}