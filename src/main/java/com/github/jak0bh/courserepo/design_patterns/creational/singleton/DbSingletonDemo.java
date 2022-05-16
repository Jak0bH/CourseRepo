package com.github.jak0bh.courserepo.design_patterns.creational.singleton;

public class DbSingletonDemo {
	public static void main(String[] args) {
		// doesn't work, because it violates the singleton pattern
		// DbSingleton testConst = new DbSingleton();

		DbSingleton instance = DbSingleton.getInstance();
		System.out.println(instance);

		DbSingleton anotherInstance = DbSingleton.getInstance();
		System.out.println(anotherInstance);
	}
}