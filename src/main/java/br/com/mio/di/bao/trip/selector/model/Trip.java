package br.com.mio.di.bao.trip.selector.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Trip {

	private String from;
	private String to;
	private BigDecimal price;

	public Trip(String from, String to, BigDecimal price) {
		this.from = from;
		this.to = to;
		this.price = price;
	}
	
}
