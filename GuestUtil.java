import java.util.*;
import java.io.*;

public class GuestUtil {
// ArrayList<Guest> guests;

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
  int guestID;
  if (guests.isEmpty()) guestID = 0;
  else guestID = guests.get(guests.size() - 1).getGuestID(); ;
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
}
