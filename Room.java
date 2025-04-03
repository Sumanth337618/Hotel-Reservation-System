// Room.java
// Class representing a hotel room with details such as room number, type, price, and availability status.
public class Room {
    
    // Room number identifier
    private int roomNumber;
    
    // Room type (e.g., Single, Double, Suite)
    private String roomType;
    
    // Price per night for the room
    private double pricePerNight;
    
    // Availability status of the room (true if available)
    private boolean isAvailable;
    
    // Default constructor
    public Room() {
    }
    
    // Parameterized constructor to initialize all fields
    public Room(int roomNumber, String roomType, double pricePerNight, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }
    
    // Getter for roomNumber
    public int getRoomNumber() {
        return roomNumber;
    }
    
    // Setter for roomNumber
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    // Getter for roomType
    public String getRoomType() {
        return roomType;
    }
    
    // Setter for roomType
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    // Getter for pricePerNight
    public double getPricePerNight() {
        return pricePerNight;
    }
    
    // Setter for pricePerNight
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    // Getter for isAvailable
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter for isAvailable
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    // Method to mark the room as booked (not available)
    public void bookRoom() {
        this.isAvailable = false;
    }
    
    // Method to free the room (set as available)
    public void freeRoom() {
        this.isAvailable = true;
    }
    
    // Override toString to provide room details as a string
    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType +
               ", pricePerNight=" + pricePerNight + ", isAvailable=" + isAvailable + "]";
    }
}
