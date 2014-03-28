package com.kiumiu.ca.api500px.collections;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;


/**
 * A class which wraps all 500px REST photo end node functions 
 * @see See <a href="https://github.com/500px/api-documentation/tree/master/endpoints/collections">500px gitGub</a> for more detail
 * @author Jerry Fan
 *
 */
public class collectionsInterface {
	private AccessToken token;
	private String consumerKey;
	private String consumerSecret;
	private static String url = "/collections";

	
	/**
	 * Constructor to construct a collectionsInterface
	 * @param token Access token obtained from OAuth authentication.
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public collectionsInterface(AccessToken token, String consumerKey, String consumerSecret) {
		this.token = token;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * Constructor to construct a collectionsInterface
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public collectionsInterface(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * 500px DELETE_collections_id. Deletes a collection.
	 * @param id (required) - the id of a collection to delete.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/collections/DELETE_collections_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_collections_id(String id) {
		if(token != null)
			return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id);
		else
			return null;
	}
	
	/**
	 * 500px GET_collections. Returns a listing of all User's collections and sets.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/collections/GET_collections.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject get_collections() {
		if(token != null)
			return new RESTTransport(token, consumerKey, consumerSecret).get(url);
		else
			return null;
	}
	
	/**
	 * 500px GET_collections_id. Returns a specific collection.
	 * @param id (required) - the id of a collection to retrun from.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/collections/GET_collections_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject get_collections_id(String id) {
		if(token != null)
			return new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + id);
		else
			return null;
	}
	
	/**
	 * 500px POST_collections. Creates new a collection.
	 * @param title (required) Ñ Title for the collection.
	 * @param path (required) Ñ Path where the collection will be accessible at 500px.com/user/sets/:path.
	 * @param isProfileSet  Kind of the Collection to be created Recognized values: false - Portfolio Set, true - Profile Set.
	 * @param photo_ids String array of photo_ids to add into this collection.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/collections/POST_collections.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_collections(String title, String path, boolean isProfileSet, String[] photo_ids) {
		if(token != null) {
			String pIds = "";
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			
			if(title != null)
				params.add(new BasicNameValuePair("title", title));
			
			if(path != null)
				params.add(new BasicNameValuePair("path", path));
			
			if(isProfileSet)
				params.add(new BasicNameValuePair("kind", "2"));
			else
				params.add(new BasicNameValuePair("kind", "1"));
			
			if(photo_ids != null) {
				for(int x=0; x<photo_ids.length; x++) {
					if(x==photo_ids.length-1)
					pIds = pIds + photo_ids[x];
				else
					pIds = pIds + photo_ids[x] + ",";
				}
				params.add(new BasicNameValuePair("photo_ids", pIds));
			}
			
			return new RESTTransport(token, consumerKey, consumerSecret).post(url, params);
		}
		return null;
	}
	
	/**
	 * 500px PUT_collections. Update a collection.
	 * @param title (required) Ñ Title for the collection.
	 * @param path (required) Ñ Path where the collection will be accessible at 500px.com/user/sets/:path.
	 * @param isProfileSet  Kind of the Collection to be created Recognized values: false - Portfolio Set, true - Profile Set.
	 * @param photo_ids String array of photo_ids to add into this collection.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/collections/POST_collections.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject put_collections_id(String title, String path, boolean isProfileSet, String[] photo_ids) {
		if(token != null) {
			String pIds = "";
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			
			if(title != null)
				params.add(new BasicNameValuePair("title", title));
			
			if(path != null)
				params.add(new BasicNameValuePair("path", path));
			
			if(isProfileSet)
				params.add(new BasicNameValuePair("kind", "2"));
			else
				params.add(new BasicNameValuePair("kind", "1"));
			
			if(photo_ids != null) {
				for(int x=0; x<photo_ids.length; x++) {
					if(x==photo_ids.length-1)
					pIds = pIds + photo_ids[x];
				else
					pIds = pIds + photo_ids[x] + ",";
				}
				params.add(new BasicNameValuePair("photo_ids", pIds));
			}
			
			return new RESTTransport(token, consumerKey, consumerSecret).put(url, params);
		}
		return null;
	}
}
