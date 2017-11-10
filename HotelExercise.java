import java.util.*;
import java.io.*;
import guest.*;
import room.*;
import staff.*;

public class HotelExercise {
public static void main(String[] args) throws Exception {
  ArrayList<Guest> guests = new ArrayList<>();
  ArrayList<Booking> bookings = new ArrayList<>();
  ArrayList<Staff> staffs = new ArrayList<>();
  ArrayList<Room> rooms = new ArrayList<>();

  String guestFile = "guest/guests.dat";
  String bookingFile = "booking.dat";
  String staffFile = "staff/staffs.dat";
  String roomFile = "room/rooms.dat";

  GuestUtil.loadGuestFile(guestFile, guests);
  BookingUtil.loadFile(bookingFile, bookings);
  StaffUtil.loadFile(staffFile, staffs);
  RoomUtil.loadFile(roomFile, rooms);

  interFace(guests, bookings, staffs, rooms);

  GuestUtil.saveGuestsToFile(guestFile, guests);
  BookingUtil.saveToFile(bookingFile, bookings);
  // StaffUtil.saveToFile(staffFile, staffs);
  RoomUtil.saveToFile(roomFile, rooms);

  // generateGuests(30, guests);
}

/*
   Interface related methods:
   interface
   guestMenu menu for all guest methods
   bookingMenu
   staffMenu
 */

public static void interFace(ArrayList<Guest> guests, ArrayList<Booking> bookings, ArrayList<Staff> staffs, ArrayList<Room> rooms) throws Exception {
  boolean again = true;
  do {
    System.out.println("\n1: Guest menu, 2: Booking menu, 3: Staff menu, 4: Room menu");
    switch (intInput("Enter Menu Number: ")) {
    case 404:
      again = false;
      break;
    case 1:
      GuestUtil.guestMenu(guests);
      break;
    case 2:
      BookingUtil.bookingMenu(bookings, guests, rooms);
      break;
    case 3:
      StaffUtil.staffMenu(staffs);
      break;
    case 4:
      RoomUtil.roomMenu(rooms);
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}




/*
   Helper methods:
   intInput loops input until number is given
 */

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
