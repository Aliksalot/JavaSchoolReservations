package utils;

public class Random {
	public String generatePropId() {
		var len = 12;		
		var allowedChars = "1234567890qwertyuiopasdfghjklzxcvbnm";
		
		var id = "";
		
		for(var i = 0; i < len ; i++) 
			id += allowedChars.charAt((int)(Math.random() * allowedChars.length()));
		
		return id;
		
	}
}
