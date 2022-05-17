package com.github.jak0bh.courserepo.tdd.vone;

public class Passenger {
	private final String name;
	private final boolean vip;

	public Passenger(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}
}