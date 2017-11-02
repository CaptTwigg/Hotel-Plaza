public class Test
{
  public static void main(String [] args)
  {
    try
    {
      ArrayList<Staff> staff = StaffUtil.readStaff("staff.dat");
      for (Staff s : staff )
      {
        System.out.println(s.getFirstName());

      }
    }
    catch(Exception e)
    {
      e.printStackTrace();ss
    }



  }
}
