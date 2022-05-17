package com.github.jak0bh.courserepo.tdd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mileage {
	public static final int VIP_FACTOR = 10;
	public static final int USUAL_FACTOR = 20;

	private Map<Passenger, Integer> passengersMileageMap = new HashMap<>();
	private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

	public Map<Passenger, Integer> getPassengersPointsMap() {
		return Collections.unmodifiableMap(passengersPointsMap);
	}

	public void addMileage(Passenger passenger, int miles) {
		if (passengersMileageMap.containsKey(passenger)) {
			passengersMileageMap.put(passenger, passengersMileageMap.get(passenger) + miles);
		} else {
			passengersMileageMap.put(passenger, miles);
		}
	}

	public void calculateGivenPoints() {
		for (Map.Entry<Passenger, Integer> passenger : passengersMileageMap.entrySet()) {
			int points = passenger.getValue();
			if (passenger.getKey().isVip()) {
				points /= VIP_FACTOR;
			} else {
				points /= USUAL_FACTOR;
			}
			passengersPointsMap.put(passenger.getKey(), points);
		}
	}
}