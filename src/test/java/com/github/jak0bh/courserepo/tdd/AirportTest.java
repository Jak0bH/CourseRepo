package com.github.jak0bh.courserepo.tdd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

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
					() -> assertEquals(1, economyFlight.getPassengersSet().size()),
					() -> assertEquals("Mike", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
					() -> assertTrue(economyFlight.removePassenger(mike)),
					() -> assertEquals(0, economyFlight.getPassengersSet().size())
				);
			}

			@DisplayName("Test that you can't add the passenger to an economy flight more than once")
			@RepeatedTest(5)
			void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
				for (int i = 0; i < repetitionInfo.getTotalRepetitions(); i++) {
					economyFlight.addPassenger(mike);
				}

				assertAll("Verify a usual passenger can be added to an economy flight only once",
					() -> assertEquals(1, economyFlight.getPassengersSet().size()),
					() -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
					() -> assertEquals("Mike", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName())
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
					() -> assertEquals(1, economyFlight.getPassengersSet().size()),
					() -> assertEquals("John", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
					() -> assertFalse(economyFlight.removePassenger(john)),
					() -> assertEquals(1, economyFlight.getPassengersSet().size())
				);
			}
		}
	}

	@Nested
	@DisplayName("Given there is a premium flight")
	class PremiumFlightTest {
		private Flight premiumFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			premiumFlight = new PremiumFlight("3");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("When we have an usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Test that you can add and remove him from an economy flight")
			void testPremiumFlightUsualPassenger() {
				assertAll("Verify all conditions for an usual passenger and an economy flight",
					() -> assertFalse(premiumFlight.addPassenger(mike)),
					() -> assertEquals(0, premiumFlight.getPassengersSet().size()),
					() -> assertFalse(premiumFlight.removePassenger(mike)),
					() -> assertEquals(0, premiumFlight.getPassengersSet().size())
				);
			}
		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {
			@Test
			@DisplayName("Test that you can add and remove him from an economy flight")
			void testPremiumFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger and an economy flight",
					() -> assertTrue(premiumFlight.addPassenger(john)),
					() -> assertEquals(1, premiumFlight.getPassengersSet().size()),
					() -> assertTrue(premiumFlight.removePassenger(john)),
					() -> assertEquals(0, premiumFlight.getPassengersSet().size())
				);
			}
		}
	}
}