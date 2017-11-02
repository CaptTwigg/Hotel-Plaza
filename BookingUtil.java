import java.util.*;
import java.io.*;

public class BookingUtil {
public static void bookingMenu(ArrayList<Booking> bookings, ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("\n1: Create booking, 2: Extend stay, 3: Show bookings, 4: Change booking info, -1: Back to main menu");

    switch (intInput("Enter Menu Number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      createBooking(bookings, guests);
      break;
    case 2:
      showBookings(bookings);
      setEndDate(bookings);
      break;
    case 3:
      showBookings(bookings);
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}

public static void setEndDate(ArrayList<Booking> bookings){
  Scanner scanner = new Scanner(System.in);
  int index = intInput("Enter booking number: ") - 1;
  String date;
  do {
    System.out.print("Enter new end date. dd/mm/yyyy: ");
    date = scanner.next();
  } while (checkDateFormat(date));
  bookings.get(index).setEndDate(date);
}

public static void createBooking(ArrayList<Booking> booking, ArrayList<Guest> guests) throws Exception {
  Scanner scanner = new Scanner(System.in);
  GuestUtil.addGuest(guests);
  int getID = guests.get(guests.size() - 1).getGuestID();
  int addRoom = 12;
  String startDate;
  String endDate;
  do {
    System.out.print("Enter start date. dd/mm/yyyy: ");
    startDate = scanner.nextLine();
    System.out.print("Enter end date. dd/mm/yyyy: ");
    endDate = scanner.nextLine();
    if (checkDates(startDate, endDate)) System.out.println("Not valid date format");
  } while (checkDates(startDate, endDate));

  booking.add(new Booking(startDate, endDate, addRoom, getID));
}

public static boolean checkDates(String date1, String date2){
  int[] date1A = new int[3];
  int[] date2A = new int[3];
  String[] splitDate1 = date1.split("\\D+");
  String[] splitDate2 = date2.split("\\D+");

  for (int i = 0; i < 3; i++) {
    if (!isInteger(splitDate1[i])) return false;
    if (!isInteger(splitDate2[i])) return false;
    date1A[i] = Integer.parseInt(splitDate1[i]);
    date2A[i] = Integer.parseInt(splitDate2[i]);
  }
  return date1A[1] >= date2A[1] && date1A[2] >= date2A[2];
}
public static boolean checkDateFormat(String date){
  String[] splitDate = date.split("\\D+");

  for (int i = 0; i < 3; i++) {
    if (!isInteger(splitDate[i])) return false;
  }
  return true;
}

public static void showBookings(ArrayList<Booking> bookings){
  for (int i = 0; i < bookings.size(); i++) {
    System.out.println(i + 1 + " " + bookings.get(i).toString());
  }
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
