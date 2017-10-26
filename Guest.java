import java.io.PrintStream;
import java.io.File;

public class Guest {
private int guestID;
private String firstName;
private String lastName;
private String address;
private int phoneNumber;

public Guest(int guestID, String firstName, String lastName, String address, int phoneNumber){
  this.guestID = guestID;
  this.firstName = firstName;
  this.lastName = lastName;
  this.address = address;
  this.phoneNumber = phoneNumber;
}

public void saveToFile(String file) throws Exception {
  PrintStream ps = new PrintStream(new File(file));
  String guest = String.format("%d %s %s %s %d", guestID, firstName, lastName, address, phoneNumber);
  ps.append(guest + "\n");
  ps.close();
}

public String toString(){
  return String.format("GuestID: %d firstName: %s lastName: %s address: %s phoneNumber: %d",
                       guestID, firstName, lastName, address, phoneNumber);
}
}
