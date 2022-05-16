package com.github.jak0bh.courserepo.design_patterns.creational.factory.website;

public class Blog extends Website {
	@Override
	public void createWebsite() {
		pages.add(new PostPage());
		pages.add(new ContactPage());
	}
}