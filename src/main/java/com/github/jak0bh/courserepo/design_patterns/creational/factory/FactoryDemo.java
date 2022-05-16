package com.github.jak0bh.courserepo.design_patterns.creational.factory;

import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.Website;
import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.WebsiteType;

public class FactoryDemo {
	public static void main(String[] args) {
		Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		System.out.println(site.getPages());

		site = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		System.out.println(site.getPages());
	}
}