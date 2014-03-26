package com.kiumiu.ca.api500px.photo;

/**
 * Sort criteria constants used in search query.
 * @author jerry
 */
public class Sort {
	
	/**
	 * Default: sort by time of upload, most recent first.
	 */
	public static String created_at = "created_at";
	
	
	/**
	 * Sort by current rating, highest rated first.
	 */
	public static String rating = "rating";
	
	
	/**
	 * Sort by the number of views, most viewed first.
	 */
	public static String times_viewed = "times_viewed";
	
	
	/**
	 * Sort by the number of votes, most voted on first.
	 */
	public static String votes_count = "votes_count";
	
	
	/**
	 * Sort by the number of favorites, most favorited first.
	 */
	public static String favorites_count = "favorites_count";
	
	
	/**
	 * Sort by the number of comments, most commented first.
	 */
	public static String comments_count = "comments_count";
	
	
	/**
	 * Sort by the original date of the image extracted from metadata, most recent first (might not be available for all images).
	 */
	public static String taken_at = "taken_at";
}
