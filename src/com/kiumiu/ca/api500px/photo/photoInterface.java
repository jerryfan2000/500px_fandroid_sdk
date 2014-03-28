package com.kiumiu.ca.api500px.photo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.net.Uri;
import android.util.Log;
import com.fivehundredpx.api.auth.AccessToken;
import com.kiumiu.ca.api500px.RESTTransport;

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
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/DELETE_photos_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id(String id) {
		return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id);
	}
	
	/**
	 * 500px DELETE_photos_id_favorite. Used to remove the photo to user's list of favorites.
	 * @param id Photo with ID to be deleted.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/DELETE_photos_id_favorite.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id_faviorte(String id) {
		return new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id + "/favorite");
	}
	
	/**
	 * 500px DELETE_photos_id_tags. Used to remove tags from the photo. Accepts one or multiple coma separated tags.
	 * @param id Photo with ID to be deleted.
	 * @param tags String array of tags to be deleted.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/DELETE_photos_id_tags.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject delete_photo_id_tags(String id, String[] tags) {
		StringBuilder builder = new StringBuilder();
		builder.append("tags=");
		
		for(int x=0; x<tags.length; x++) {
			if(x>=tags.length-1)
				try{
					builder.append(URLEncoder.encode(tags[x],"UTF-8"));
				} catch(UnsupportedEncodingException e) { e.printStackTrace(); }
			else
				builder.append(tags[x] + ",");
		}
		
		return  new RESTTransport(token, consumerKey, consumerSecret).delete(url + "/" + id + "/tags?" + builder.toString());
	}
	
	
	/**
	 * 500px GET_photos. This version lets developer to manually build URL request string with valid consumer key or access token.
	 * @param request request URL for requesting photos from manually built request URL.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos.md">500px API</a> for details.
	 * <p><b>Remark:</b> Request String *Must* starts from ? excluding /photos, for example '?features=popular&only=Animals'.
	 */
	public JSONObject get_photos(String request) {
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + request);
		else
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + request);
	}
	
	/**
	 * 500px GET_photos. This version lets developer to build URL request string with valid consumer key or access token.
	 * @param (required) feature photo stream to be retrieved. Default fresh_today. One of the constant in Class '{@link Features}'.
	 * @param only String array of names of the category to return photos from. Must be one of the constant in {@link Category}.
	 * @param exclude String name of the category to exclude photos by. Must be one of the constant in {@link Category}.
	 * @param sort Sort photos in the specified order. Must be one of the constant in {@link Sort}.
	 * @param sort_direction  Control the order of the sorting. You can provide a sort_direction without providing a sort, in which case the default sort for the requested feature will be adjusted. Must be one of the constant in {@link SortDirection}. 
	 * @param page Return a specific page in the photo stream. Page numbering is 1-based.
	 * @param rpp The number of results to return. Can not be over 100, default 20.
	 * @param image_size The photo size to be returned. It has to be an integer: 1 to 4.
	 * @param include_store True to returns market information about the photo.
	 * @param include_states True to returns state of the photo for the currently logged in user and authenticated request.
	 * @param tags True to returns an array of tags for the photo.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos.md">500px API</a> for details.
	 */
	public JSONObject get_photos(String feature, String[] only, String[] exclude, String sort, String sort_direction, 
			int page, int rpp, int image_size, boolean include_store, boolean include_states, boolean tags) {
		//Build request parameters here
		String request = "?features=" + feature + "&";
		StringBuilder builder = new StringBuilder(request);
		
		if(only != null) {
			builder.append("only=");
			for(int x=0; x<only.length; x++)
				if(x == only.length-1)
					builder.append(only[x] + "&");
				else
					builder.append(only[x] + ",");
			
			if(exclude != null) {
				builder.append("exclude=");
				for(int x=0; x<exclude.length; x++)
					if(x == exclude.length-1)
						builder.append(exclude[x] + "&");
					else
						builder.append(exclude[x] + ",");
			}
			
			if(sort != null)
				builder.append("sort=" + sort + "&");
			
			if(sort_direction != null)
				builder.append("sort_direction=" + sort_direction + "&");
			
			if(page > 0)
				builder.append("page=" + page + "&");
			
			if(rpp > 0)
				builder.append("rpp=" + rpp + "&");
			
			if(image_size >= 1 && image_size <= 4)
				builder.append("image_size=" + image_size + "&");
			
			if(include_store)
				builder.append("include_store=1&");
			
			if(include_states)
				builder.append("include_states=1&");
			
			if(tags)
				builder.append("tags=1");
		}
			
		Log.d("fandroid", url + "/" + builder.toString());
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
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
			builder.append("comments=true&");
		
		if(tags)
			builder.append("tags=true&");
		
		if(comment_page >=1)
			builder.append("page=" + comment_page + "&");
		else
			builder.append("page=1&");
		
		if(image_size >= 1 && image_size <= 4)
			builder.append("image_size=" + image_size + "&");
		else
			builder.append("image_size=1&");
		
		if(token == null)
			return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
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
			builder.append("nested=1&");
		
		if(page >= 1)
			builder.append("page=" + page + "&");
		else
			builder.append("page=1&");
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px Get_photos_id_favorites. returns all users that had favorite that photo. Valid access token required.
	 * @param id (Required) the Photo ID to get favorites for.
	 * @param page return a specific page in the comment listing. Page numbering is 1-based.
	 * @param rpp the number of results to return. Can not be over 100, default 20.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id_favorites.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
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
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px Get_photos_id_votes. returns all users that had liked this photo. Valid access token required.
	 * @param id (Required) the Photo ID to get favorites for.
	 * @param page return a specific page in the photo stream. Page numbering is 1-based.
	 * @param rpp the number of results to return. Can not be over 100, default 20.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_id_votes.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject get_photos_id_votes(String id, int page, int rpp) {
		String request = id + "/votes?";
		StringBuilder builder = new StringBuilder(request);
		
		if(page >= 1)
			builder.append("page=" + page + "&");
		else
			builder.append("page=1&");
		
		if(rpp >= 1)
			builder.append("rpp=" + rpp + "&");
		else
			builder.append("rpp=1&");
		Log.d("fandroid", url + "/" + builder.toString());
		return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
	}
	
	/**
	 * 500px GET_photos_search. returns a listing of twenty (up to one hundred) photos from search results for a specified tag, keyword, or location.
	 * @param term a keyword to search for.
	 * @param tags a complete tag string to search for.
	 * @param geo a geo-location point of the format latitude,longitude,radius<units>. Acceptable units are km or mi. (Example format 23.00,123.00,20km)
	 * @param only an array of String constant defined in {@link category} to return photos from. Note: Case sensitive.
	 * @param page return a specific page. Page numbering is 1-based.
	 * @param rpp the number of results to return. Can not be over 100, default 20.
	 * @param showTags returns an array of tags for each photo.
	 * @param image_size the photo size to be returned. It has to be an integer: 1 (smallest) to 4 (largest).
	 * @param sort one of the sort order constant defined in {@link sort}.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos_search.md">500px API</a> for details.
	 */
	public JSONObject get_photos_search(String term, String tags, Location geo, String[] only, int page, int rpp, boolean showTags, int image_size, String sort) {
		String request = "search?";
		StringBuilder builder = new StringBuilder(request);
		
		if(term != null)
			try {
				builder.append("term=" + URLEncoder.encode(term,"UTF-8") + "&");
			} catch(Exception e) { e.printStackTrace(); };
		
		if(tags != null)
			try {
				builder.append("tags=" + URLEncoder.encode(tags, "UTF-8") + "&");
			} catch(Exception e) { e.printStackTrace(); }
		
		if(geo != null)
			try {
				builder.append("geo=" + geo.toString() + "&");
			} catch(Exception e) { e.printStackTrace(); }
		
		if(only != null)
			try {
				builder.append("only=");
				for(int x=0; x<only.length; x++)
					builder.append(URLEncoder.encode(only[x], "UTF-8") + ",");
				builder.append("&");
			} catch(Exception e) { e.printStackTrace(); }
		
		if(page >= 1)
			builder.append("page=" + page + "&");
		else
			builder.append("page=1&");
		
		if(rpp >=1)
			builder.append("rpp=" + rpp + "&");
		else
			builder.append("rpp=20&");
		
		if(showTags)
			builder.append("tags&");
		
		if(image_size >=1 && image_size<=4)
			builder.append("image_size=" + image_size + "&");
		else
			builder.append("image_size=1&");
		
		if(sort != null)
			builder.append("sort=" + sort + "&");

		Log.d("fandroid", url + "/" + builder.toString());
		if(token != null)
			return  new RESTTransport(token, consumerKey, consumerSecret).get(url + "/" + builder.toString());
		else
			return  new RESTTransport(consumerKey).get(url + "/" + builder.toString());
	}
	
	/**
	 * A placeholder for image upload future implementation
	 * @return null
	 */
	public JSONObject post_photos() {
		return null;
	}
	
	/**
	 * 500px POST_photos_id_favorite. adds the photo to user's list of favorites.
	 * @param id ID of the photo to favorite.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_id_favorite.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_photos_id_favorite(String id) {
		String request = id + "/favorite";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			//params.add(new BasicNameValuePair("id", id));
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}
	
	/**
	 * 500px POST_photos_id_report. Report inappropriate post to 500px with reason defined in {@link report}
	 * @param id ID of the photo to report.
	 * @param reason (required) Ñ Reason for the report.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_id_report.md">500px API</a> for details.
	 */
	public JSONObject post_photos_id_report(String id, int reason) {
		String request = id + "/report";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("id", id));
			params.add(new BasicNameValuePair("reason", "" + reason));
			Log.d("fandroid", "Post report");
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}
	
	/**
	 * 500px POST_photos_id_tags. Adds tags to the photo. Accepts one or multiple coma separated tags.
	 * @param id ID of the photo to add tags.
	 * @param tags (required) Ñ Coma separated tags.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_id_tags.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_photos_id_tags(String id, String[] tags) {
		String request = id + "/tags";
		String body = "";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			for(int x=0; x<tags.length; x++)
				if(x==tags.length-1)
					body = body + tags[x];
				else
					body = body + tags[x] + ",";
			params.add(new BasicNameValuePair("tags", body));
			Log.d("fandroid", "delete tags");
			Log.d("fandroid", "body: " + body);
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}
	
	/**
	 * 500px POST_photos_id_comments. Creates a new comment for the photo.
	 * @param id (required) Ñ The Photo ID to post comments for.
	 * @param comments (required) Ñ Content of the comment.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_id_comments.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_photos_id_comments(String id, String comments) {
		String request = id + "/comments";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("body", comments));
			Log.d("fandroid", "post comment");
			Log.d("fandroid", "body: " + comments);
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}
	
	/**
	 * 500px POST_photos_id_vote. Vote on a particular photo.
	 * @param id (required) Ñ ID of the photo the vote is cast upon.
	 * @param like (required) Ñ vote, values: '0' for 'dislike' or '1' for 'like'.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_id_vote.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_photos_id_vote(String id, boolean like) {
		String request = id + "/vote?";
		if(like)
			request = request + "vote=1";
		else
			request = request + "vote=0";
		
		if(token != null) {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			Log.d("fandroid", "post vote: " + request);
			return new RESTTransport(token, consumerKey, consumerSecret).post(url + "/" + request, params);
		}
		return null;
	}
	

	/**
	 * 500px POST_photos_upload. Upload a photo to 500px. This feature is currently in beta by 500px and is subject to change. If your photo contains EXIF and IPTC tags, you can skip technical parameters.
	 * @param imagePath (required) - Photo filename in JPG/JPEG in Uri format.
	 * @param name Title of the photo.
	 * @param description Description for the photo.
	 * @param category A numerical ID for the Category of the photo as defined in {@link Category}.
	 * @param privacy Whether to hide the photo from the user profile on the website. Otherwise, the photo is only available for use in Collections/Portfolio.
	 * @param shutter_speed Shutter speed in seconds, represented by string containing a rational expression if the value is 1sec.
	 * @param focal_length Focal length in millimetres, a string representing an integer value.
	 * @param aperture Aperture value in integer format. There is no need to add f/ as prefix.
	 * @param iso ISO value.
	 * @param camera Make and model of the camera. Note: Please make sure it contains sensible information (eg., does not contain camera's make or model twice)
	 * @param lens Lens used to make this photo.
	 * @param latitude Latitude, in xxxx.xxxx format.
	 * @param longitude Longitude, in xxx.xxxx format
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/POST_photos_upload.md">500px API</a> for details. 
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject post_photos_upload(Uri imagePath, String name, String description, int category, 
			boolean privacy, String shutter_speed, String focal_length, String aperture, int iso, 
			String camera, String lens, String latitude, String longitude) {
		String request = "upload?";
		try{
		MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		
		if(imagePath != null)
			entity.addPart("file", new FileBody(new File(imagePath.getPath())));
		
		if(name != null)
			entity.addPart("name", new StringBody(name));
		
		if(description != null)
			entity.addPart("description", new StringBody(description));
		
		if(category >= 0)
			entity.addPart("category", new StringBody("" + category));
		
		if(privacy)
			entity.addPart("privacy", new StringBody("1"));
		
		if(shutter_speed != null)
			entity.addPart("shutter_speed", new StringBody(shutter_speed));
		
		if(focal_length != null)
			entity.addPart("focal_length", new StringBody(focal_length));
		
		if(aperture != null)
			entity.addPart("aperture", new StringBody(aperture));
		
		if(iso > 0)
			entity.addPart("iso", new StringBody("" + iso));
		
		if(camera != null)
			entity.addPart("camera", new StringBody(camera));
		
		if(lens != null)
			entity.addPart("lens", new StringBody(lens));
		
		if(latitude != null)
			entity.addPart("latitude", new StringBody(latitude));
		
		if(longitude != null)
			entity.addPart("longitude", new StringBody(longitude));
			
		if(token != null) {
			return new RESTTransport(token, consumerKey, consumerSecret).postMultiPart(url + "/" + request, entity);
		}
		return null;
		
		} catch(Exception e) { e.printStackTrace(); }
		
		return null;

	}
	
	/**
	 * A placeholder for put photo future implementation
	 * @param query an array list of update query obtained from {@link photoUpdateParams} with photoUpdateParams.toNameValuePair.
	 * @param id (required) Ñ The Photo ID to update.
	 * @return JSON response. See <a href="https://github.com/500px/api-documentation/blob/master/endpoints/photo/PUT_photos_id.md">500px API</a> for details.
	 * <p><b>Remark:</b> Requires OAuth authentication.
	 */
	public JSONObject put_photos_id(String id, ArrayList<NameValuePair> query) {
		String request = id;
		
		if(token != null) {
			Log.d("fandroid", "update photo");
			return new RESTTransport(token, consumerKey, consumerSecret).put(url + "/" + request + "?", query);
		}
		return null;
	}
	
}
