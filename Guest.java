import java.io.*;

public class Guest {
private int guestID;
private String firstName;
private String lastName;
private String address;
private int phoneNumber;
private int roomID;

public Guest(int guestID, String firstName, String lastName, String address, int phoneNumber){
  this.guestID = guestID;
  this.firstName = firstName;
  this.lastName = lastName;
  this.address = address;
  this.phoneNumber = phoneNumber;
}

public int getID(){
  return guestID;
}

public void setRoom(int roomID){
  this.roomID = roomID;
}

public void changePhoneNumber(int phoneNumber){
  this.phoneNumber = phoneNumber;
}

public void saveToFile(String file) throws Exception {
  FileWriter writer = new FileWriter(new File(file), true);
  String guest = String.format("%d %s %s %s %d", guestID, firstName, lastName, address, phoneNumber);
  writer.write(guest + "\n");
  writer.flush();
  writer.close();
}

public String toString(){
  return String.format("GuestID: %d firstName: %s lastName: %s address: %s phoneNumber: %d",
                       guestID, firstName, lastName, address, phoneNumber);
}
}
