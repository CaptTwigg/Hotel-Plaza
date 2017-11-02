import java.util.*;
import java.io.*;

public class Booking {
private String startDate;
private String endDate;
private int numberOfDays;
private int roomID;
private int guestID;



public Booking(String startDate, String endDate, int roomID, int guestID) {
  this.startDate = startDate;
  this.endDate = endDate;
  this.numberOfDays = days(startDate, endDate);
  this.roomID = roomID;
  this.guestID = guestID;
}

public void saveToFile(String file) throws IOException {
  FileWriter writer = new FileWriter(new File(file), true);
  String booking = String.format("%s %s %d %d", startDate, endDate, roomID, guestID);
  writer.write(booking + "\n");
  writer.flush();
  writer.close();
}

public boolean checkDates(String date1, String date2){
  int[] date1A = new int[3];
  int[] date2A = new int[3];
  String[] splitDate1 = date1.split("\\D+");
  String[] splitDate2 = date2.split("\\D+");

  for (int i = 0; i < 3; i++) {
    if (!isInteger(splitDate1[i])) return false;
    if (!isInteger(splitDate2[i])) return false;
    date1A[i] = Integer.parseInt(splitDate1[i]);
    date2A[i] = Integer.parseInt(splitDate2[i]);
  }
  return date1A[1] >= date2A[1] && date1A[2] >= date2A[2];
}

public static int days(String date1, String date2){
  int[] date1A = new int[3];
  int[] date2A = new int[3];
  String[] splitDate1 = date1.split("\\D+");
  String[] splitDate2 = date2.split("\\D+");

  for (int i = 0; i < 3; i++) {
    date1A[i] = Integer.parseInt(splitDate1[i]);
    date2A[i] = Integer.parseInt(splitDate2[i]);
  }


  int bigger = 0;
  if (date1A[0] > date2A[0]) bigger = 30;

  return bigger - (date1A[0] - date2A[0]) + 30 * (date2A[1] - date1A[1]) + 365 * (date2A[2] - date1A[2]);
}

public static boolean isInteger(String s) {
  try{
    Integer.parseInt(s);
    return true;
  }
  catch (NumberFormatException ex) {
    return false;
  }
}


public String toString() {
  return String.format("StartDate: %s EndDate: %s NumberOfDays: %d RoomID: %d GuestID: %d", startDate, endDate, numberOfDays, roomID, guestID);
}

public String getStartDate() {
  return startDate;
}

public void setStartDate(String startDate) {
  this.startDate = startDate;
}

public String getEndDate() {
  return endDate;
}

public void setEndDate(String endDate) {
  this.endDate = endDate;
  updateNumberOfDays();
}

public int getNumberOfDays() {
  return numberOfDays;
}

public void setNumberOfDays(int numberOfDays) {
  this.numberOfDays = numberOfDays;
}

public int getRoomID() {
  return roomID;
}

public void setRoomID(int roomID) {
  this.roomID = roomID;
}

public int getGuestID() {
  return guestID;
}

public void setGuestID(int guestID) {
  this.guestID = guestID;
}

public void updateNumberOfDays(){
  numberOfDays = days(startDate, endDate);
}
}
