package com.kiumiu.ca.api500px.blog;

import java.net.URLEncoder;

import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;

/**
 * A class which wraps all 500px REST blogs end node functions 
 * @see See <a href="https://github.com/500px/api-documentation/tree/master/endpoints/blogs">500px gitGub</a> for more detail
 * @author Jerry Fan
 *
 */
public class blogInterface {
	private AccessToken token;
	private String consumerKey;
	private String consumerSecret;
	private static String url = "/blogs";
	
	
	/**
	 * Constructor to construct a blogInterface
	 * @param token Access token obtained from OAuth authentication.
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public blogInterface(AccessToken token, String consumerKey, String consumerSecret) {
		this.token = token;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * Constructor to construct a blogInterface
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public blogInterface(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * 500px DELETE_blogs_id. Delete a story.
	 * @param id (required) Ñ The Story ID to delete.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/DELETE_blogs_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_blogs_id(String id) {
		return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id);
	}
	
	/**
	 * 500px GET_blogs. Returns a listing of five recent stories by any user (maximum 100 per page).
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public JSONObject get_blogs_fresh(int page, int rpp) {
		String request = "?";
		StringBuilder builder = new StringBuilder(request);
		
		builder.append("feature=fresh&");
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_blogs. Returns a listing of five recent stories from a specific user id (maximum 100 per page).
	 * @param userID  Stories to return by user id. Don't be confused with username. User id is an unique integer number that 500px uses to denote an user.
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public JSONObject get_blogs_userId(String userID, int page, int rpp) {
		String request = "?";
		StringBuilder builder = new StringBuilder(request);
		
		builder.append("feature=user&");
		try {
			builder.append("user_id=" + URLEncoder.encode(userID,"UTF-8") + "&");
		} catch(Exception e) {}
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_blogs. Returns a listing of five recent stories from a specific user name (maximum 100 per page).
	 * @param userName Stories to return by user name.
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public JSONObject get_blogs_username(String userName, int page, int rpp) {
		String request = "?";
		StringBuilder builder = new StringBuilder(request);
		
		builder.append("feature=user&");
		try {
			builder.append("username=" + URLEncoder.encode(userName,"UTF-8") + "&");
		} catch(Exception e) {}
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_blogs_id. Returns detailed information of a single story.
	 * @param id (required) - Return information for the specific story.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs_id.md">500px API</a> for details.
	 */
	public JSONObject get_blogs_id(String id) {
		String request = id;
		
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + request);
	}
	
	/**
	 * 500px GET_blogs_id_comments. Returns a listing of twenty comments for a specific Story.
	 * @param id (required) Ñ The Story ID to get comments for.
	 * @param page Return a specific page in the comment listing. Page numbering is 1-based.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs_id_comments.md">500px API</a> for details.
	 */
	public JSONObject get_blogs_id_comments(String id, int page) {
		String request = id + "/comments?";
		
		if(page > 0)
			request = request + "page=" + page;
		
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + request);
	}

}
