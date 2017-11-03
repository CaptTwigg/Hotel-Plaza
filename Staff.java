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
}
