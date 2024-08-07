public class Seat {
    private int seatNumber;
    private boolean occupied;
    private Passenger passenger;

    public Seat(int seatNumber, boolean occupied) {
        this.seatNumber = seatNumber;
        this.occupied = occupied;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
