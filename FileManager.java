import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "bookings.txt";

    public static void saveBooking(Booking booking) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(booking.getCustomerName() + "," + booking.getRoomNumber() + "," + booking.getCategory() + ",Paid\n");
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    public static void loadBookings(List<Room> rooms, List<Booking> bookings) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int roomNumber = Integer.parseInt(parts[1]);
                    String category = parts[2];
                    String payment = parts[3];
                    bookings.add(new Booking(name, roomNumber, category, payment));
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNumber) {
                            room.setAvailable(false);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading bookings.");
        }
    }

    public static void saveAll(List<Booking> bookings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                bw.write(b.getCustomerName() + "," + b.getRoomNumber() + "," + b.getCategory() + "," + "Paid\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving all bookings.");
        }
    }
}
