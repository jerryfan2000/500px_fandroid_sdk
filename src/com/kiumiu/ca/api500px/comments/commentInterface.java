package com.kiumiu.ca.api500px.comments;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;

public class commentInterface {
	private AccessToken token;
	private String consumerKey;
	private String consumerSecret;
	private static String url = "/comments";
	
	/**
	 * Constructor to construct a commentInterface
	 * @param token Access token obtained from OAuth authentication.
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public commentInterface(AccessToken token, String consumerKey, String consumerSecret) {
		this.token = token;
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * Constructor to construct a commentInterface
	 * @param consumerKey Your developer consumer key. 
	 * @param consumerSecret Your developer consumer secret.
	 */
	public commentInterface(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	/**
	 * 500px POST_comments_id_comments. Creates a reply to an existing comment. Comments can only be nested one level deep, you cannot reply to a reply of a comment. If a comment has a non-null parent_id value then it cannot be replied to.
	 * @param id (required) - id of a comment.
	 * @param comment (required) Ñ Content of the comment.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/comments/POST_comments_id_comments.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_comments_id_comments(String id, String comment) {
		String request = id + "/comments";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("body", comment));
			Log.d("fandroid", "post comment: " + request);
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}

}
