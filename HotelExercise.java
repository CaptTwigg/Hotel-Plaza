import java.util.*;
import java.io.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Guest> guests = new ArrayList<>();
  loadGuestFile("guests.dat", guests);
  // generateGuests(5, guests);
  // addGuest(guests);

  // showGuests(guests);
  // checkOutGuest(6, guests);
  // System.out.println();
  // showGuests(guests);
  // saveGuestsToFile("guests.dat", guests);
  // showGuests(guests);
  while (true) interFace(guests);
}

/*
   Guest related methods:
   checkOutGuest
   searchGuest - by String or int
   searchGuestID
   addGuest
   updateGuestID
   saveGuestsToFile
   loadGuestFile
   showGuests
 */

public static void showSearch(String search, ArrayList<Guest> guests){
  ArrayList<Guest> holder = searchGuest(search, guests);
  for (int i = 0; i < holder.size(); i++) {
    System.out.println(i + 1 + ": " + holder.get(i).toString());
  }
  if (holder.size() == 0) System.out.println("Guest not found");
}

public static void showSearch(int search, ArrayList<Guest> guests){
  ArrayList<Guest> holder = searchGuest(search, guests);
  for (int i = 0; i < holder.size(); i++) {
    System.out.println(i + 1 + ": " + holder.get(i).toString());
  }
  if (holder.size() == 0) System.out.println("Guest not found");
}

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
  int phoneNumber = intInput("Enter phone number");

  guests.add(new Guest(updateGuestID(guests), firstName, lastName, address, phoneNumber));
}

public static int updateGuestID(ArrayList<Guest> guests) throws Exception {
  int guestID = guests.get(guests.size() - 1).getGuestID();
  guestID++;
  return guestID;
}

public static void saveGuestsToFile(String file, ArrayList<Guest> guests) throws Exception {
  new PrintStream(new File(file));
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

public static void interFace(ArrayList<Guest> guests) throws Exception {
  System.out.println("1: Guest menu, 2: Booking menu, 3: Staff menu, 4: Room menu");

  switch (intInput("Enter Menu Number: ")) {
  case 1:
    guestMenu(guests);
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

public static void guestMenu(ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);
  System.out.println("1: Add guest, 2: Checkout guest, 3: Change guest info, 4: Show guests, 5: Search guest");

  switch (intInput("Enter Menu Number: ")) {
  case 1:
    addGuest(guests);
    break;
  case 2:
    checkOutGuest(intInput("Enter guest ID: "), guests);
    break;
  case 3:
    System.out.println("Comming soon");
    break;
  case 4:
    showGuests(guests);
    break;
  case 5:
    System.out.print("Enter guest keyword: ");
    String search = scanner.next();
    if (isInteger(search)) {
      int searchInt = Integer.parseInt(search);
      showSearch(searchInt, guests);
    }else showSearch(search, guests);
    break;
  default:
    System.out.println("Not valid");
  }
}


public static void staffMenu(){
  Scanner scanner = new Scanner(System.in);
  System.out.println("");
  scanner.close();
}

/*
   Helper methods:
   intInput loops input until number is given
   isInteger checks if String is a int and return true/false
 */
public static int intInput(String message) {
  int num = 0;
  try {
    System.out.print(message);
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Enter number, please");
    num = intInput(message);
  }

  return num;
}

public static boolean isInteger(String s) {
  try{
    Integer.parseInt(s);
    return true;
  }
  catch (NumberFormatException ex) {
    return false;
  }
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
