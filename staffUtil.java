public class StaffUtil{

  public static void savestaff(String file, ArrayList<staff> staff) throws Exception {
  new PrintStream(new File(file));
  for (int i = 0; i < staff.size(); i++) {
  staff.get(i).saveFile(file);
    }
  }



public static ArrayList<Staff> readStaff(String file) throws Exception {
  Scanner scanner = new Scanner(file);
  ArrayList staffs= new ArrayList <Staff>();
  while (scanner.hasNextLine())
  {
    String s = scanner.nextLine();
    String[] components = s.split(" ");
    String firtname =0, String lastname=1. String titel=3, int phoneNumber,4
    int salary=5
    Staff staff = new Staff()
    staffs.add();
    lineScan.close();
  }
  scanner.close();


{

}
}
