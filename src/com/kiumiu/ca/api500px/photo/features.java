package com.kiumiu.ca.api500px.photo;

/**
 * Features parameter used when making photo request.
 * @author jerry
 *
 */
public class Features {
	//Global features
	/**
	 * Return photos in Popular. Default sort: rating.
	 */
	public static String popular = "popular";
	
	/**
	 * Return photos in Upcoming. Default sort: time when Upcoming was reached.
	 */
	public static String upcoming = "upcoming";
	
	/**
	 * Return photos in Editors' Choice. Default sort: time when selected by an editor.
	 */
	public static String editors = "editors";
	
	/**
	 * Return photos in Fresh Today. Default sort: time when reached fresh.
	 */
	public static String fresh_today = "fresh_today";
	
	/**
	 * Return photos in Fresh Yesterday. Default sort: same as 'fresh_today'.
	 */
	public static String fresh_yesterday = "fresh_yesterday";
	
	/**
	 * Return photos in Fresh This Week. Default sort: same as 'fresh_today'.
	 */
	public static String fresh_week = "fresh_week";
	
	//Per user features
	/**
	 * Return photos of a user, additional parameter 'user_id' or 'username' is required. Default sort: time uploaded.
	 */
	public static String user = "user";
	
	/**
	 * Return photos by users the specified user is following. Default sort: time uploaded.
	 */
	public static String user_friends = "user_friends";
	
	/**
	 * Return photos added as favorites by the specified user, as displayed on http://500px.com/:username/favorites. Default sort: time favorited.
	 */
	public static String user_favorites = "user_favorites";

}
