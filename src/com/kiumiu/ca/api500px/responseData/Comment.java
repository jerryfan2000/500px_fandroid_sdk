package com.kiumiu.ca.api500px.responseData;

/**
 * Comment objects. To read more about each fields, please go to <a href="https://github.com/500px/api-documentation/blob/master/basics/formats_and_terms.md#500px-photo-terms">this page</a> for details.
 * @author Jerry Fan
 *
 */
public class Comment {
	public String id;
	public String body;
	public String to_whom_user_id;
	public String user_id;
	public String created_at;
	public UserShort user;
	public int parent_id;
	public boolean flagged;
	public int rating;
	
	//fields available with access token
	public boolean voted;

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
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the to_whom_user_id
	 */
	public String getTo_whom_user_id() {
		return to_whom_user_id;
	}

	/**
	 * @param to_whom_user_id the to_whom_user_id to set
	 */
	public void setTo_whom_user_id(String to_whom_user_id) {
		this.to_whom_user_id = to_whom_user_id;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	 * @return the parent_id
	 */
	public int getParent_id() {
		return parent_id;
	}

	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * @return the flagged
	 */
	public boolean isFlagged() {
		return flagged;
	}

	/**
	 * @param flagged the flagged to set
	 */
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
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
	

}
