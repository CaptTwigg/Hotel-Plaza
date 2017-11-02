import java.util.*;
import java.io.*;

public class Staff {
private String firstName;
private String lastName;
private String titel;
private int telephonenumber;
private int salary;


public Staff(String firstName, String lastName, String titel, int telephonenumber, int salary){
  this.firstName = firstName;
  this.lastName = lastName;
  this.titel = titel;
  this.telephonenumber = telephonenumber;
  this.salary = salary;
}


public void staffFile(String file) throws Exception {
  FileWriter writer = new FileWriter(new File(file), true);
  String staff = String.format("firstName: %s : %s lastName: %s titel: %d int: %d salary");
  writer.write("\n");
  writer.flush();
  writer.close();
}

//array for stafflist or open the staffile.dat >> maybe both
// String [ ][ ] staffile =  [ 4 ] [ 5 ] ;

public void staffreader(String file) throws Exception {
  Scanner stafffile = new Scanner("staff.dat");
  try {
    FileReader staffreader = new FileReader(new File("staff.dat"));
    Scanner scan = new Scanner(staffreader);
    while (scan.hasNextLine()) {
      System.out.println(scan.nextLine());
    }
    scan.close();
  } catch (FileNotFoundException e) {
    System.out.println("Error Reading File");
    e.printStackTrace();
  }
}
}
