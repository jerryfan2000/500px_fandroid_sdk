package com.kiumiu.ca.api500px.responseData;

import java.util.ArrayList;

/**
 * Photo object in short format. To read more about each fields, please go to <a href="https://github.com/500px/api-documentation/blob/master/basics/formats_and_terms.md#500px-photo-terms">this page</a> for details.
 * @author Jerry Fan
 *
 */
public class PhotoFull {
	//data objects
	public String id;
	public String name;
	public String description;
	public String camera;
	public String lens;
	public String focal_length;
	public int iso;
	public String shutter_speed;
	public String aperture;
	public int times_viewed;
	public double rating;
	public int status;
	public String created_at;
	public int category;
	public String location;
	public boolean privacy;
	public String latitude;
	public String longitude;
	public String taken_at;
	public boolean for_sale;
	public int width;
	public int height;
	public int votes_count;
	public int favorites_count;
	public int comments_count;
	public int positive_votes_count;
	public boolean nsfw;
	public int sales_count;
	public double highest_rating;
	public String highest_rating_date;
	public int license_type;
	public boolean converted;
	public String[] images;
	public UserShort user;
	public Comment[] comments;
	public boolean store_download;
	public boolean store_print;
	public boolean editors_choice;
	public String feature;
	public int collections_count;
	
