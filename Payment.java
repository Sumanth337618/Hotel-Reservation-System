// Payment.java
// Class representing a payment transaction with details such as payment ID, amount, date, and status.
import java.util.Date;

public class Payment {
    
    // Payment identifier
    private int paymentId;
    
    // Payment amount
    private double amount;
    
    // Date of the payment
    private Date paymentDate;
    
    // Payment status (e.g., "Pending", "Cleared")
    private String paymentStatus;
    
    // Default constructor
    public Payment() {
    }
    
    // Parameterized constructor to initialize all fields
    public Payment(int paymentId, double amount, Date paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }
    
    // Getter for paymentId
    public int getPaymentId() {
        return paymentId;
    }
    
    // Setter for paymentId
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    
    // Getter for amount
    public double getAmount() {
        return amount;
    }
    
    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    // Getter for paymentDate
    public Date getPaymentDate() {
        return paymentDate;
    }
    
    // Setter for paymentDate
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    // Getter for paymentStatus
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    // Setter for paymentStatus
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    // Method to mark the payment as cleared
    public void clearPayment() {
        this.paymentStatus = "Cleared";
    }
    
    // Override toString to provide payment details as a string
    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", amount=" + amount +
               ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + "]";
    }
}
