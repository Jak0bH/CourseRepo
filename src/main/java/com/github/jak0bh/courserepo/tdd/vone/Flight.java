package com.github.jak0bh.courserepo.tdd.vone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
	private String id;
	private List<Passenger> passengersList = new ArrayList<>();
	private String flightType;

	public Flight(String id, String flightType) {
		this.id = id;
		this.flightType = flightType;
	}

	public String getId() {
		return id;
	}

	public List<Passenger> getPassengersList() {
		return Collections.unmodifiableList(passengersList);
	}

	public String getFlightType() {
		return flightType;
	}

	public boolean addPassenger(Passenger passenger) {
		return switch (flightType) {
			case "Economy" -> passengersList.add(passenger);
			case "Business" -> {
				if (passenger.isVip())
					yield passengersList.add(passenger);
				yield false;
			}
			default -> throw new IllegalArgumentException("Unknown flight type: " + flightType);
		};
	}

	public boolean removePassenger(Passenger passenger) {
		return switch (flightType) {
			case "Economy" -> {
				if (!passenger.isVip()) {
					yield passengersList.remove(passenger);
				}
				yield false;
			}
			case "Business" -> false;
			default -> throw new IllegalArgumentException("Unknown flight type: " + flightType);
		};
	}
}