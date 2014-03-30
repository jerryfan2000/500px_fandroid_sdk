package com.kiumiu.ca.api500px.response.blog;

import java.util.HashMap;

import com.kiumiu.ca.api500px.primitiveDataType.BlogShort;

public class get_blogs_response {
	public String feature;
	public HashMap<String, Object> filters;
	public int current_page;
	public int total_pages;
	public int total_items;
	public BlogShort[] blog_posts;
}
