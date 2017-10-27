import java.util.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Room> rooms = new ArrayList<>();
  ArrayList<Guest> guests = new ArrayList<>();

  rooms.add(new Room(1, 1, true, 1, 1));

  // for (int i = 0; i < 10; i++) {
  //   guests.add(new Guest("bob", "bobsen", "kbh", 12345678));
  // }

  addGuest(guests);
  addGuest(guests);
  for (int i = 0; i < guests.size(); i++) {
    System.out.println(guests.get(i).toString());
  }
  // for (int i = 0; i < 10; i++) {
  //   guests.get(i).saveToFile("guests.dat");
  // }


  // interFace();
}

public static void addGuest(ArrayList<Guest> guests){
  // guests = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);
  Random rand = new Random();
  int guestID = 0;

  System.out.print("Enter first name: ");
  String firstName = scanner.next();
  System.out.print("Enter last name: ");
  String lastName = scanner.next();
  System.out.print("Enter address: ");
  String address = scanner.next();
  System.out.print("Enter phone number: ");
  int phoneNumber = scanner.nextInt();

  guests.add(new Guest(guestID, firstName, lastName, address, phoneNumber));
  guestID++;
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
  scanner.close();
}
public static void staffOption(){
  Scanner scanner = new Scanner(System.in);
  System.out.println("");
  scanner.close();
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
