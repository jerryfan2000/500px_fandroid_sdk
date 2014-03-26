package com.kiumiu.ca.api500px.photo;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


/**
 * REST call parameters for {@link photoInterface.put_photos_id} call.
 * @author jerry
 *
 */
public class photoUpdateParams {
	String name;
	String description;
	int category;
	String tags;
	String addTags;
	String removeTags;
	String shutterSpeed;
	String focalLength;
	String aperture;
	int iso;
	String camera;
	String lens;
	String latitude;
	String longitude;
	boolean nsfw;
	int license_type;
	boolean privacy;
	String crop;
	
	/**
	 * Contrust a photo update parameter with name of photo.
	 * @param name name of photo.
	 */
	public photoUpdateParams(String name) {
		this.name = name;
	}
	
	/**
	 * Construct a photo update parameter with name and description of photo.
	 * @param name
	 * @param description
	 */
	public photoUpdateParams(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Construct a photo update parameter with name, description, and category of photo.
	 * @param name
	 * @param description
	 * @param category
	 */
	public photoUpdateParams(String name, String description, int category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getTags() {
		return tags;
	}
	
	public void setAddTags(String addTags) {
		this.addTags = addTags;
	}
	
	public String getAddTags() {
		return addTags;
	}
	
	public void setRemoveTags(String tags) {
		this.removeTags = tags;
	}
	
	public void setShutterSpeed(String speed) {
		this.shutterSpeed = speed;
	}
	
	public String getShutterSpeed() {
		return shutterSpeed;
	}
	
	public void setFocalLength(String focal) {
		this.focalLength = focal;
	}
	
	public String getFocalLength() {
		return focalLength;
	}
	
	public void setAperture(String aperture) {
		this.aperture = aperture;
	}
	
	public String getAperture() {
		return aperture;
	}
	
	public void setLens(String lens) {
		this.lens = lens;
	}
	
	public String getLens() {
		return lens;
	}
	
	public void setCamera(String camera) {
		this.camera = camera;
	}
	
	public String getCamera() {
		return camera;
	}
	
	public void setIso(int iso) {
		this.iso = iso;
	}
	
	public int getIso() {
		return iso;
	}
	
	public void setLatitude(String lat) {
		this.latitude = lat;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLongitude(String lon) {
		this.longitude = lon;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setNsfw(boolean nsfw) {
		this.nsfw = nsfw;
	}
	
	public boolean getNsfw() {
		return nsfw;
	}
	
	public void setLincenseType(int license) {
		this.license_type = license;
	}
	
	public int getLicenseType() {
		return license_type;
	}
	
	public void setPrivacy(boolean isPrivate) {
		this.privacy = isPrivate;
	}
	
	public boolean getPrivacy() {
		return privacy;
	}
	
	/**
	 * Placeholder for now
	 * @param x
	 * @param x2
	 * @param y
	 * @param y2
	 */
	public void setCrop(int x, int x2, int y, int y2) {
		
	}
	
	/**
	 * Place holder for now
	 * @return
	 */
	public String getCrop() {
		return crop;
	}
	
	/**
	 * Generate name value pair to be used in updating photo with {@link photoInterface.put_photos_id}
	 * @return return a properly formatted name value pair used for updating a photo.
	 */
	public ArrayList<NameValuePair> toNameValuePair() {
		ArrayList<NameValuePair> query = new ArrayList<NameValuePair>();
		if(name != null)
			query.add(new BasicNameValuePair("name", name));
		
		if(description != null)
			query.add(new BasicNameValuePair("description", description));
		
		if(category >=0)
			query.add(new BasicNameValuePair("category", "" + category));
		
		if(tags != null)
			query.add(new BasicNameValuePair("tags", tags));
		
		if(addTags != null)
			query.add(new BasicNameValuePair("add_tags", addTags));
		
		if(removeTags != null)
			query.add(new BasicNameValuePair("remove_tags", removeTags));
		
		if(shutterSpeed != null)
			query.add(new BasicNameValuePair("shutter_speed", shutterSpeed));
		
		if(focalLength != null)
			query.add(new BasicNameValuePair("focal_length", focalLength));
		
		if(aperture != null)
			query.add(new BasicNameValuePair("aperture", aperture));
		
		if(iso > 0)
			query.add(new BasicNameValuePair("iso", "" + iso));
		
		if(camera != null)
			query.add(new BasicNameValuePair("camera", camera));
		
		if(lens != null)
			query.add(new BasicNameValuePair("lens", lens));
		
		if(latitude != null)
			query.add(new BasicNameValuePair("latitude", latitude));
		
		if(longitude != null)
			query.add(new BasicNameValuePair("longitude", longitude));
		
		if(nsfw)
			query.add(new BasicNameValuePair("nsfw", "true"));
		else 
			query.add(new BasicNameValuePair("nsfw", "false"));
		
		if(license_type >= 0)
			query.add(new BasicNameValuePair("license_type", "" + license_type));
		
		if(privacy)
			query.add(new BasicNameValuePair("privacy", "1"));
		else
			query.add(new BasicNameValuePair("privacy", "0"));
		
		return query;
	}
}
