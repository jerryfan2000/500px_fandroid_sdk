package com.kiumiu.ca.api500px.user;

import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;

/**
 * A class which wraps all 500px REST user end node functions 
 * @see See <a href="https://github.com/500px/api-documentation/tree/master/endpoints/user">500px gitGub</a> for more detail
 * @author Jerry Fan
 *
 */
public class userInterface {
	private AccessToken token;
	private String consumerKey;
	private String consumerSecret;
	private static String url = "/users";

	
	/**
	 * Constructor to construct a userInterface
	 * @param token Access token obtained from OAuth authentication.
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public userInterface(AccessToken token, String consumerKey, String consumerSecret) {
		this.token = token;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * Constructor to construct a userInterface
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public userInterface(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * 500px DELETE_users_id_friends. Removes the user from the list of followers.
	 * @param id (required) Ñ ID of the User to remove from the followers list.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/DELETE_users_id_friends.md">500px API</a> for details.
	 */
	public JSONObject delete_users_id_friends(String id) {
		if(token == null)
			return new RESTTransport(consumerKey).delete(url + "/" + id + "/friends");	
		else
			return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id + "/friends");	
	}
	
	/**
	 * 500px GET_users. Returns the profile information for the current user.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users.mdd">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject get_users() {
		return new RESTTransport(token, consumerKey, consumerSecret).get(url);
	}
	
	public JSONObject get_users_id_followers(String id, int page, int rpp) {
		String request = id + "/followers?";
		
		StringBuilder builder = new StringBuilder(request);
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_users_id_friends. Returns a list of friends for the specified user.
	 * @param id (required) Ñ Return information for the specified user ID
	 * @param page Return the specified page of the resource. Page numbering is 1-based.
	 * @param rpp Results Per Page, default 20, max 100.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_id_friends.md">500px API</a> for details.
	 */
	public JSONObject get_users_id_friends(String id, int page, int rpp) {
		String request = id + "/friends?";
		StringBuilder builder = new StringBuilder(request);
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_users_search. Return listing of ten (up to one hundred) users from search results for a specified search term.
	 * @param search (required) Ñ A keyword to search for.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_search.md">500px API</a> for details.
	 */
	public JSONObject get_users_search(String search) {
		if(token == null)
			return new RESTTransport(consumerKey).get(url + "/search?term=" + search);	
		else
			return new RESTTransport(token, consumerKey, consumerSecret).get(url + "/search?term=" + search);	
	}
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by userid (don't be confused this with username where userid is a number).
	 * @param id (required) user to return from with specific user id.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details.
	 */
	public JSONObject get_users_show_by_id(String id) {	
		if(token == null)
			return new RESTTransport(consumerKey).get(url + "/show?id=" + id);	
		else
			return new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?id=" + id);
		
	}
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by username.
	 * @param username (required) user to return from with specific username.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details.
	 */
	public JSONObject get_users_show_by_username(String username) {	
		if(token == null)
			return new RESTTransport(consumerKey).get(url + "/show?username=" + username);	
		else
			return new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?username=" + username);
		
	}
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by email.
	 * @param email (required) user to return from with specific email.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details.
	 */
	public JSONObject get_users_show_by_email(String email) {	
		if(token == null)
			return new RESTTransport(consumerKey).get(url + "/show?email=" + email);	
		else
			return new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?email=" + email);
		
	}
}
