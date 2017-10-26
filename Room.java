public class Room {
int roomID;
int numberOfBeds;
boolean internetAcces;
int price;
int floor;

public void changePrice(int price){
  this.price = price;
}

public String toString(){
  return String.format("roomID: %d numberOfBeds: %d internetAcces: %b price: %d floor: %d",
                       roomID, numberOfBeds, internetAcces, price, floor);
}
}
