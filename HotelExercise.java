import java.util.*;

public class HotelExercise {
public static void main(String[] args){
  ArrayList<Room> rooms = new ArrayList<>();
  rooms.add(new Room(1, 1, true, 1, 1));

  System.out.println(rooms.get(0).toString());
  rooms.get(0).changePrice(200);
  System.out.println(rooms.get(0).toString());
  // interFace();
}
public static void interFace(){
  System.out.println("1: Add guest, 2: Checkout guest, 3: staff options");

  Scanner scanner = new Scanner(System.in);

  switch (readInt()) {
  case 1:
    System.out.println("add");
    break;
  case 2:
    System.out.println("Checkout");
    break;
  case 3:
    System.out.println("staff");
    break;
  default:
    System.out.println("Not valid");
  }
}

public static int readInt() {
  int num = 0;
  try {
    System.out.print("Enter Number: ");
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Not a number!");
    num = readInt();
  }
  return num;
}
}
