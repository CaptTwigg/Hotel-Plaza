package staff;

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

public String getFirstName() {
  return firstName;
}

public void setFirstName(String firstName) {
  this.firstName = firstName;
}

public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

public String getTitel() {
  return titel;
}

public void setTitel(String titel) {
  this.titel = titel;
}

public int getTelephonenumber() {
  return telephonenumber;
}

public void setTelephonenumber(int telephonenumber) {
  this.telephonenumber = telephonenumber;
}

public int getSalary() {
  return salary;
}

public void setSalary(int salary) {
  this.salary = salary;
}


public String toString() {
  return "Staff [firstName=" + firstName + ", lastName=" + lastName + ", titel=" + titel + ", telephonenumber=" + telephonenumber + ", salary=" + salary;
}
}
