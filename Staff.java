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
  /**
	* Returns value of firstName
	* @return
	*/
	public String getFirstName() {
		return firstName;
	}

	/**
	* Sets new value of firstName
	* @param
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	* Returns value of lastName
	* @return
	*/
	public String getLastName() {
		return lastName;
	}

	/**
	* Sets new value of lastName
	* @param
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	* Returns value of titel
	* @return
	*/
	public String getTitel() {
		return titel;
	}

	/**
	* Sets new value of titel
	* @param
	*/
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	* Returns value of telephonenumber
	* @return
	*/
	public int getTelephonenumber() {
		return telephonenumber;
	}

	/**
	* Sets new value of telephonenumber
	* @param
	*/
	public void setTelephonenumber(int telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	/**
	* Returns value of salary
	* @return
	*/
	public int getSalary() {
		return salary;
	}

	/**
	* Sets new value of salary
	* @param
	*/
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	* Returns value of f
	* @return
	*/
	public Staf getF() {
		return f;
	}

	/**
	* Sets new value of f
	* @param
	*/
	public void setF(Staf f) {
		this.f = f;
	}

	/**
	* Returns value of staffFile
	* @return
	*/
	public void getStaffFile() {
		return staffFile;
	}

	/**
	* Sets new value of staffFile
	* @param
	*/
	public void setStaffFile(void staffFile) {
		this.staffFile = staffFile;
	}
}
