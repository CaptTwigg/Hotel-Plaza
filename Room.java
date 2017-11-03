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

public String saveToFile(){
  return String.format("%d %d %b %d %d", roomID, numberOfBeds, internetAcces, price, floor);
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



@Override
public String toString() {
  return "Room [roomID=" + roomID + ", numberOfBeds=" + numberOfBeds + ", internetAcces=" + internetAcces + ", price=" + price + ", floor=" + floor + "]";
}
}
