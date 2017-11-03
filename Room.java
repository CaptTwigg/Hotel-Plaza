import java.util.*;
import java.io.*;


public class Room {
private int roomID;
private int numberOfBeds;
private boolean internetAcces;
private int price;
private int floor;

public Room(int roomID, int numberOfBeds, boolean internetAcces, int price, int floor){
  this.roomID = roomID;
  this.numberOfBeds = numberOfBeds;
  this.internetAcces = internetAcces;
  this.price = price;
  this.floor = floor;
}

public void saveToFile(String file) throws Exception {
  FileWriter writer = new FileWriter(new File(file), true);
  String room = String.format("%d %d %b %d %d", roomID, numberOfBeds, internetAcces, price, floor);
  writer.write(room + "\n");
  writer.flush();
  writer.close();
}

public boolean searchID(int roomID){
  return this.roomID == roomID;
}

public int getRoomID() {
  return roomID;
}

public void setRoomID(int roomID) {
  this.roomID = roomID;
}

public int getNumberOfBeds() {
  return numberOfBeds;
}

public void setNumberOfBeds(int numberOfBeds) {
  this.numberOfBeds = numberOfBeds;
}

public boolean isInternetAcces() {
  return internetAcces;
}

public void setInternetAcces(boolean internetAcces) {
  this.internetAcces = internetAcces;
}

public int getPrice() {
  return price;
}

public void setPrice(int price) {
  this.price = price;
}

public int getFloor() {
  return floor;
}

public void setFloor(int floor) {
  this.floor = floor;
}



public String toString() {
  return String.format("RoomID: %d \t Number of beds: %d \t Internet acces %b \t Price: %d \t Floor %d", roomID, numberOfBeds, internetAcces, price, floor);
}
}
