package com.kiumiu.ca.api500px.response.user;

import com.kiumiu.ca.api500px.primitiveDataType.UserShort;

public class get_users_id_followers_response {
	public int followers_count;
	public int followers_pages;
	public int page;
	public UserShort[] followers;
	
	/**
	 * @return the followers_count
	 */
	public int getFollowers_count() {
		return followers_count;
	}
	/**
	 * @param followers_count the followers_count to set
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	/**
	 * @return the followers_pages
	 */
	public int getFollowers_pages() {
		return followers_pages;
	}
	/**
	 * @param followers_pages the followers_pages to set
	 */
	public void setFollowers_pages(int followers_pages) {
		this.followers_pages = followers_pages;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return the followers
	 */
	public UserShort[] getFollowers() {
		return followers;
	}
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(UserShort[] followers) {
		this.followers = followers;
	}

	
	
}
