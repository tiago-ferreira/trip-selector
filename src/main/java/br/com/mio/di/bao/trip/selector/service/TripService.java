package br.com.mio.di.bao.trip.selector.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mio.di.bao.trip.selector.converter.TripConverter;
import br.com.mio.di.bao.trip.selector.model.Trip;
import br.com.mio.di.bao.trip.selector.util.FileReader;
import br.com.mio.di.bao.trip.selector.util.FileWriter;

@Service
public class TripService {

//	@Autowired
//	private TripDAO tripDAO;
	
	@Autowired
	private FileReader fileReader;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Autowired
	private TripConverter tripConverter;
	
	
	public List<Trip> listTrips() throws IOException {
		Stream<String> data = fileReader.readFile();
		return data.map( a -> tripConverter.convert(a)).collect(Collectors.toList());
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


	public String bestRoute(String from, String to) throws IOException {
        Graph<String, DefaultWeightedEdge> directedGraph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Stream<String> data = fileReader.readFile();
		List<Trip> trips =  data.map( a -> tripConverter.convert(a)).collect(Collectors.toList());
		Set<String> vertex = extractedVertex(trips);
		vertex.forEach( v -> directedGraph.addVertex(v));
		trips.forEach(trip -> {
			DefaultWeightedEdge defaultWeightEdge = directedGraph.addEdge(trip.getFrom(), trip.getTo());
			directedGraph.setEdgeWeight(defaultWeightEdge, trip.getPrice().longValue());
		});
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(directedGraph);
        SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstra.getPaths(from);
		return iPaths.getPath(to).toString();
	}


	private Set<String> extractedVertex(List<Trip> trips) {
		Set<String> vertex = trips.stream().map( a -> a.getFrom()).collect(Collectors.toSet());
		vertex.addAll( trips.stream().map( a -> a.getTo()).collect(Collectors.toSet()) );
		return vertex;
	}
}