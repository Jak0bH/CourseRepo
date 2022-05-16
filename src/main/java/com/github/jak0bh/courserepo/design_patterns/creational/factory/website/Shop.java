package com.github.jak0bh.courserepo.design_patterns.creational.factory.website;

public class Shop extends Website {
	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ContactPage());
	}
}