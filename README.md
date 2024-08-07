# Airline-Reservation-System
This is a simple Airline Reservation System implemented in Java. The system allows users to perform various operations related to airline reservations, such as viewing available flights, searching flights by origin or destination, booking seats, canceling reservations, and displaying all reservations.

## Features

- Display available flights
- Search flights by origin
- Search flights by destination
- Book seats on a flight
- Cancel reservations
- Display all reservations

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Running the Application

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/AirlineReservationSystem.git
   ```
2. Navigate to the project directory:
   ```sh
   cd AirlineReservationSystem
   ```
3. Compile the Java files:
   ```sh
   javac AirlineReservationSystem.java Flight.java Passenger.java Reservation.java
   ```
4. Run the application:
   ```sh
   java AirlineReservationSystem
   ```

## Usage

Upon running the application, you will be presented with the following menu:

```
Welcome to Airline Reservation System
1. Display Available Flights
2. Search Flights by Origin
3. Search Flights by Destination
4. Book a Seat
5. Cancel Reservation
6. Display All Reservations
7. Exit
Enter your choice: 
```

### Options

1. **Display Available Flights**: Lists all available flights.
2. **Search Flights by Origin**: Prompts for an origin city and lists all flights from that city.
3. **Search Flights by Destination**: Prompts for a destination city and lists all flights to that city.
4. **Book a Seat**: Prompts for flight number, number of seats, and passenger names to book seats.
5. **Cancel Reservation**: Prompts for flight number and passenger name to cancel a reservation.
6. **Display All Reservations**: Lists all current reservations.
7. **Exit**: Exits the application.

## Classes

- `AirlineReservationSystem`: Main class that manages flights and reservations.
- `Flight`: Represents a flight with details such as flight number, origin, destination, and available seats.
- `Passenger`: Represents a passenger with a name.
- `Reservation`: Represents a reservation for a passenger on a flight.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This project was inspired by the need to create a basic airline reservation system for educational purposes.

## Contact

- For any questions or feedback, please contact yogita2003@gmail.com.

---

Happy flying! ✈️
