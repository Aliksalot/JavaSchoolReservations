package models;
import enums.*;
import java.util.*;

public class Reservation {
	private int nightCount;
	private ArrayList<RoomExtras> extras;
	private RoomType type;
	private String id;
	
	public Reservation(String id) {
		//TODO populate fields from file or throw
	}
	
	public Reservation(int nightCount, ArrayList<RoomExtras> extras, RoomType type) {
		//TODO create new file with these props
		this.extras=extras;
		this.nightCount = nightCount;
		this.type = type;
	}
	
	//TODO make them change shit in file 
	public void setNightCount(int nightCount) {
		this.nightCount = nightCount;
	}
	
	//TODO make them change shit in file 
	public void setRoomType(RoomType roomType) {
		this.type = roomType;
	}
	
	//TODO make them change shit in file 
	public void setExtras(ArrayList<RoomExtras> extras) {
		this.extras=extras;
	}
	
	public ArrayList<RoomExtras> getExtras(){
		return this.extras;
	}
	
	public int getNightCount() {
		return this.nightCount;
	}
	
	public RoomType getType(){
		return this.type;
	}
	
	
}
