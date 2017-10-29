import java.io.*;

public class Guest {
private int guestID;
private String firstName;
private String lastName;
private String address;
private int phoneNumber;
private int roomID;

public Guest(int guestID, String firstName, String lastName, String address, int phoneNumber) {
  this.guestID = guestID;
  this.firstName = firstName;
  this.lastName = lastName;
  this.address = address;
  this.phoneNumber = phoneNumber;
}

public void saveFile(String file) throws Exception  {
  FileWriter writer = new FileWriter(new File(file), true);
  String guest = String.format("%d %s %s %s %d ", guestID, firstName, lastName, address, phoneNumber);
  writer.write(guest + "\n");
  writer.flush();
  writer.close();
}





public String toString() {
  return String.format("Name: %s %s \t Address: %s \t PhoneNumber: %d \t GuestID: %d ",
                       firstName, lastName, address, phoneNumber, guestID);
}

public int getGuestID() {
  return guestID;
}

public void setGuestID(int guestID) {
  this.guestID = guestID;
}

public String getFirstName() {
  return firstName;
}

public void setFirstName(String firstName) {
  this.firstName = firstName;
}

public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

public String getAddress() {
  return address;
}

public void setAddress(String address) {
  this.address = address;
}

public int getPhoneNumber() {
  return phoneNumber;
}

public void setPhoneNumber(int phoneNumber) {
  this.phoneNumber = phoneNumber;
}

public int getRoomID() {
  return roomID;
}

public void setRoomID(int roomID) {
  this.roomID = roomID;
}
}
