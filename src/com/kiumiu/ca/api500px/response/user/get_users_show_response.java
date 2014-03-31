package com.kiumiu.ca.api500px.response.user;

import com.kiumiu.ca.api500px.primitiveDataType.UserFullProfile;

public class get_users_show_response {
	public UserFullProfile user;

	/**
	 * @return the user
	 */
	public UserFullProfile getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserFullProfile user) {
		this.user = user;
	}
	
}
