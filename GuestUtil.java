import java.util.*;
import java.io.*;

public class GuestUtil {
String name;
ArrayList<Guest> guests;

public GuestUtil(ArrayList<Guest> array){
  this.guests = array;
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

public static void showGuests(ArrayList<Guest> guests){
  for (Guest i : guests) System.out.println(i.toString());
}
}
