package com.kiumiu.ca.api500px.response.user;

import com.kiumiu.ca.api500px.primitiveDataType.UserShort;

public class get_users_id_friends_response {
	public int friends_count;
	public int friends_pages;
	public int page;
	public UserShort[] friends;
	
	/**
	 * @return the friends_count
	 */
	public int getFriends_count() {
		return friends_count;
	}
	/**
	 * @param friends_count the friends_count to set
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}
	/**
	 * @return the friends_pages
	 */
	public int getFriends_pages() {
		return friends_pages;
	}
	/**
	 * @param friends_pages the friends_pages to set
	 */
	public void setFriends_pages(int friends_pages) {
		this.friends_pages = friends_pages;
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
	 * @return the friends
	 */
	public UserShort[] getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(UserShort[] friends) {
		this.friends = friends;
	}
	
	
	
	
}
