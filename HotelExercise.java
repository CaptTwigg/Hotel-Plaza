import java.util.*;
import java.io.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Guest> guests = new ArrayList<>();
  loadGuestFile("guests.dat", guests);
  generateGuests(5, guests);
  // addGuest(guests);
  ArrayList<Guest> holder = searchGuest(25, guests);
  for (int i = 0; i < holder.size(); i++) {
    System.out.println(i + 1 + " " + holder.get(i).toString());
  }
  showGuests(guests);
  checkOutGuest(6, guests);
  System.out.println();
  showGuests(guests);
  // saveGuestsToFile("guests.dat", guests);
  // showGuests(guests);

  // interFace();
}

/*
   Guest related methods:
   searchGuest - by name or guestID
   addGuest
   updateGuestID
   saveGuestsToFile
   loadGuestFile
   showGuests
 */

public static void checkOutGuest(int guestID, ArrayList<Guest> guests){
  boolean removed = true;
  for (int i = 0; i < guests.size(); i++) {
    if (guests.get(i).searchGuestID(guestID)) {
      System.out.printf("Guest %s checked Out. \n", guests.get(i).getFirstName());
      guests.remove(i);
      removed = false;
    }
  }
  if (removed) System.out.println("Guest not found");
}

public static ArrayList<Guest> searchGuest(String name, ArrayList<Guest> guests){
  ArrayList<Guest> searchedArray = new ArrayList<>();
  for (int index = 0; index < guests.size(); index++) {
    if (guests.get(index).searchGuest(name)) {
      searchedArray.add(guests.get(index));
    }
  }
  return searchedArray;
}

public static ArrayList<Guest> searchGuest(int number, ArrayList<Guest> guests){
  ArrayList<Guest> searchedArray = new ArrayList<>();
  for (int index = 0; index < guests.size(); index++) {
    if (guests.get(index).searchGuest(number)) {
      searchedArray.add(guests.get(index));
    }
  }
  return searchedArray;
}

public static int searchGuestID(int guestID, ArrayList<Guest> guests){
  for (int index = 0; index < guests.size(); index++) {
    if (guests.get(index).searchGuest(guestID)) {
      return index;
    }
  }
  return -1;
}

public static void addGuest(ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter first name: ");
  String firstName = scanner.next();
  System.out.print("Enter last name: ");
  String lastName = scanner.next();
  System.out.print("Enter address: ");
  String address = scanner.next();
  int phoneNumber = readInt("Enter phone number");

  guests.add(new Guest(updateGuestID(guests), firstName, lastName, address, phoneNumber));
}

public static int updateGuestID(ArrayList<Guest> guests) throws Exception {
  int guestID = guests.get(guests.size() - 1).getGuestID();
  guestID++;
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
  for (Guest i : guests) System.out.println(i.toString());
}

/*
   Interface related methods:
   interface
   staffOption
 */

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

// Checks if user input is a number
public static int readInt(String message) {
  int num = 0;
  try {
    System.out.print(message);
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Enter number, please");
    num = readInt(message);
  }

  return num;
}

/*
   Random guest generator methods:
   randomName
   randomAddress
   randomNumber
   generateGuests
 */

public static String randomName(){
  Random random = new Random();
  String[] names = { "Jay", "Hae", "Sindy", "Carmon", "Janeth", "Vernon", "Olin", "Inger", "Lindsey", "Michael", "Benton", "Marcy", "Caleb", "Olsen", "Cay", "Kenneth" };

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
    guests.add(new Guest(updateGuestID(guests), randomName(), randomName(), randomAddress(), randomNumber()));
  }
}
}
