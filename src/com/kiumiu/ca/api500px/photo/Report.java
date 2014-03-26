package com.kiumiu.ca.api500px.photo;

/**
 * Representation of report reason to a photo.
 * @author Jerry Fan 
 */
public class Report {

	/**
	 * Report constant for Offensive (rude, obscene).
	 */
	public static int Offensive = 1;
	
	/**
	 * Report constant for Spam (ads, self-promotion).
	 */
	public static int Spam = 2;
	
	/**
	 * Report constant for Offtopic (trolling).
	 */
	public static int Offtopic = 3;
	
	/**
	 * Report constant for Copyright (plagiarism, stealing).
	 */
	public static int Copyright = 4;
	
	/**
	 * Report constant for Wrong content (illustration, 3D)
	 */
	public static int WrongContent = 5;
	
	/**
	 * Report constant for adult material.
	 */
	public static int Adult = 6;
}
