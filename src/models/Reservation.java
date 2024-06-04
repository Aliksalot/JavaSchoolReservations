package models;
import enums.*;
import file.Reservations;

import java.util.*;

public class Reservation {
	private int nightCount;
	private ArrayList<RoomExtras> extras;
	private RoomType type;
	private int price; 
	
	public Reservation(int price, int nightCount, ArrayList<RoomExtras> extras, RoomType type) {
		this.extras = extras;
		this.nightCount = nightCount;
		this.type = type;
		this.price = price;
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

	public int getPrice(){
		return this.price;
	}

	public boolean writeToFile(){
		return Reservations.createReservation(this);
	}
	
	
}
