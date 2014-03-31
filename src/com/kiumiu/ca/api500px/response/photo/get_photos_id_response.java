package com.kiumiu.ca.api500px.response.photo;

import com.kiumiu.ca.api500px.primitiveDataType.Comment;
import com.kiumiu.ca.api500px.primitiveDataType.PhotoFull;

public class get_photos_id_response {
	public Comment[] comments;
	public PhotoFull photo;
	
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
	 * @return the photo
	 */
	public PhotoFull getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(PhotoFull photo) {
		this.photo = photo;
	}
	
}
