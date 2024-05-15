package models;

public class Account {
	private String id;
	private String username;
	private String password;
	
	public Account(String username, String password) {
		//Creates new account
	}
	
	public Account(String username) {
		//Populates with existing account
	}
	
	public boolean comparePasswords(String attempt) {
		return attempt.equals(this.password);					
	}
}
