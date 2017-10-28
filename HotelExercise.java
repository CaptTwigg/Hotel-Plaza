import java.util.*;
import java.io.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Guest> guests = new ArrayList<>();

  // loadGuestFile("guests.dat", guests);

  generateGuests(5, guests);
  // addGuest(guests);

  saveGuestsToFile("guests.dat", guests);
  showGuests(guests);
  // System.out.print(updateGuestID());



  // interFace();
}

public static void addGuest(ArrayList<Guest> guests) throws Exception {
  // guests = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter first name: ");
  String firstName = scanner.next();
  System.out.print("Enter last name: ");
  String lastName = scanner.next();
  System.out.print("Enter address: ");
  String address = scanner.next();
  // System.out.print("Enter phone number: ");
  int phoneNumber = readInt("Enter phone number");

  guests.add(new Guest(updateGuestID(), firstName, lastName, address, phoneNumber));
}

public static int updateGuestID() throws Exception {
  int guestID;
  final int first = 0;
  if (first == 0) guestID = getGuestID("guests.dat");
  else guestID = 0;


  // if (firstTime > guestID) guestID = firstTime;
  guestID++;
  first++;

  return guestID;
}

public static int getGuestID(String file) throws Exception {
  Scanner scanner = new Scanner(new File(file));
  int guestID = 0;
  while (scanner.hasNextLine()) {
    String ID = scanner.nextLine();
    Scanner lineScan = new Scanner(ID);
    guestID = lineScan.nextInt();
  }
  scanner.close();
  return guestID;
}

public static void saveGuestsToFile(String file, ArrayList<Guest> guests) throws Exception {
  for (int i = 0; i < guests.size(); i++) {
    guests.get(i).saveFile(file);
  }
}

public static void loadGuestFile(String file, ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(new File(file));

  while (scanner.hasNextLine()) {
    String guest = scanner.nextLine();
    Scanner lineScan = new Scanner(guest);

    guests.add(new Guest(lineScan.nextInt(), lineScan.next(), lineScan.next(), lineScan.next(), lineScan.nextInt()));
    lineScan.close();
  }
  scanner.close();
}

public static void showGuests(ArrayList<Guest> guests){
  for (int i = 0; i < guests.size(); i++) {
    System.out.println(guests.get(i).toString());
  }
}


public static void interFace(){
  System.out.println("1: Add guest, 2: Checkout guest, 3: staff options");

  Scanner scanner = new Scanner(System.in);

  switch (readInt("Enter Number")) {
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

public static int readInt(String message) {
  int num = 0;
  try {
    System.out.print(message);
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Not a number!");
    num = readInt(message);
  }

  return num;
}

public static String randomName(){
  Random random = new Random();
  String[] names = { "Jay", "Hae", "Sindy", "Carmon", "Janeth", "Vernon", "Olin", "Inger", "Lindsey", "Michael", "Benton", "Marcy", "Caleb" };

  return names[random.nextInt(names.length)];
}

public static String randomAddress(){
  Random random = new Random();
  String[] names = { "Koebenhavn", "Odense", "Aarhus", "Herlev", "Taarnby", "Dragoer", "Roskilde" };

  return names[random.nextInt(names.length)];
}

public static int randomNumber(){
  Random random = new Random();
  return random.nextInt(89999999) + 10000000;
}

public static void generateGuests(int numberOfGuests, ArrayList<Guest> guests) throws Exception {
  for (int i = 0; i < numberOfGuests; i++) {
    guests.add(new Guest(updateGuestID(), randomName(), randomName(), randomAddress(), randomNumber()));
  }
}
}
