package com.kiumiu.ca.api500px.primitiveDataType;

/**
 * User object in short format. To read more about each fields, please go to <a href="https://github.com/500px/api-documentation/blob/master/basics/formats_and_terms.md#500px-photo-terms">this page</a> for details.
 * @author Jerry Fan
 *
 */
public class UserShort {
	public int id;
	public String username;
	public String firstname;
	public String lastname;
	public String fullname;
	public String city;
	public String country;
	public String userpic_url;
	public int upgrade_status;
	public int followers_count;
	public int affection;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the userpic_url
	 */
	public String getUserpic_url() {
		return userpic_url;
	}
	/**
	 * @param userpic_url the userpic_url to set
	 */
	public void setUserpic_url(String userpic_url) {
		this.userpic_url = userpic_url;
	}
	/**
	 * Get user upgrade status.
	 * @return the upgrade_status. Integer, Non-zero values identify premium users; a value of 2 identifies an Awesome user while a value of 1 identifies a Plus user. Other states may be added in the future, so write your parsers accordingly.
	 */
	public int getUpgrade_status() {
		return upgrade_status;
	}
	/**
	 * Set user upgrade status with a integer, Non-zero values identify premium users; a value of 2 identifies an Awesome user while a value of 1 identifies a Plus user. Other states may be added in the future, so write your parsers accordingly.
	 * @param upgrade_status the upgrade_status to set
	 */
	public void setUpgrade_status(int upgrade_status) {
		this.upgrade_status = upgrade_status;
	}
	/**
	 * @return the followers_count
	 */
	public int getFollowers_count() {
		return followers_count;
	}
	/**
	 * @param followers_count the followers_count to set
	 */
	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}
	/**
	 * @return the affection
	 */
	public int getAffection() {
		return affection;
	}
	/**
	 * @param affection the affection to set
	 */
	public void setAffection(int affection) {
		this.affection = affection;
	}
}
