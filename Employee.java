public class Employee {
protected String name;
protected String titel;
protected int phoneNumber;
protected int salary = 250000;
protected int vacation = 5;
protected int workingHours = 37;


public Employee(String name, String titel, int phoneNumber) {
  this.name = name;
  this.titel = titel;
  this.phoneNumber = phoneNumber;
  // this.salary = salary;
  // this.vacation = vacation;
  // this.workingHours = workingHours;
}

public int getVacation(){
  return vacation;
}
public int getSalary(){
  return salary;
}
public int getWorkingHours(){
  return workingHours;
}


@Override
public String toString() {
  return "Employee [name=" + name + ", titel=" + titel + ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", vacation=" + vacation + ", workingHours=" + workingHours + "]";
}
}
