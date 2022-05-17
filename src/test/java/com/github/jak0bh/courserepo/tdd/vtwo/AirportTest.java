package com.github.jak0bh.courserepo.tdd.vtwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
	@Test
	void testAirport() {
		Flight economyFlight = new EconomyFlight("1");
		Flight businessFlight = new BusinessFlight("2");

		Passenger john = new Passenger("John", true);
		Passenger mike = new Passenger("Mike", false);

		assertTrue(economyFlight.addPassenger(john));
		assertFalse(economyFlight.removePassenger(john));
		assertTrue(businessFlight.addPassenger(john));
		assertFalse(businessFlight.removePassenger(john));

		assertTrue(economyFlight.addPassenger(mike));
		assertTrue(economyFlight.removePassenger(mike));
		assertFalse(businessFlight.addPassenger(mike));
		assertFalse(businessFlight.removePassenger(mike));
	}

	@Test
	void testEconomyFlightUsualPassenger() {
		Flight economyFlight = new EconomyFlight("1");
		Passenger mike = new Passenger("Mike", false);

		assertEquals("1", economyFlight.getId());
		assertTrue(economyFlight.addPassenger(mike));
		assertEquals(1, economyFlight.getPassengersList().size());
		assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());

		assertTrue(economyFlight.removePassenger(mike));
		assertEquals(0, economyFlight.getPassengersList().size());
	}

	@Test
	void testEconomyFlightVipPassenger() {
		Flight economyFlight = new EconomyFlight("1");
		Passenger john = new Passenger("John", true);

		assertEquals("1", economyFlight.getId());
		assertTrue(economyFlight.addPassenger(john));
		assertEquals(1, economyFlight.getPassengersList().size());
		assertEquals("John", economyFlight.getPassengersList().get(0).getName());

		assertFalse(economyFlight.removePassenger(john));
		assertEquals(1, economyFlight.getPassengersList().size());
	}

	@Test
	void testBusinessFlightUsualPassenger() {
		Flight businessFlight = new BusinessFlight("2");

		Passenger mike = new Passenger("Mike", false);

		assertFalse(businessFlight.addPassenger(mike));
		assertEquals(0, businessFlight.getPassengersList().size());
		assertFalse(businessFlight.removePassenger(mike));
		assertEquals(0, businessFlight.getPassengersList().size());

	}

	@Test
	void testBusinessFlightVipPassenger() {
		Flight businessFlight = new BusinessFlight("2");

		Passenger john = new Passenger("John", true);

		assertTrue(businessFlight.addPassenger(john));
		assertEquals(1, businessFlight.getPassengersList().size());
		assertFalse(businessFlight.removePassenger(john));
		assertEquals(1, businessFlight.getPassengersList().size());

	}
}