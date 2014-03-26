package com.kiumiu.ca.api500px;

/**
 * Class representing request parameter in (String key, String value) format.
 * @author Jerry Fan
 */
public class Parameter {
	String key;
	String value;
	
	/**
	 * @param k Key in String.
	 * @param v Value in String.
	 */
	public Parameter(String k, String v) {
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
