package com.kiumiu.ca.api500px.response.user;

import com.kiumiu.ca.api500px.primitiveDataType.UserFullProfile;

public class get_users_search_response {
	public int current_page;
	public int total_pages;
	public int total_items;
	public UserFullProfile[] users;
	
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
	 * @return the users
	 */
	public UserFullProfile[] getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(UserFullProfile[] users) {
		this.users = users;
	}
}
