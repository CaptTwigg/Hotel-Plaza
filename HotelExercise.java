import java.util.*;
import java.io.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Room> rooms = new ArrayList<>();
  ArrayList<Guest> guests = new ArrayList<>();

  loadGuestFile("guests.dat", guests);

  // generateGuests(5, guests);
  // addGuest(guests);
  // saveGuestsToFile("guests.dat", guests);
  for (int i = 0; i < guests.size(); i++) {
    System.out.println(guests.get(i).toString());
  }



  // interFace();
}

public static void addGuest(ArrayList<Guest> guests){
  // guests = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);
  // int guestID = 0;

  System.out.print("Enter first name: ");
  String firstName = scanner.next();
  System.out.print("Enter last name: ");
  String lastName = scanner.next();
  System.out.print("Enter address: ");
  String address = scanner.next();
  System.out.print("Enter phone number: ");
  int phoneNumber = scanner.nextInt();

  guests.add(new Guest(firstName, lastName, address, phoneNumber));
  // guestID++;
}

public static void saveGuestsToFile(String file, ArrayList<Guest> guests) throws Exception {
  for (int i = 0; i < 10; i++) {
    guests.get(i).saveFile("guests.dat");
  }
}

public static void loadGuestFile(String file, ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(new File(file));

  while (scanner.hasNextLine()) {
    String guest = scanner.nextLine();
    Scanner lineScan = new Scanner(guest);

    guests.add(new Guest(lineScan.next(), lineScan.next(), lineScan.next(), lineScan.nextInt()));
    lineScan.close();
  }
  scanner.close();
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
public static String randomName(){
  Random random = new Random();
  String[] names = { "Jay", "Hae", "Sindy", "Carmon", "Janeth", "Vernon", "Olin", "In" };

  return names[random.nextInt(names.length)];
}

public static String randomAddress(){
  Random random = new Random();
  String[] names = { "København", "Odense", "Aarhus", "Herlev", "Taarnby", "Dragoer", "Roskilde" };

  return names[random.nextInt(names.length)];
}

public static int randomNumber(){
  Random random = new Random();
  return random.nextInt(89999999) + 10000000;
}

public static void generateGuests(int numberOfGuests, ArrayList<Guest> guests){
  for (int i = 0; i < numberOfGuests; i++) {
    guests.add(new Guest(randomName(), randomName(), randomAddress(), randomNumber()));
  }
}
}
