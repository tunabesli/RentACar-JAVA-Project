package Classes;

import java.util.Scanner;

public class User {

	
	private String userName;
	private String password;

	public User() {
	        // Default constructor
	}
	
	public User(String userName,String password) {
        this.userName=userName;
        this.password=password;
	}

	// Getters and Setters

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean findUser(String userName) {
		return this.userName.equalsIgnoreCase(userName);
	}
	@Override
	public String toString() {
		return "User{" + '\'' +  ", userName='"
				+ userName + '\'' + ", password='" + password + '\'' + '}';
	}
}
