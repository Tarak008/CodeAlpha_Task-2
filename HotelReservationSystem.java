import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- Hotel Reservation System ----");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    hotel.showAvailableRooms(cat);
                }
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    hotel.bookRoom(name, cat);
                }
                case 3 -> {
                    System.out.print("Enter name to cancel booking: ");
                    String name = sc.nextLine();
                    hotel.cancelBooking(name);
                }
                case 4 -> hotel.viewBookings();
                case 0 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
