package com.github.jak0bh.courserepo.tdd.vtwo.nested;

import com.github.jak0bh.courserepo.tdd.vtwo.EconomyFlight;
import com.github.jak0bh.courserepo.tdd.vtwo.Flight;
import com.github.jak0bh.courserepo.tdd.vtwo.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

	@DisplayName("Given there is an economy flight")
	@Nested
	class EconomyFlightTest {
		private Flight economyFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			economyFlight = new EconomyFlight("1");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("When we have an usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Test that you can add and remove him from an economy flight")
			void testEconomyFlightUsualPassenger() {
				assertAll("Verify all conditions for an usual passenger and an economy flight",
					() -> assertEquals("1", economyFlight.getId()),
					() -> assertTrue(economyFlight.addPassenger(mike)),
					() -> assertEquals(1, economyFlight.getPassengersList().size()),
					() -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
					() -> assertTrue(economyFlight.removePassenger(mike)),
					() -> assertEquals(0, economyFlight.getPassengersList().size())
				);
			}
		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {
			@Test
			@DisplayName("Test that you can add and remove him from an economy flight")
			void testEconomyFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger and an economy flight",
					() -> assertEquals("1", economyFlight.getId()),
					() -> assertTrue(economyFlight.addPassenger(john)),
					() -> assertEquals(1, economyFlight.getPassengersList().size()),
					() -> assertEquals("John", economyFlight.getPassengersList().get(0).getName()),
					() -> assertFalse(economyFlight.removePassenger(john)),
					() -> assertEquals(1, economyFlight.getPassengersList().size())
				);
			}
		}
	}
}