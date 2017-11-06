import java.util.*;
import java.io.*;

public class RoomUtil {
/*
   Helper methods for room
   roomMenu
   createRoom
   updateID
   changeRoomInfo
   saveToFile
   loadFile
   showRooms
   searchID
 */

public static void roomMenu(ArrayList<Room> rooms) throws Exception {
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  do {
    System.out.println("\n1: Create room, 2: Change room info, 3: Show rooms, -1: Back to main menu");

    switch (intInput("Enter menu number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      createRoom(rooms);
      break;
    case 2:
      showRooms(rooms);
      changeRoomInfo(rooms);
      break;
    case 3:
      showRooms(rooms);
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}

public static void createRoom(ArrayList<Room> rooms) throws Exception {
  Scanner scanner = new Scanner(System.in);

  int numberOfBeds = intInput("Enter number of beds: ");
  System.out.print("Enter internet acces true/false: ");
  boolean internetAcces = scanner.nextBoolean();
  int price = intInput("Enter price: ");
  int floor = intInput("Enter floor number: ");

  rooms.add(new Room(updateID(rooms), numberOfBeds, internetAcces, price, floor)); // Creating new object of room with input variables
}

public static int updateID(ArrayList<Room> rooms) throws Exception {
  int ID;
  if (rooms.isEmpty()) ID = 0;
  else ID = rooms.get(rooms.size() - 1).getRoomID();
  ID++;
  return ID;
}

public static void changeRoomInfo(ArrayList<Room> rooms){
  Scanner scanner = new Scanner(System.in);
  boolean again = true;
  int ID;
  int roomID;
  do {
    roomID = intInput("Enter room ID: ");
    ID = searchID(roomID, rooms);
  } while (searchID(roomID, rooms) == -1);
  do {
    System.out.println("\nChoose what you want to change.");
    System.out.println("1: Number of beds, 2: internetAcces, 3: Price pr. night, 4: Floor, -1 Back to rooms menu");

    switch (intInput("Enter menu number: ")) {
    case -1:
      again = false;
      break;
    case 1:
      rooms.get(ID).setNumberOfBeds(intInput("Enter number of beds: "));
      break;
    case 2:
      System.out.print("Enter internet acces, true/false: ");
      boolean acces = scanner.nextBoolean();
      rooms.get(ID).setInternetAcces(acces);
      break;
    case 3:
      rooms.get(ID).setPrice(intInput("Enter new price: "));
      break;
    case 4:
      rooms.get(ID).setFloor(intInput("Enter new floor number: "));
      break;
    default:
      System.out.println("Not valid menu number");
    }
  } while (again);
}

public static void saveToFile(String file, ArrayList<Room> rooms) throws Exception {
  new PrintStream(new File(file));
  for (int i = 0; i < rooms.size(); i++) {
    rooms.get(i).saveToFile(file);
  }
}

public static void loadFile(String file, ArrayList<Room> rooms) throws Exception {
  Scanner scanner = new Scanner(new File(file));

  while (scanner.hasNextLine()) {
    String room = scanner.nextLine();
    Scanner lineScan = new Scanner(room);

    rooms.add(new Room(lineScan.nextInt(), lineScan.nextInt(), lineScan.nextBoolean(), lineScan.nextInt(), lineScan.nextInt()));
    lineScan.close();
  }
  scanner.close();
}

public static void showRooms(ArrayList<Room> rooms){
  for (Room room : rooms) System.out.println(room.toString());
}

public static int searchID(int ID, ArrayList<Room> rooms){
  for (int index = 0; index < rooms.size(); index++) {
    if (rooms.get(index).searchID(ID)) {
      return index;
    }
  }
  return -1;
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
