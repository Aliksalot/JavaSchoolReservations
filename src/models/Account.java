package models;
import file.Accounts;

public class Account {
	private String username;
	private String password;
	
	public Account(String username, String password) {
		//Creates new account
		this.password = password;
		this.username = username;

		var result = Accounts.createAccount(username, password);
		System.out.println(result);
	}
	
	public Account(String username) {
		//Populates with existing account
		
		var password = Accounts.getPasswordByAccountName(username);

		this.password = password;
		this.username = username;
	}
	
	public boolean comparePasswords(String attempt) {
		return attempt.equals(this.password);					
	}

	public String getName(){
		return this.username;
	}
}
