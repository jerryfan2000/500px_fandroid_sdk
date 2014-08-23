package com.kiumiu.ca.api500px.user;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.google.gson.Gson;
import com.kiumiu.ca.api500px.RESTTransport;
import com.kiumiu.ca.api500px.primitiveDataType.UserFullProfile;
import com.kiumiu.ca.api500px.response.user.get_users_id_followers_response;
import com.kiumiu.ca.api500px.response.user.get_users_id_friends_response;
import com.kiumiu.ca.api500px.response.user.get_users_search_response;
import com.kiumiu.ca.api500px.response.user.get_users_show_response;

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
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject get_users() {
		return new RESTTransport(token, consumerKey, consumerSecret).get(url);
	}
	
	/**
	 * 500px GET_users. Returns the profile information for the current user in <b>an already parsed JSON response object.</b>
	 * Since 500px is constantly upgrading its API response format. So this version may contain less return key/value pairs than get_photo.
	 * @return {@link get_users_show_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users.mdd">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public get_users_show_response get_usersEx() {
		return new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url).toString(), get_users_show_response.class);
	}
	
	/**
	 * 500px GET_users_id_followers. Returns a list of users who follow the specified user in <b>an already parsed JSON response object.</b>
	 * @param id (required) Ñ ID of the user.
	 * @param page Return the specified page of the resource. Page numbering is 1-based.
	 * @param rpp Results Per Page, default 20, max 100.
	 * @return {@link get_users_id_followers_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_id_followers.md">500px API</a> for details.
	 */
	public get_users_id_followers_response get_users_id_followersEx(String id, int page, int rpp) {
		String request = id + "/followers?";
		
		StringBuilder builder = new StringBuilder(request);
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		if(token == null)
			return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + builder.toString()).toString(), get_users_id_followers_response.class);
		else
			return  new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString()).toString(), get_users_id_followers_response.class);
	}
	
	/**
	 * 500px GET_users_id_followers. Returns a list of users who follow the specified user.
	 * @param id (required) Ñ ID of the user.
	 * @param page Return the specified page of the resource. Page numbering is 1-based.
	 * @param rpp Results Per Page, default 20, max 100.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_id_followers.md">500px API</a> for details.
	 */
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
	 * 500px GET_users_id_friends. Returns a list of friends for the specified user in <b>an already parsed JSON response object.</b>
	 * @param id (required) Ñ Return information for the specified user ID
	 * @param page Return the specified page of the resource. Page numbering is 1-based.
	 * @param rpp Results Per Page, default 20, max 100.
	 * @return {@link get_users_id_friends_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_id_friends.md">500px API</a> for details.
	 */
	public get_users_id_friends_response get_users_id_friendsEx(String id, int page, int rpp) {
		String request = id + "/friends?";
		StringBuilder builder = new StringBuilder(request);
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		if(token == null)
			return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + builder.toString()).toString(), get_users_id_friends_response.class);
		else
			return  new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString()).toString(), get_users_id_friends_response.class);
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
	 * 500px GET_users_search. Return listing of ten (up to one hundred) users from search results for a specified search term in <b>an already parsed JSON response object.</b>
	 * @param search (required) Ñ A keyword to search for.
	 * @return {@link get_users_search_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_search.md">500px API</a> for details.
	 */
	public get_users_search_response get_users_searchEx(String search) {
		if(token == null)
			return new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/search?term=" + search).toString(), get_users_search_response.class);	
		else
			return new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/search?term=" + search).toString(), get_users_search_response.class);	
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
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by userid (don't be confused this with username where userid is a number) in <b>an already parsed JSON response object.</b>
	 * @param id (required) user to return from with specific user id.
	 * @return {@link get_users_show_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details.
	 */
	public get_users_show_response get_users_show_by_idEx(String id) {	
		if(token == null)
			return new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/show?id=" + id).toString(), get_users_show_response.class);	
		else
			return new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?id=" + id).toString(), get_users_show_response.class);
		
	}
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by username.
	 * @param username (required) user to return from with specific username.
	 * @return {@link get_users_show_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details in <b>an already parsed JSON response object.</b>
	 */
	public get_users_show_response get_users_show_by_usernameEx(String username) {	
		if(token == null)
			return new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/show?username=" + username).toString(), get_users_show_response.class);	
		else
			return new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?username=" + username).toString(), get_users_show_response.class);
		
	}
	
	/**
	 * 500px GET_users_show. Returns the profile information for a specified user by email in <b>an already parsed JSON response object.</b>
	 * @param email (required) user to return from with specific email.
	 * @return {@link get_users_show_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/GET_users_show.md">500px API</a> for details.
	 */
	public get_users_show_response get_users_show_by_emailEx(String email) {	
		if(token == null)
			return new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/show?email=" + email).toString(), get_users_show_response.class);	
		else
			return new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/show?email=" + email).toString(), get_users_show_response.class);
		
	}
	
	/**
	 * 500px POST_users_id_friends. To follow someone.
	 * @param id (required) id of someone to follow.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/user/POST_users_id_friends.md">500px API</a> for details.
	 */
	public JSONObject post_users_id_friends(String id) {
		String request = id + "/friends";
		
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		if(token != null)
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		else
			return new RESTTransport(consumerKey).post(url + "/" + request, params);
	}
}
