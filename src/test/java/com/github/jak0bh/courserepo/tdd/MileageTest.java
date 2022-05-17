package com.github.jak0bh.courserepo.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MileageTest {
	private Mileage mileage;

	@BeforeAll
	void setup() {
		mileage = new Mileage();
	}

	@ParameterizedTest
	@Disabled("Superseded by checkGivenPointsWithCsvInput")
	@ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278" })
	void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for (Passenger passenger : flight.getPassengersSet()) {
			mileage.addMileage(passenger, flight.getDistance());
		}
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/flights_information.csv")
	void checkGivenPointsWithCsvInput(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for (Passenger passenger : flight.getPassengersSet()) {
			mileage.addMileage(passenger, flight.getDistance());
		}
	}

	@AfterAll
	void afterAll() {
		mileage.calculateGivenPoints();
		assertEquals(64, mileage.getPassengersPointsMap().get(new Passenger("Mike", false)).intValue());
		assertEquals(207, mileage.getPassengersPointsMap().get(new Passenger("John", true)).intValue());
	}
}