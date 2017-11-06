import java.util.*;
import java.io.*;

public class StaffUtil {
public static void staffMenu(ArrayList<Staff> staffs) throws Exception {
  boolean again = true;
  do {
    int input = HotelExercise.intInput("\n1: Show staffs, 2: add staff , 3: edit staff, 4: remowe staff, -1: Back to main menu");
    switch (input) {
    case -1:
      again = false;
      break;
    case 1:
      showarraylist(staffs);
      break;
    case 2:
      addstaff(staffs);
      break;
    case 3:
      //showarraylist
      break;
    case 4:
      System.out.println("comming very soon");
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}


public static void loadFile(String file, ArrayList<Staff> staffs) throws Exception {
  Scanner Filereader = new Scanner(new File(file));
  while (Filereader.hasNextLine()) {
    String staffreader = Filereader.nextLine();
    Scanner staffscan = new Scanner(staffreader);
    staffs.add(new Staff(staffscan.next(), staffscan.next(), staffscan.next(), staffscan.nextInt(), staffscan.nextInt()));
    staffscan.close();
  }
  Filereader.close();
}


public static void addstaff(ArrayList<Staff> staffs) throws Exception {
  Scanner staffscanner = new Scanner(System.in);

  System.out.print("Enter name: ");
  String firstName = staffscanner.nextLine();
  System.out.print("Enter last name: ");
  String lastName = staffscanner.nextLine();
  System.out.print("Enter titel: ");
  String titel = staffscanner.nextLine();
  System.out.println("enter phoneNumber");
  String phoneNumber = staffscanner.nextLine();
  int phoneNumbers = Integer.parseInt(phoneNumber);
  System.out.println("enter salary");
  String salaryString = staffscanner.nextLine();
  int salary = Integer.parseInt(salaryString);

  staffs.add(new Staff(firstName, lastName, titel, phoneNumbers, salary));
}

public static void showarraylist(ArrayList<Staff> staffs) throws Exception {
  for (int i = 0; i < staffs.size(); i++) {
    System.out.println(staffs.get(i).toString());
  }
}
}
