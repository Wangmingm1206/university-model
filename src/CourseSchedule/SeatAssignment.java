package CourseSchedule;

import CourseCatalog.Course;
import Persona.Person.Faculty;
import Persona.Person.Student;
import Persona.StudentProfile;
import java.util.Random;

public class SeatAssignment {
    private float grade; // Numeric representation (e.g., A=4.0, A-=3.7)
    private Seat seat;
    private boolean liked; // true means liked, false means not liked
    private Faculty faculty;
    private Student student;
    private StudentProfile studentProfile;
    private CourseLoad courseLoad;


    public SeatAssignment(CourseLoad cl, Seat s, StudentProfile studentProfile) { 
        this.courseLoad = cl;
        this.seat = s;
        this.studentProfile = studentProfile; 
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

    public void assignRandomGrade() {
        Random random = new Random();
        float randomGrade = 0.1f * random.nextInt(41); // This will generate a random float between 0.0 and 4.0
        setGrade(randomGrade);
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
    
    

    public void assignGrade(float grade) {
    if (grade < 0.0 || grade > 4.0) {  
        System.out.println("Invalid grade. Please assign a grade between 0.0 and 4.0.");
        return;
    }
    this.grade = grade;
}



    public CourseOffer getCourseOffer() {
        return seat.getCourseoffer();
    }

    public Course getAssociatedCourse() {
        return getCourseOffer().getSubjectCourse();
    }

    public float getCourseStudentScore() {
        return getCreditHours() * grade;
    }

    public void printSeatInfo() {
        System.out.println(getAssociatedCourse().getCourseByNumber() + " " + getAssociatedCourse().getCourseName() 
            + " | " + getCreditHours() + " credits | " 
            + "Grade: " + grade 
            + " | Faculty: " + faculty.getName()); // Assuming faculty has a getName() method
    }

	

    public boolean isSeatOccupied() {
        return seat.isOccupied();
    }
}
