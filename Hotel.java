import java.util.*;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Sample Rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        FileManager.loadBookings(rooms, bookings);
    }

    public void showAvailableRooms(String category) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                System.out.println(room);
            }
        }
    }

    public void bookRoom(String name, String category) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                room.setAvailable(false);
                Booking booking = new Booking(name, room.getRoomNumber(), category, "Paid");
                bookings.add(booking);
                FileManager.saveBooking(booking);
                System.out.println("Room " + room.getRoomNumber() + " booked successfully for " + name);
                return;
            }
        }
        System.out.println("No available rooms in " + category + " category.");
    }

    public void cancelBooking(String name) {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getCustomerName().equalsIgnoreCase(name)) {
                for (Room room : rooms) {
                    if (room.getRoomNumber() == b.getRoomNumber()) {
                        room.setAvailable(true);
                        break;
                    }
                }
                it.remove();
                FileManager.saveAll(bookings);
                System.out.println("Booking cancelled for " + name);
                return;
            }
        }
        System.out.println("No booking found under the name " + name);
    }

    public void viewBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
