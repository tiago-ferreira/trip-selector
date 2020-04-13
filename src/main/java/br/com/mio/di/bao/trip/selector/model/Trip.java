package br.com.mio.di.bao.trip.selector.model;

import java.math.BigDecimal;

public class Trip {

	private String from;
	private String to;
	private BigDecimal price;

	public Trip(String from, String to, BigDecimal price) {
		this.from = from;
		this.to = to;
		this.price = price;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
