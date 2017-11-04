import java.util.*;
import java.io.*;

public class BookingUtil {
/*
   Helper methods for booking:
   bookingMenu
   changeBookingInfoMenu
   loadFIle
   saveToFile
   extendStay
   createBooking
   chooseRoom
   checkDates
   checkDateFormat
   showBookings
 */

public static void bookingMenu(ArrayList<Booking> bookings, ArrayList<Guest> guests, ArrayList<Room> rooms) throws Exception {
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("\n1: Create booking, 2: Extend stay, 3: Show bookings, 4: Change booking info, -1: Back to main menu");

    switch (intInput("Enter Menu Number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      createBooking(bookings, guests, rooms);
      break;
    case 2:
      extendStay(bookings);
      break;
    case 3:
      showBookings(bookings);
      break;
    case 4:
      showBookings(bookings);
      changeBookingInfoMenu(intInput("Enter booking number: ") - 1, bookings, rooms);
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}

public static void changeBookingInfoMenu(int bookingIndex, ArrayList<Booking> bookings, ArrayList<Room> rooms){
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("\n1: Start date, 2: End date, 3: roomID, 4: guestID, -1: Back to booking meun");

    switch (intInput("Enter menu number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      System.out.print("Enter new start date: ");
      bookings.get(bookingIndex).setStartDate(scanner.next());
      break;
    case 2:
      System.out.print("Enter new end date: ");
      bookings.get(bookingIndex).setEndDate(scanner.next());
      break;
    case 3:
      bookings.get(bookingIndex).setRoomID(intInput("Enter new room ID: "));
      break;
    case 4:
      bookings.get(bookingIndex).setGuestID(intInput("Enter new guest ID: "));
      break;
    default:
      System.out.println("Now valid menu number");
    }
  } while (again);
}

public static void loadFile(String file, ArrayList<Booking> bookings) throws Exception {
  Scanner scanner = new Scanner(new File(file));

  while (scanner.hasNextLine()) {
    String booking = scanner.nextLine();
    Scanner lineScan = new Scanner(booking);

    bookings.add(new Booking(lineScan.next(), lineScan.next(), lineScan.nextInt(), lineScan.nextInt()));
    lineScan.close();
  }
  scanner.close();
}

public static void saveToFile(String file, ArrayList<Booking> bookings) throws Exception {
  new PrintStream(new File(file));
  for (int i = 0; i < bookings.size(); i++) {
    bookings.get(i).saveToFile(file);
  }
}

public static void extendStay(ArrayList<Booking> bookings){
  Scanner scanner = new Scanner(System.in);
  int index = intInput("Enter booking number: ");
  String date;

  do {
    System.out.print("Enter new end date. dd/mm/yyyy: ");
    date = scanner.nextLine();
  } while (checkDateFormat(date));
  bookings.get(index).setEndDate(date);
}

public static void createBooking(ArrayList<Booking> booking, ArrayList<Guest> guests, ArrayList<Room> rooms) throws Exception {
  Scanner scanner = new Scanner(System.in);
  GuestUtil.addGuest(guests);
  int guestID = guests.get(guests.size() - 1).getGuestID();
  int roomID = chooseRoom(rooms);
  String startDate;
  String endDate;

  do {
    System.out.print("Enter start date. dd/mm/yyyy: ");
    startDate = scanner.nextLine();
    System.out.print("Enter end date. dd/mm/yyyy: ");
    endDate = scanner.nextLine();
    if (checkDates(startDate, endDate)) System.out.println("Not valid date format3");
  } while (checkDates(startDate, endDate));

  booking.add(new Booking(startDate, endDate, roomID, guestID));
}

public static int chooseRoom(ArrayList<Room> rooms){
  RoomUtil.showRooms(rooms);
  return intInput("Enter room ID: ");
}

public static boolean checkDates(String date1, String date2){
  int[] date1A = new int[3];
  int[] date2A = new int[3];
  String[] splitDate1 = date1.split("\\D+");
  String[] splitDate2 = date2.split("\\D+");
  if (splitDate1.length != 3) return true;
  if (splitDate2.length != 3) return true;
  if (checkDateFormat(date1)) return true;
  if (checkDateFormat(date2)) return true;

  for (int i = 0; i < 3; i++) {
    if (!isInteger(splitDate1[i])) return false;
    if (!isInteger(splitDate2[i])) return false;
    date1A[i] = Integer.parseInt(splitDate1[i]);
    date2A[i] = Integer.parseInt(splitDate2[i]);
  }
  return date1A[1] >= date2A[1] && date1A[2] >= date2A[2];
}

public static boolean checkDateFormat(String date){
  if (date.split("\\s").length > 1) return true;
  String[] splitDate = date.split("\\D");
  if (splitDate.length != 3) return true;

  for (int i = 0; i < 3; i++) {
    if (!isInteger(splitDate[i])) return true;
  }
  return false;
}

public static void showBookings(ArrayList<Booking> bookings){
  for (int i = 0; i < bookings.size(); i++) {
    System.out.println(i + 1 + " " + bookings.get(i).toString());
  }
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