	//Per user based data
	public boolean voted;
	public boolean favorited;
	public boolean purchased;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the camera
	 */
	public String getCamera() {
		return camera;
	}
	/**
	 * @param camera the camera to set
	 */
	public void setCamera(String camera) {
		this.camera = camera;
	}
	/**
	 * @return the lens
	 */
	public String getLens() {
		return lens;
	}
	/**
	 * @param lens the lens to set
	 */
	public void setLens(String lens) {
		this.lens = lens;
	}
	/**
	 * @return the focal_length
	 */
	public String getFocal_length() {
		return focal_length;
	}
	/**
	 * @param focal_length the focal_length to set
	 */
	public void setFocal_length(String focal_length) {
		this.focal_length = focal_length;
	}
	/**
	 * @return the iso
	 */
	public int getIso() {
		return iso;
	}
	/**
	 * @param iso the iso to set
	 */
	public void setIso(int iso) {
		this.iso = iso;
	}
	/**
	 * @return the shutter_speed
	 */
	public String getShutter_speed() {
		return shutter_speed;
	}
	/**
	 * @param shutter_speed the shutter_speed to set
	 */
	public void setShutter_speed(String shutter_speed) {
		this.shutter_speed = shutter_speed;
	}
	/**
	 * @return the aperture
	 */
	public String getAperture() {
		return aperture;
	}
	/**
	 * @param aperture the aperture to set
	 */
	public void setAperture(String aperture) {
		this.aperture = aperture;
	}
	/**
	 * @return the times_viewed
	 */
	public int getTimes_viewed() {
		return times_viewed;
	}
	/**
	 * @param times_viewed the times_viewed to set
	 */
	public void setTimes_viewed(int times_viewed) {
		this.times_viewed = times_viewed;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the taken_at
	 */
	public String getTaken_at() {
		return taken_at;
	}
	/**
	 * @param taken_at the taken_at to set
	 */
	public void setTaken_at(String taken_at) {
		this.taken_at = taken_at;
	}
	/**
	 * @return the for_sale
	 */
	public boolean isFor_sale() {
		return for_sale;
	}
	/**
	 * @param for_sale the for_sale to set
	 */
	public void setFor_sale(boolean for_sale) {
		this.for_sale = for_sale;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the votes_count
	 */
	public int getVotes_count() {
		return votes_count;
	}
	/**
	 * @param votes_count the votes_count to set
	 */
	public void setVotes_count(int votes_count) {
		this.votes_count = votes_count;
	}
	/**
	 * @return the favorites_count
	 */
	public int getFavorites_count() {
		return favorites_count;
	}
	/**
	 * @param favorites_count the favorites_count to set
	 */
	public void setFavorites_count(int favorites_count) {
		this.favorites_count = favorites_count;
	}
	/**
	 * @return the comments_count
	 */
	public int getComments_count() {
		return comments_count;
	}
	/**
	 * @param comments_count the comments_count to set
	 */
	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}
	/**
	 * @return the positive_votes_count
	 */
	public int getPositive_votes_count() {
		return positive_votes_count;
	}
	/**
	 * @param positive_votes_count the positive_votes_count to set
	 */
	public void setPositive_votes_count(int positive_votes_count) {
		this.positive_votes_count = positive_votes_count;
	}
	/**
	 * @return the nsfw
	 */
	public boolean isNsfw() {
		return nsfw;
	}
	/**
	 * @param nsfw the nsfw to set
	 */
	public void setNsfw(boolean nsfw) {
		this.nsfw = nsfw;
	}
	/**
	 * @return the sales_count
	 */
	public int getSales_count() {
		return sales_count;
	}
	/**
	 * @param sales_count the sales_count to set
	 */
	public void setSales_count(int sales_count) {
		this.sales_count = sales_count;
	}
	/**
	 * @return the highest_rating
	 */
	public double getHighest_rating() {
		return highest_rating;
	}
	/**
	 * @param highest_rating the highest_rating to set
	 */
	public void setHighest_rating(float highest_rating) {
		this.highest_rating = highest_rating;
	}
	/**
	 * @return the highest_rating_date
	 */
	public String getHighest_rating_date() {
		return highest_rating_date;
	}
	/**
	 * @param highest_rating_date the highest_rating_date to set
	 */
	public void setHighest_rating_date(String highest_rating_date) {
		this.highest_rating_date = highest_rating_date;
	}
	/**
	 * @return the license_type
	 */
	public int getLicense_type() {
		return license_type;
	}
	/**
	 * @param license_type the license_type to set
	 */
	public void setLicense_type(int license_type) {
		this.license_type = license_type;
	}
	/**
	 * @return the converted
	 */
	public boolean isConverted() {
		return converted;
	}
	/**
	 * @param converted the converted to set
	 */
	public void setConverted(boolean converted) {
		this.converted = converted;
	}
	/**
	 * @return the image_size
	 */
	public String[] getImages() {
		return images;
	}
	/**
	 * @param image_size the image_size to set
	 */
	public void setImage_size(String[] images) {
		this.images = images;
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
	 * @return the collections_count
	 */
	public int getCollections_count() {
		return collections_count;
	}
	/**
	 * @param collections_count the collections_count to set
	 */
	public void setCollections_count(int collections_count) {
		this.collections_count = collections_count;
	}
	/**
	 * @return the comments
	 */
	public Comment[] getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Comment[] comments) {
		this.comments = comments;
	}
	/**
	 * @return the store_download
	 */
	public boolean isStore_download() {
		return store_download;
	}
	/**
	 * @param store_download the store_download to set
	 */
	public void setStore_download(boolean store_download) {
		this.store_download = store_download;
	}
	/**
	 * @return the store_print
	 */
	public boolean isStore_print() {
		return store_print;
	}
	/**
	 * @param store_print the store_print to set
	 */
	public void setStore_print(boolean store_print) {
		this.store_print = store_print;
	}
	/**
	 * @return the editors_choice
	 */
	public boolean isEditors_choice() {
		return editors_choice;
	}
	/**
	 * @param editors_choice the editors_choice to set
	 */
	public void setEditors_choice(boolean editors_choice) {
		this.editors_choice = editors_choice;
	}
	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	/**
	 * @return the voted
	 */
	public boolean isVoted() {
		return voted;
	}
	/**
	 * @param voted the voted to set
	 */
	public void setVoted(boolean voted) {
		this.voted = voted;
	}
	/**
	 * @return the favorited
	 */
	public boolean isFavorited() {
		return favorited;
	}
	/**
	 * @param favorited the favorited to set
	 */
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	/**
	 * @return the purchased
	 */
	public boolean isPurchased() {
		return purchased;
	}
	/**
	 * @param purchased the purchased to set
	 */
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	
}
