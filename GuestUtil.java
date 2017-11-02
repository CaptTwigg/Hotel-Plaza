import java.util.*;
import java.io.*;

public class GuestUtil {
/*
   Guest related methods:
   guestMenu
   changeGuestInfo
   changeGuestInfoMenu
   showSearch - by String or int
   checkOutGuest
   searchGuest - by String or int
   searchGuestID
   addGuest
   updateGuestID
   saveGuestsToFile
   loadGuestFile
   showGuests
 */

public static void guestMenu(ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);

  boolean again = true;
  do {
    System.out.println("\n1: Add guest, 2: Checkout guest, 3: Change guest info, 4: Show guests, 5: Search guest, -1: Back to main menu");

    switch (intInput("Enter Menu Number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      GuestUtil.addGuest(guests);
      break;
    case 2:
      GuestUtil.checkOutGuest(intInput("Enter guest ID: "), guests);
      break;
    case 3:
      GuestUtil.changeGuestInfo(guests);
      break;
    case 4:
      GuestUtil.showGuests(guests);
      break;
    case 5:
      System.out.print("Enter guest keyword: ");
      String search = scanner.next();
      if (isInteger(search)) {
        int searchInt = Integer.parseInt(search);
        GuestUtil.showSearch(searchInt, guests);
      } else GuestUtil.showSearch(search, guests);
      break;
    default:
      System.out.println("Not valid");
    }
  } while (again);
}

public static void changeGuestInfo(ArrayList<Guest> guests){
  int ID;
  int guestIndex;
  do {
    ID = intInput("Enter guest ID: ");
    showSearch(ID, guests);
    guestIndex = searchGuestID(ID, guests);
  } while (guestIndex == -1);
  changeGuestInfoMenu(guestIndex, guests);
}

public static void changeGuestInfoMenu(int guestIndex, ArrayList<Guest> guests){
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("\n1: First name, 2: Last name, 3: Address, 4: Phone number, -1: Back to main menu");

    switch (intInput("Enter menu number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      System.out.print("Enter new first name: ");
      guests.get(guestIndex).setFirstName(scanner.next());
      break;
    case 2:
      System.out.print("Enter new last name: ");
      guests.get(guestIndex).setLastName(scanner.next());
      break;
    case 3:
      System.out.print("Enter new address: ");
      guests.get(guestIndex).setAddress(scanner.next());
      break;
    case 4:
      guests.get(guestIndex).setPhoneNumber(intInput("Enter new phone number: "));
      break;
    default:
      System.out.println("Now valid menu number");
    }
  } while (again);
}

public static void showSearch(String search, ArrayList<Guest> guests){
  ArrayList<Guest> holder = searchGuest(search, guests);
  showGuests(holder);
  if (holder.size() == 0) System.out.println("Guest not found");
}

public static void showSearch(int search, ArrayList<Guest> guests){
  ArrayList<Guest> holder = searchGuest(search, guests);
  showGuests(holder);
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
  int phoneNumber = intInput("Enter phone number: ");

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
  for (Guest guest : guests) System.out.println(guest.toString());
}

public static int intInput(String message) {
  int num = 0;
  try {
    System.out.print(message);
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Enter a number please");
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
}
