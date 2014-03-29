package com.kiumiu.ca.api500px.response.photo;

import com.kiumiu.ca.api500px.primitiveDataType.Comment;

public class get_photo_id_comments_response {
	public String media_type;
	public int current_page;
	public int total_pages;
	public int total_items;
	public Comment[] comments;
	
	/**
	 * @return the media_type
	 */
	public String getMedia_type() {
		return media_type;
	}
	/**
	 * @param media_type the media_type to set
	 */
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
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
	 * @return the comments
	 */
	public Comment[] getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Comment[] comments) {
		this.comments = comments;
	}
}
