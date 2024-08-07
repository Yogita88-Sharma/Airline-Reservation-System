import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Reservation> reservations;

    public AirlineReservationSystem() {
        this.flights = new ArrayList<>();
        this.reservations = new ArrayList<>();
        // Adding sample flights
        addFlight(new Flight("AA123", "Ahmedabad", "Delhi", 150));
        addFlight(new Flight("UA456", "Mumbai", "Banglore", 200));
        addFlight(new Flight("DL789", "Jaipur", "Raipur", 180));
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            flight.displayFlightDetails();
        }
        System.out.println(); // Empty line for clarity
    }

    public List<Flight> searchFlightsByOrigin(String origin) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Flight> searchFlightsByDestination(String destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    // public boolean bookSeat(String flightNumber, Passenger passenger) {
    //     for (Flight flight : flights) {
    //         if (flight.getFlightNumber().equals(flightNumber)) {
    //             if (flight.bookSeat(passenger)) {
    //                 Reservation reservation = new Reservation(flight, passenger);
    //                 reservations.add(reservation);
    //                 System.out.println("Booking successful for " + passenger.getName() + " on flight " + flightNumber);
    //                 System.out.println(); // Empty line for clarity
    //                 return true;
    //             } else {
    //                 System.out.println("Booking failed. No available seats on flight " + flightNumber);
    //                 System.out.println(); // Empty line for clarity
    //                 return false;
    //             }
    //         }
    //     }
    //     System.out.println("Flight " + flightNumber + " not found.");
    //     System.out.println(); // Empty line for clarity
    //     return false;
    // }

    public boolean bookSeats(String flightNumber, Passenger passenger, int numSeats) {
    for (Flight flight : flights) {
        if (flight.getFlightNumber().equals(flightNumber)) {
            int seatsBooked = 0;
            for (int i = 0; i < numSeats; i++) {
                if (flight.bookSeat(passenger)) {
                    seatsBooked++;
                } else {
                    // If any seat booking fails, print message and return false
                    System.out.println("Booking failed. No available seats for " + passenger.getName() + " on flight " + flightNumber);
                    System.out.println(); // Empty line for clarity
                    return false;
                }
            }
            
            // If all seats were booked successfully
            if (seatsBooked == numSeats) {
                Reservation reservation = new Reservation(flight, passenger);
                reservations.add(reservation);
                System.out.println("Booking successful for " + passenger.getName() + " for " + seatsBooked + " seat(s) on flight " + flightNumber);
                System.out.println(); // Empty line for clarity
                return true;
            }
        }
        }
        System.out.println("Flight " + flightNumber + " not found.");
        System.out.println(); // Empty line for clarity
        return false;
    }

    public boolean cancelReservation(String flightNumber, String passengerName) {
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) {
            Reservation reservation = iterator.next();
            if (reservation.getFlight().getFlightNumber().equals(flightNumber) &&
                    reservation.getPassenger().getName().equals(passengerName)) {
                iterator.remove();  // Use iterator to remove safely
                reservation.getFlight().cancelSeat(passengerName);
                System.out.println("Cancellation successful for " + passengerName + " on flight " + flightNumber);
                System.out.println(); // Empty line for clarity
                return true;
            }
        }
        System.out.println("Reservation not found.");
        System.out.println(); // Empty line for clarity
        return false;
    }

    public void displayReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
        System.out.println(); // Empty line for clarity
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 7) {
            System.out.println("Welcome to Airline Reservation System");
            System.out.println("1. Display Available Flights");
            System.out.println("2. Search Flights by Origin");
            System.out.println("3. Search Flights by Destination");
            System.out.println("4. Book a Seat");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Display All Reservations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        system.displayAvailableFlights();
                        break;
                    case 2:
                        System.out.print("Enter Origin City: ");
                        String origin = scanner.nextLine();
                        List<Flight> flightsByOrigin = system.searchFlightsByOrigin(origin);
                        if (flightsByOrigin.isEmpty()) {
                            System.out.println("No flights found from " + origin);
                        } else {
                            System.out.println("Flights from " + origin + ":");
                            for (Flight flight : flightsByOrigin) {
                                flight.displayFlightDetails();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter Destination City: ");
                        String destination = scanner.nextLine();
                        List<Flight> flightsByDestination = system.searchFlightsByDestination(destination);
                        if (flightsByDestination.isEmpty()) {
                            System.out.println("No flights found to " + destination);
                        } else {
                            System.out.println("Flights to " + destination + ":");
                            for (Flight flight : flightsByDestination) {
                                flight.displayFlightDetails();
                            }
                        }
                        break;
                    // case 4:
                    //     System.out.print("Enter Flight Number: ");
                    //     String flightNumber = scanner.nextLine();
                    //     System.out.print("Enter Passenger Name: ");
                    //     String passengerName = scanner.nextLine();
                    //     System.out.print("Enter Number of Seats to Book: ");
                    //     int numSeats = Integer.parseInt(scanner.nextLine());
                    //     Passenger passenger = new Passenger(passengerName);
                    //     system.bookSeats(flightNumber, passenger, numSeats);
                    //     break;

                    case 4:
                            System.out.print("Enter Flight Number: ");
                            String flightNumber = scanner.nextLine();
                            System.out.print("Enter Number of Seats to Book: ");
                            int numSeats = Integer.parseInt(scanner.nextLine());
                            
                            // Loop to collect passenger names
                            for (int i = 0; i < numSeats; i++) {
                                System.out.print("Enter Passenger Name for seat " + (i + 1) + ": ");
                                String passengerName = scanner.nextLine();
                                Passenger passenger = new Passenger(passengerName);
                                system.bookSeats(flightNumber, passenger, 1); // Book one seat at a time
                            }
                            break;

                    case 5:
                        System.out.print("Enter Flight Number: ");
                        String cancelFlightNumber = scanner.nextLine();
                        System.out.print("Enter Passenger Name: ");
                        String cancelPassengerName = scanner.nextLine();
                        system.cancelReservation(cancelFlightNumber, cancelPassengerName);
                        break;
                    case 6:
                        system.displayReservations();
                        break;
                    case 7:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 7.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            System.out.println(); // Empty line for clarity
        }

        scanner.close();
    }
}
