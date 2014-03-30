package com.kiumiu.ca.api500px.response.blog;

import com.kiumiu.ca.api500px.primitiveDataType.Comment;

public class get_blogs_id_comments_response {
	public String media_type;
	public int current_page;
	public int total_pages;
	public int total_items;
	public Comment[] comments;

}
