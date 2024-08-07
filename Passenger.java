public class Passenger {
    private String name;
    private Seat seat; // Add a seat field to Passenger

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return name;
    }
}
