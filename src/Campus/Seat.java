package Campus;

public class Seat {

    private int seatNumber;           // A unique identifier for each seat
    private boolean isOccupied;       // To check if a seat is occupied or not
    private String occupiedByStudent; // The ID or name of the student occupying the seat, if any

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;  // By default, a seat is not occupied
        this.occupiedByStudent = ""; // No student assigned by default
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupySeat(String studentId) {
        this.isOccupied = true;
        this.occupiedByStudent = studentId;
    }

    public void vacateSeat() {
        this.isOccupied = false;
        this.occupiedByStudent = "";
    }

    public String getOccupiedByStudent() {
        return occupiedByStudent;
    }

    public void print() {
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Occupied: " + isOccupied);
        if(isOccupied) {
            System.out.println("Occupied by Student: " + occupiedByStudent);
        }
    }
}
