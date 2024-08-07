import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private List<Seat> seats;

    public Flight(String flightNumber, String origin, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.seats = new ArrayList<>();
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 1; i <= capacity; i++) {
            seats.add(new Seat(i, false)); // Assume all seats start as unoccupied
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return (int) seats.stream().filter(seat -> !seat.isOccupied()).count();
    }

    public boolean bookSeat(Passenger passenger) {
        for (Seat seat : seats) {
            if (!seat.isOccupied()) {
                seat.setOccupied(true);
                seat.setPassenger(passenger); // Assign seat to passenger
                return true;
            }
        }
        return false; // No available seats
    }

    public void cancelSeat(String passengerName) {
        for (Seat seat : seats) {
            if (seat.isOccupied() && seat.getPassenger().getName().equals(passengerName)) {
                seat.setOccupied(false);
                seat.setPassenger(null); // Clear passenger assigned to the seat
                return;
            }
        }
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Available Seats: " + getAvailableSeats() + " / " + capacity); // Include available seats
        // System.out.println("Seat Map:");
        // for (Seat seat : seats) {
        //     System.out.println("Seat " + seat.getSeatNumber() + ": " + (seat.isOccupied() ? "Occupied" : "Available"));
        // }
        System.out.println("----------------------------------------");
    }
}
