package com.github.jak0bh.courserepo.tdd;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightArgumentConverter extends SimpleArgumentConverter {
	@Override
	protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
		assertEquals(String.class, source.getClass(), "Can only convert from String");
		assertEquals(Flight.class, targetType, "Can only convert to Flight");

		String[] flightString = source.toString().split(";\\s*");
		Flight flight = switch(flightString[1].toLowerCase(Locale.ROOT)) {
			case "b" -> new BusinessFlight(flightString[0]);
			case "p" -> new PremiumFlight(flightString[0]);
			case "e" -> new EconomyFlight(flightString[0]);
			default -> throw new ArgumentConversionException("Unknown flight type: " + flightString[1]);
		};

		flight.addPassenger(new Passenger(flightString[2], flightString[3].equals("true")));
		flight.setDistance(Integer.parseInt(flightString[4]));

		return flight;
	}
}