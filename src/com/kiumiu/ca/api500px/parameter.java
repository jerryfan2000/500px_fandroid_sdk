package com.kiumiu.ca.api500px;

/**
 * @author Jerry Fan
 * Class representing request parameter in (String key, String value) format.
 */
public class parameter {
	String key;
	String value;
	
	/**
	 * @param k Key in String.
	 * @param v Value in String.
	 */
	public parameter(String k, String v) {
		key = k;
		value = v;
	}
	
	/**
	 * @return Key in String.
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * @return Value in String.
	 */
	public String getValue() {
		return value;
	}
}
