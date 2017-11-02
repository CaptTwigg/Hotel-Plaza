public class Director extends Employee {
public Director(String name, String titel, int phoneNumber){
  super(name, titel, phoneNumber);
  this.salary += 350000;
  this.workingHours += 15;
}
}
