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
	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	/**
	 * @return the filters
	 */
	public HashMap<String, Object> getFilters() {
		return filters;
	}
	/**
	 * @param filters the filters to set
	 */
	public void setFilters(HashMap<String, Object> filters) {
		this.filters = filters;
	}
	/**
	 * @return the current_page
	 */
	public int getCurrent_page() {
		return current_page;
	}
	/**
	 * @param current_page the current_page to set
	 */
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	/**
	 * @return the total_pages
	 */
	public int getTotal_pages() {
		return total_pages;
	}
	/**
	 * @param total_pages the total_pages to set
	 */
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	/**
	 * @return the total_items
	 */
	public int getTotal_items() {
		return total_items;
	}
	/**
	 * @param total_items the total_items to set
	 */
	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}
	/**
	 * @return the blog_posts
	 */
	public BlogShort[] getBlog_posts() {
		return blog_posts;
	}
	/**
	 * @param blog_posts the blog_posts to set
	 */
	public void setBlog_posts(BlogShort[] blog_posts) {
		this.blog_posts = blog_posts;
	}
	
	
}
