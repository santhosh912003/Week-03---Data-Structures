import java.util.*;

public class Movie_Ticket_Details {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Avatar", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Inception", "A2", "10:00 AM");
        system.displayTickets();
        system.searchTicket("Inception");
        system.removeTicket(2);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) return;
        if (head == tail && head.ticketId == ticketId) {
            head = tail = null;
            return;
        }

        Ticket prev = tail;
        Ticket current = head;
        while (current.ticketId != ticketId) {
            prev = current;
            current = current.next;
            if (current == head) return;
        }

        if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = current.next;
        }
    }

    public void displayTickets() {
        if (head == null) return;
        Ticket current = head;
        do {
            System.out.println("ID: " + current.ticketId + ", Name: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String query) {
        if (head == null) return;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found -> ID: " + current.ticketId + ", Name: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            }
            current = current.next;
        } while (current != head);
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}


