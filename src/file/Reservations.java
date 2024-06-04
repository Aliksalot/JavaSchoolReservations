package file;

import java.io.File;

import enums.RoomExtras;
import models.Reservation;

import java.io.FileWriter;

public class Reservations {
  
  public static boolean createReservation(Reservation r){
    try{
      var reservationsFile = new File("reservations.txt");
      if(!reservationsFile.exists()){
        reservationsFile.createNewFile();
      }

      var wr = new FileWriter(reservationsFile);
      var reservationString = r.getPrice() + "";
      for(RoomExtras extra: r.getExtras()){
        reservationString += " " + extra;
      }
      reservationString += " " + r.getNightCount();
      reservationString += " " + r.getType();
      
      wr.append(reservationString + " ");

      wr.close();
    }catch(Exception e){
      System.out.println("Error when writing reservation to file");
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
