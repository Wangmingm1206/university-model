package CourseSchedule;

import CourseCatalog.Course;
import Persona.Person.Faculty;

public class SeatAssignment {
    private float grade; // Numeric representation (e.g., A=4.0, A-=3.7)
    private Seat seat;
    private boolean liked; // true means liked, false means not liked
    private Faculty faculty;

    public SeatAssignment(CourseLoad cl, Seat s) {
        this.seat = s;
    }

    public void assignFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void assignSeatToStudent(CourseLoad cl) {
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return seat.getCourseCredits();
    }

    public Seat getSeat() {
        return seat;
    }

    public CourseOffer getCourseOffer() {
        return seat.getCourseOffer();
    }

    public Course getAssociatedCourse() {
        return getCourseOffer().getSubjectCourse();
    }

    public float getCourseStudentScore() {
        return getCreditHours() * grade;
    }

    public void printSeatInfo() {
        System.out.println(getAssociatedCourse().getCOurseNumber() + " " + getAssociatedCourse().getCourseName() 
            + " | " + getCreditHours() + " credits | " 
            + "Grade: " + grade 
            + " | Faculty: " + faculty.getName()); // Assuming faculty has a getName() method
    }

	public float GetCourseStudentScore() {
		return 0;
	}

    public boolean isSeatOccupied() {
        return false;
    }
}
