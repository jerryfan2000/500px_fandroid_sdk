package com.kiumiu.ca.api500px.photo;

/**
 * Representation of geo location in the format of <latitude,longitude,radios<unit>> where unit is either km or mi.
 * @author Jerry Fan
 */
public class Location {
	
	String lon;
	String lat;
	String rad;
	
	/**
	 * @param latitude latitude
	 * @param longitude longitude
	 * @param radius radius in the format of distance+unit. For example 50km, 50mi.
	 */
	public Location(String latitude, String longitude, String radius) {
		lon = longitude;
		lat = latitude;
		rad = radius;
	}
	
	/* (non-Javadoc)
	 * @return return geo location in 500px format.
	 */
	public String toString() {
		return lat + "," + lon + "," + rad;
	}

}
