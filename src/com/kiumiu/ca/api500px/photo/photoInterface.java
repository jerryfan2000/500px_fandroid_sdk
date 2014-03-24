package com.kiumiu.ca.api500px.photo;

import java.util.ArrayList;
import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;
import com.kiumiu.ca.api500px.parameter;

/**
 * A class which wraps all 500px REST photo end node functions 
 * @see See <a href="https://github.com/500px/api-documentation/tree/master/endpoints/photo">500px gitGub</a> for more detail
 * 
 * @author Jerry Fan
 * @version V0.1
 */
public class photoInterface {
	private AccessToken token;
	private String consumerKey;
	private String consumerSecret;
	private static String url = "/photos";

	
	/**
	 * Constructor to construct a photoInterface
	 * @param token Access token obtained from OAuth authentication.
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public photoInterface(AccessToken token, String consumerKey, String consumerSecret) {
		this.token = token;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * Constructor to construct a photoInterface
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public photoInterface(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * 500px DELETE_photos_id function call. Used to delete an photo by photo ID
	 * @param id Photo with ID to be deleted.
	 * @return JSON response
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id(String id) {
		return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id);
	}
	
	/**
	 * 500px DELETE_photos_id_favorite. Used to remove the photo to user's list of favorites.
	 * @param id Photo with ID to be deleted.
	 * @return JSON response
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id_faviorte(String id) {
		return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id + "/favorite");
	}
	
	/**
	 * 500px DELETE_photos_id_tags. Used to remove tags from the photo. Accepts one or multiple coma separated tags.
	 * @param id Photo with ID to be deleted.
	 * @param tags String array of tags to be deleted.
	 * @return JSON response
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id_tags(String id, String[] tags) {
		StringBuilder builder = new StringBuilder();
		builder.append("tags=");
		
		for(int x=0; x<tags.length; x++) {
			if(x>=tags.length-1)
				builder.append(tags[x]);
			else
				builder.append(tags[x] + ",");
		}
		
		return  new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id + "/tags?" + builder.toString());
	}
	
	
	/**
	 * 500px GET_photos. This version lets developer to manually build URL request string with valid consumer key or access token.
	 * @param request request URL for requesting photos from manually built request URL.
	 * @return JSON response
	 * <p><b>Remark:</b> Request String *Must* starts from ? excluding /photos, for example '?features=popular&only=Animals'.
	 */
	public JSONObject get_photo(String request) {
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + request);
	}
	
	/**
	 * 500px GET_photos. This version lets developer to build URL request string with valid consumer key or access token.
	 * @param feature photo stream to be retrieved. Default fresh_today. One of the constant in Class '{@link features}'.
	 * @param items additional {@link parameter} for GET_photos request. Follow <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos.md">500px github</a> for more details.
	 * @return JSON response
	 */
	public JSONObject get_photos(String feature, ArrayList<parameter> items) {
		//Build request parameters here
		String request = "?features=" + feature;
		StringBuilder builder = new StringBuilder(request);
		
		for(int x=0; x<items.size(); x++) {
			builder.append("&");
			builder.append(items.get(x).getKey() + "=" + items.get(x).getValue());
		}
		
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_photos_id. Returns detailed information of a single photo in <a href="https://github.com/500px/api-documentation/blob/master/basics/formats_and_terms.md#500px-photo-terms">full photo format</a>. Will return additional fields if photoInterface is constructed with valid access token.
	 * @param id id of data of photo to return.
	 * @param image_size Should be 1 to 4 while 1 being smallest.
	 * @param comment set to true to include comments of the photo in response. Comments are returned in order of creation, 20 entries per page.
	 * @param comment_page return the specified page from the comments listing. Page numbers are 1-based.
	 * @param tags returns an array of tags for the photo.
	 * @param items additional {@link parameter} for GET_photos_id request. Follow <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id.md#parameters">500px github</a> for more details.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id.md#parameters">500px API</a> for details.
	 */
	public JSONObject get_photo_id(String id, int image_size, boolean comments, int comment_page, boolean tags) {
		//Build request parameter here
		String request = id + "?";
		StringBuilder builder = new StringBuilder(request);
		
		if(comments)
			builder.append("comments&");
		
		if(tags)
			builder.append("tags&");
		
		if(comment_page >=1)
			builder.append("page=" + comment_page + "&");
		else
			builder.append("page=1&");
		
		if(image_size >= 1 && image_size <= 4)
			builder.append("image_size=" + image_size + "&");
		else
			builder.append("image_size=1&");
		
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px Get_photo_id_comments. Returns a listing of twenty comments for the photo.
	 * @param id (Required) the Photo ID to get comments for.
	 * @param nested include this parameter to return the comments in nested format.
	 * @param page return a specific page in the comment listing. Page numbering is 1-based.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id_comments.md">500px API</a> for details.
	 */
	public JSONObject get_photo_id_comments(String id, boolean nested, int page) {
		String request = id + "/comments?";
		StringBuilder builder = new StringBuilder(request);
		
		if(nested)
			builder.append("nested&");
		
		if(page >= 1)
			builder.append("page=" + page + "&");
		else
			builder.append("page=1&");
		Log.d("jerry", url + "/" + builder.toString());
		return  new RESTTransport(consumerKey).get(url + "/" + request);
	}
	
	/**
	 * 500px Get_photos_id_favorites. returns all users that had favorite that photo. Valid access token required.
	 * @param id (Required) the Photo ID to get favorites for.
	 * @param page return a specific page in the comment listing. Page numbering is 1-based.
	 * @param rpp the number of results to return. Can not be over 100, default 20.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id_favorites.md">500px API</a> for details.
	 */
	public JSONObject get_photos_id_favorites(String id, int page, int rpp) {
		String request = id + "/favorites?";
		StringBuilder builder = new StringBuilder(request);
		
		if(page >= 1)
			builder.append("page=" + page + "&");
		else
			builder.append("page=1&");
		
		if(rpp >= 1)
			builder.append("rpp=" + rpp + "&");
		else
			builder.append("rpp=20&");
		Log.d("jerry", url + "/" + builder.toString());
		return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	
}
