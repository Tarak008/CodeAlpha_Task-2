public class Booking {
    private String customerName;
    private int roomNumber;
    private String category;
    private String paymentStatus;

    public Booking(String customerName, int roomNumber, String category, String paymentStatus) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.category = category;
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerName() { return customerName; }
    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Booking for " + customerName + ": Room " + roomNumber + " (" + category + ") - Payment: " + paymentStatus;
    }
}
