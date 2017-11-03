import java.util.*;

public class RoomUtil {
public static void roomMenu(ArrayList<Room> rooms){
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("1: Create room, 2: Change room info, -1 Back to main menu");

    switch (intInput("Enter menu number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      break;
    case 2:
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}

public static void createRoom(ArrayList<Room> rooms){
  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter first name: ");
  int numberOfBeds = scanner.nextInt();
  System.out.print("Enter last name: ");
  boolean internetAcces = scanner.nextBoolean();
  System.out.print("Enter price: ");
  int price = scanner.nextInt();
  int floor = intInput("Enter phone number: ");

  rooms.add(new Room(1, numberOfBeds, internetAcces, price, floor));
}

public static int intInput(String message) {
  int num = 0;
  try {
    System.out.print(message);
    num = (new Scanner(System.in)).nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Enter a number please");
    num = intInput(message);
  }

  return num;
}
}
