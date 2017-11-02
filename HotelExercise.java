import java.util.*;
import java.io.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Guest> guests = new ArrayList<>();
  ArrayList<Staff> staffs = new ArrayList<>();
  String guestFile = "guests.dat";
  Booking book = new Booking("20/02/2017", "10/02/2017", 22, 22);
  System.out.println(book.getNumberOfDays());
  System.out.println(book.getEndDate());
  book.setEndDate("25/2/2017");
  System.out.println(book.getEndDate());
  System.out.println(book.getNumberOfDays());

  GuestUtil.loadGuestFile(guestFile, guests);

  // generateGuests(30, guests);

  // saveGuestsToFile(guestFile, guests);
  while (true) interFace(guests);
}

/*
   Interface related methods:
   interface
   guestMenu menu for all guest methods
   staffMenu
 */

public static void interFace(ArrayList<Guest> guests) throws Exception {
  System.out.println("1: Guest menu, 2: Booking menu, 3: Staff menu, 4: Room menu");

  switch (intInput("Enter Menu Number: ")) {
  case 1:
    GuestUtil.guestMenu(guests);
    break;
  case 2:
    System.out.println("Comming soon");
    break;
  case 3:
  StaffUtil.staffMenu(//staffs< skiv her);
    System.out.println("Comming soon");
    break;
  case 4:
    System.out.println("");
    break;
  default:
    System.out.println("Not valid");
  }
}



public static void bookingMenu(){
  System.out.println("1: Create booking, 2: Extend stay");


  switch (intInput("Enter Menu Number: ")) {
  case 1:
    break;
  case 2:
    break;
  }
}

public static void CreateBooking(ArrayList<Booking> booking, ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);
  int getID;
  System.out.println("1: Add new guest, 2: Add existing guest");

  switch (intInput("Enter Menu Number: ")) {
  case 1:
    GuestUtil.addGuest(guests);
    getID = guests.get(guests.size() - 1).getGuestID();
    break;
  case 2:
    int guestIndex;
    do {
      guestIndex = GuestUtil.searchGuestID(intInput("Enter guest iD: "), guests);
    } while (guestIndex == -1);

    break;
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
    guests.add(new Guest(GuestUtil.updateGuestID(guests), randomName(), randomName(), randomAddress(), randomNumber()));
  }
}
}
