package com.github.jak0bh.courserepo.design_patterns.creational.singleton;

public class DbSingleton {
	/* Version 1:
	private static DbSingleton instance = new DbSingleton();

	public static DbSingleton getInstance() {
		return instance;
	}
	 */

	/* Version 2 (lazy loaded):
	private static DbSingleton instance;

	public static DbSingleton getInstance() {
		if (instance == null) {
			instance = new DbSingleton();
		}
		return instance;
	}
	 */

	private static volatile DbSingleton instance = null;

	/**
	 * Version 3 (lazy loaded + thread safe)
	 *
	 * If this method was synchronized, it'll slow down the method
	 */
	public static DbSingleton getInstance() {
		if (instance == null) {
			// if two threads are trying to create the instance at the same time, it'll be a problem
			// this will block both calls and return the same instance
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}

	private DbSingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}
}