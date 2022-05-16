package com.github.jak0bh.courserepo.design_patterns.creational.factory;

import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.Blog;
import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.Shop;
import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.Website;
import com.github.jak0bh.courserepo.design_patterns.creational.factory.website.WebsiteType;

public class WebsiteFactory {
	public static Website getWebsite(WebsiteType siteType) {
		return switch (siteType) {
			case BLOG -> new Blog();
			case SHOP -> new Shop();
		};
	}
}