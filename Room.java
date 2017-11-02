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

public void changePrice(int price){
  this.price = price;
}

public String toString(){
  return String.format("roomID: %d numberOfBeds: %d internetAcces: %b price: %d floor: %d",
}
}
