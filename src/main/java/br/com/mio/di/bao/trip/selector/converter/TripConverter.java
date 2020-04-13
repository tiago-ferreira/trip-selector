package br.com.mio.di.bao.trip.selector.converter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.mio.di.bao.trip.selector.model.Trip;

@Component
public class TripConverter {
	
	@Value("${character.to.split}")
	private String characterToSplit;

	public Trip convert(String line) {
		System.out.println(line);
		String[] values = line.split(characterToSplit);
		System.out.println("from: "+values[0]+", to: "+values[1]+", price: "+values[2]);
		return new Trip(values[0], values[1], new BigDecimal(values[2]));
	}
}
