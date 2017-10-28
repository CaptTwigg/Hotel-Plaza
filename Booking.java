public class Booking {
private int roomID;
private int date;
private int endDate;




public Booking(int roomID, int date, int endDate) {
  this.roomID = roomID;
  this.date = date;
  this.endDate = endDate;
}

public int getRoomID(){
  return roomID;
}

public void setRoomID(int roomID) {
  this.roomID = roomID;
}

public int getDate() {
  return date;
}

public void setDate(int date) {
  this.date = date;
}

public int getEndDate() {
  return endDate;
}

public void setEndDate(int endDate) {
  this.endDate = endDate;
}

public String toString() {
  return "Booking [roomID=" + roomID + ", date=" + date + ", endDate=" + endDate + "]";
}
}
