package com.kiumiu.ca.api500px.primitiveDataType;

import com.google.gson.annotations.SerializedName;

public class CollectionShort {
	public PhotoShort[] photos;
	public int position;
	public int id;
	public String title;
	public int total_items;
	public String path;
	public boolean has_password;
	public String created_at;
	public UserShort user;
	public String kind;
	@SerializedName("private")
	public boolean privacy;
	
	/**
	 * @return the photos
	 */
	public PhotoShort[] getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(PhotoShort[] photos) {
		this.photos = photos;
	}
	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the total_items
	 */
	public int getTotal_items() {
		return total_items;
	}
	/**
	 * @param total_items the total_items to set
	 */
	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the has_password
	 */
	public boolean isHas_password() {
		return has_password;
	}
	/**
	 * @param has_password the has_password to set
	 */
	public void setHas_password(boolean has_password) {
		this.has_password = has_password;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the user
	 */
	public UserShort getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserShort user) {
		this.user = user;
	}
	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the privacy
	 */
	public boolean isPrivacy() {
		return privacy;
	}
	/**
	 * @param privacy the privacy to set
	 */
	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}
	
}
