// Reservation.java
// Class representing a reservation with details including reservation ID, associated room, customer identifier,
// reservation dates, and status.
import java.util.Date;

public class Reservation {
    
    // Reservation identifier
    private int reservationId;
    
    // Room associated with the reservation
    private Room room;
    
    // Customer identifier (could be a customer ID or name)
    private String customerId;
    
    // Date when the reservation was made
    private Date reservationDate;
    
    // Check-in date for the reservation
    private Date checkInDate;
    
    // Check-out date for the reservation
    private Date checkOutDate;
    
    // Status of the reservation (e.g., "Active", "Cancelled", "Confirmed")
    private String status;
    
    // Default constructor
    public Reservation() {
    }
    
    // Parameterized constructor to initialize all fields
    public Reservation(int reservationId, Room room, String customerId, Date reservationDate,
                       Date checkInDate, Date checkOutDate, String status) {
        this.reservationId = reservationId;
        this.room = room;
        this.customerId = customerId;
        this.reservationDate = reservationDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
    
    // Getter for reservationId
    public int getReservationId() {
        return reservationId;
    }
    
    // Setter for reservationId
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    
    // Getter for room
    public Room getRoom() {
        return room;
    }
    
    // Setter for room
    public void setRoom(Room room) {
        this.room = room;
    }
    
    // Getter for customerId
    public String getCustomerId() {
        return customerId;
    }
    
    // Setter for customerId
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    // Getter for reservationDate
    public Date getReservationDate() {
        return reservationDate;
    }
    
    // Setter for reservationDate
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    
    // Getter for checkInDate
    public Date getCheckInDate() {
        return checkInDate;
    }
    
    // Setter for checkInDate
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    // Getter for checkOutDate
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    
    // Setter for checkOutDate
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    // Getter for status
    public String getStatus() {
        return status;
    }
    
    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }
    
    // Method to cancel the reservation
    public void cancelReservation() {
        this.status = "Cancelled";
        // Optionally free the room when the reservation is cancelled
        if (room != null) {
            room.freeRoom();
        }
    }
    
    // Method to confirm the reservation and mark the room as booked
    public void confirmReservation() {
        this.status = "Confirmed";
        if (room != null) {
            room.bookRoom();
        }
    }
    
    // Override toString to provide reservation details as a string
    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", room=" + room +
               ", customerId=" + customerId + ", reservationDate=" + reservationDate +
               ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate +
               ", status=" + status + "]";
    }
}
