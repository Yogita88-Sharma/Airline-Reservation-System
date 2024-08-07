public class Reservation {
    private Flight flight;
    private Passenger passenger;

    public Reservation(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "flight=" + flight.getFlightNumber() +
                ", passenger=" + passenger.getName() +
                '}';
    }
}
