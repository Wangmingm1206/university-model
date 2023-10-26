package CourseSchedule;

import Persona.StudentProfile;
import Persona.Person.Student;

public class Seat {
    
    private Boolean occupied; 
    private int number;
    private SeatAssignment seatassignment; //links back to studentprofile
    private CourseOffer courseoffer;
    
    public Seat (CourseOffer co, int n){
        this.courseoffer = co;
        this.number = n;
        this.occupied = false;
    }
    
    public Boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }

    public void setSeatassignment(SeatAssignment seatassignment) {
        this.seatassignment = seatassignment;
    }

    public CourseOffer getCourseoffer() {
        return courseoffer;
    }

    public void setCourseoffer(CourseOffer courseoffer) {
        this.courseoffer = courseoffer;
    }

    public int getCourseCredits(){
        return courseoffer.getCreditHours();
    }

    public SeatAssignment newSeatAssignment(CourseLoad cl, StudentProfile student) {        
        seatassignment = new SeatAssignment(cl, this, student); //links seatassignment to seat
        occupied = true;   
        return seatassignment;
    }
    
    public void assignToStudent(StudentProfile student, CourseLoad cl) {
        newSeatAssignment(cl, student); // Use the method to make sure everything is properly linked and set
    }

    public void markAsOccupied() {
        occupied = true;
    }
}
