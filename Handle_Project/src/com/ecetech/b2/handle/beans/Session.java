package com.ecetech.b2.handle.beans;

/**
 * création de la session
 */

public class Session {
	private String userName;
	private String userPsw;
	private String userEmail;
	
	
	public Session(String userName, String userPsw, String userEmail) {
		super();
		this.userName = userName;
		this.userPsw = userPsw;
		this.userEmail = userEmail;
		}


	public Session() {
		this("","","");
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPsw() {
		return userPsw;
	}


	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	

}
