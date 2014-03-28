package com.kiumiu.ca.api500px.responseData;

import java.util.HashMap;

/**
 * User profile object. To read more about each fields, please go to <a href="https://github.com/500px/api-documentation/blob/master/basics/formats_and_terms.md#500px-photo-terms">this page</a> for details.
 * @author Jerry Fan
 *
 */
public class UserFullProfile {
	//UserShort
	public String id;
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
	
	//Extra in profile
	public int sex;
	public String state;
	public String registration_date;
	public String about;
	public String domain;
	public String locale;
	public boolean show_nude;
	public boolean store_on;
	public HashMap<String,String> contacts;
	public HashMap<String,String> equipment;
	public int photos_count;
	public int in_favorites_count;
	public int friends_count;
	public boolean admin;
	public HashMap<String,String> avatars;
	
	//Per user fields
	public String email;
	public int upload_limit;
	public String upload_limit_expiry;
	public String upgrade_expiry_date;
	public HashMap<String,Integer> auth;
	
	//Authed extra fields
	public boolean following;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the registration_date
	 */
	public String getRegistration_date() {
		return registration_date;
	}
	/**
	 * @param registration_date the registration_date to set
	 */
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}
	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	/**
	 * @return the show_nude
	 */
	public boolean isShow_nude() {
		return show_nude;
	}
	/**
	 * @param show_nude the show_nude to set
	 */
	public void setShow_nude(boolean show_nude) {
		this.show_nude = show_nude;
	}
	/**
	 * @return the store_on
	 */
	public boolean isStore_on() {
		return store_on;
	}
	/**
	 * @param store_on the store_on to set
	 */
	public void setStore_on(boolean store_on) {
		this.store_on = store_on;
	}
	/**
	 * @return the contacts
	 */
	public HashMap<String, String> getContacts() {
		return contacts;
	}
	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(HashMap<String, String> contacts) {
		this.contacts = contacts;
	}
	/**
	 * @return the equipment
	 */
	public HashMap<String, String> getEquipment() {
		return equipment;
	}
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(HashMap<String, String> equipment) {
		this.equipment = equipment;
	}
	/**
	 * @return the photos_count
	 */
	public int getPhotos_count() {
		return photos_count;
	}
	/**
	 * @param photos_count the photos_count to set
	 */
	public void setPhotos_count(int photos_count) {
		this.photos_count = photos_count;
	}
	/**
	 * @return the in_favorites_count
	 */
	public int getIn_favorites_count() {
		return in_favorites_count;
	}
	/**
	 * @param in_favorites_count the in_favorites_count to set
	 */
	public void setIn_favorites_count(int in_favorites_count) {
		this.in_favorites_count = in_favorites_count;
	}
	/**
	 * @return the friends_count
	 */
	public int getFriends_count() {
		return friends_count;
	}
	/**
	 * @param friends_count the friends_count to set
	 */
	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}
	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
	 * @return the avatars
	 */
	public HashMap<String, String> getAvatars() {
		return avatars;
	}
	/**
	 * @param avatars the avatars to set
	 */
	public void setAvatars(HashMap<String, String> avatars) {
		this.avatars = avatars;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the upload_limit
	 */
	public int getUpload_limit() {
		return upload_limit;
	}
	/**
	 * @param upload_limit the upload_limit to set
	 */
	public void setUpload_limit(int upload_limit) {
		this.upload_limit = upload_limit;
	}
	/**
	 * @return the upload_limit_expiry
	 */
	public String getUpload_limit_expiry() {
		return upload_limit_expiry;
	}
	/**
	 * @param upload_limit_expiry the upload_limit_expiry to set
	 */
	public void setUpload_limit_expiry(String upload_limit_expiry) {
		this.upload_limit_expiry = upload_limit_expiry;
	}
	/**
	 * @return the upgrade_expiry_date
	 */
	public String getUpgrade_expiry_date() {
		return upgrade_expiry_date;
	}
	/**
	 * @param upgrade_expiry_date the upgrade_expiry_date to set
	 */
	public void setUpgrade_expiry_date(String upgrade_expiry_date) {
		this.upgrade_expiry_date = upgrade_expiry_date;
	}
	/**
	 * @return the auth
	 */
	public HashMap<String, Integer> getAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(HashMap<String, Integer> auth) {
		this.auth = auth;
	}
	/**
	 * @return the following
	 */
	public boolean isFollowing() {
		return following;
	}
	/**
	 * @param following the following to set
	 */
	public void setFollowing(boolean following) {
		this.following = following;
	}
}
