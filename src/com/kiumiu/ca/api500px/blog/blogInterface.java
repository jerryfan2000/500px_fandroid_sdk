package com.kiumiu.ca.api500px.blog;

import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.google.gson.Gson;
import com.kiumiu.ca.api500px.RESTTransport;
import com.kiumiu.ca.api500px.primitiveDataType.BlogFull;
import com.kiumiu.ca.api500px.response.blog.get_blogs_response;

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
	 * 500px GET_blogs. Returns a listing of five recent stories by any user (maximum 100 per page) in <b>an already parsed JSON response object.</b>.
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return {@link get_blogs_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public get_blogs_response get_blogs_freshEx(int page, int rpp) {
		String request = "?";
		StringBuilder builder = new StringBuilder(request);
		
		builder.append("feature=fresh&");
		
		if(page > 0)
			builder.append("page=" + page + "&");
		
		if(rpp > 0)
			builder.append("rpp=" + rpp + "&");
		
		Log.d("fandroid", url + "/" + builder.toString());
		return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + builder.toString()).toString(), get_blogs_response.class);
	}
	
	/**
	 * 500px GET_blogs. Returns a listing of five recent stories from a specific user id (maximum 100 per page) in <b>an already parsed JSON response object.</b>.
	 * @param userID  Stories to return by user id. Don't be confused with username. User id is an unique integer number that 500px uses to denote an user.
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return {@link get_blogs_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public get_blogs_response get_blogs_userIdEx(String userID, int page, int rpp) {
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
		return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + builder.toString()).toString(), get_blogs_response.class);
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
	 * 500px GET_blogs. Returns a listing of five recent stories from a specific user name (maximum 100 per page) in <b>an already parsed JSON response object.</b>.
	 * @param userName Stories to return by user name.
	 * @param page Return a specific page in the story listing. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 5.
	 * @return {@link get_blogs_response} object. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs.md">500px API</a> for details.
	 */
	public get_blogs_response get_blogs_usernameEx(String userName, int page, int rpp) {
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
		return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + builder.toString()).toString(), get_blogs_response.class);
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
	 * 500px GET_blogs_id. Returns detailed information of a single story in <b>an already parsed JSON response object.</b>.
	 * @param id (required) - Return information for the specific story.
	 * @return {@link BlogFull}. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/GET_blogs_id.md">500px API</a> for details.
	 */
	public BlogFull get_blogs_idEx(String id) {
		String request = id;
		
		if(token == null)
			return  new Gson().fromJson(new RESTTransport(consumerKey).get(url + "/" + request).toString(), BlogFull.class);
		else
			return  new Gson().fromJson(new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + request).toString(), BlogFull.class);
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
	
	/**
	 * 500px POST_blogs. Creates a new Story.
	 * @param title (required) Ñ Title for the blog post.
	 * @param body (required) Ñ Content of the blog post.
	 * @param latitude Latitude for the blog post.
	 * @param longitude Longitude for the blog post.
	 * @param tags Comma separated list of tags.
	 * @param photoids Comma separated list of Photo ID values to post with the blog.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/POST_blogs.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_blogs(String title, String body, String latitude, String longitude, String[] tags, String[] photoids) {
		
		if(token != null) {
			String mTags = "", mPhotoids = "";
			
			for(int x=0; x<tags.length; x++)
				if(x==tags.length-1)
					mTags = mTags + tags[x];
				else
					mTags = mTags + tags[x] + ",";
			
			for(int x=0; x<photoids.length; x++)
				if(x==photoids.length-1)
					mPhotoids = mPhotoids + photoids[x];
				else
					mPhotoids = mPhotoids + photoids[x] + ",";
			
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			if(title != null)
				params.add(new BasicNameValuePair("title", title));
			
			if(body != null)
				params.add(new BasicNameValuePair("body", body));
			
			if(latitude != null)
				params.add(new BasicNameValuePair("latitude", latitude));
			
			if(longitude != null)
				params.add(new BasicNameValuePair("longitude", longitude));
			
			if(tags != null)
				params.add(new BasicNameValuePair("tags", mTags));
			
			if(photoids != null)
				params.add(new BasicNameValuePair("photo_ids", mPhotoids));
			
			return new RESTTransport(token, consumerKey, consumerSecret).post(url, params);
		}
		return null;
	}
	
	/**
	 * 500px POST_blogs_id_comments. Creates a comment for the Story.
	 * @param id (required) Ñ The Story ID to create a comment for.
	 * @param comment (required) Ñ Content of the comment.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/POST_blogs_id_comments.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_blogs_id_comments(String id, String comment) {
		String request = id + "/comments";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("body", comment));
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
		
	}
	
	/**
	 * 500px put_blogs_id. Updates the Story.
	 * @param id (required) Ñ The Blog Post ID to update.
	 * @param title Title for the blog post.
	 * @param body Content of the blog post.
	 * @param latitude Latitude for the blog post.
	 * @param longitude Longitude for the blog post.
	 * @param tags Comma separated list of tags.
	 * @param photoids Comma separated list of Photo IDs for photos that are in the blog post.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/blog/PUT_blogs_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject put_blogs_id(String id, String title, String body, String latitude, String longitude, String[] tags, String[] photoids) {
		String request = "/" + id;
		
		if(token != null) {
			String mTags = "", mPhotoids = "";
			
			for(int x=0; x<tags.length; x++)
				if(x==tags.length-1)
					mTags = mTags + tags[x];
				else
					mTags = mTags + tags[x] + ",";
			
			for(int x=0; x<photoids.length; x++)
				if(x==photoids.length-1)
					mPhotoids = mPhotoids + photoids[x];
				else
					mPhotoids = mPhotoids + photoids[x] + ",";
			
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			if(title != null)
				params.add(new BasicNameValuePair("title", title));
			
			if(body != null)
				params.add(new BasicNameValuePair("body", body));
			
			if(latitude != null)
				params.add(new BasicNameValuePair("latitude", latitude));
			
			if(longitude != null)
				params.add(new BasicNameValuePair("longitude", longitude));
			
			if(tags != null)
				params.add(new BasicNameValuePair("tags", mTags));
			
			if(photoids != null)
				params.add(new BasicNameValuePair("photo_ids", mPhotoids));
			
			return new RESTTransport(token, consumerKey, consumerSecret).put(url + request, params);
		}
		return null;
	}

}
