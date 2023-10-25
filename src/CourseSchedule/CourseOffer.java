package CourseSchedule;

import CourseCatalog.Course;
import Persona.Person;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import Persona.Person.Faculty;

import java.util.ArrayList;

public class CourseOffer {

    private Course course;
    private ArrayList<Seat> seatlist;
    private FacultyAssignment facultyassignment;
    private CourseOffer courseOffer;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<Seat>();
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {
        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public Course getCourse() {
        return course;
    }


    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public int registeredStudentsCount() {
        int count = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public int emptySeatsCount() {
        return seatlist.size() - registeredStudentsCount();
    }

    
    // public int getTotalCourseRevenues() {
        // int sum = 0;
        // for (Seat s : seatlist) {
            // if (s.isOccupied()) {
                // sum = sum + course.getCoursePrice();
            // }
        // }
        // return sum;
    // }
    
    public Course getSubjectCourse(){
        return course;
    }
    
    public int getCreditHours(){
        return course.getCredits();
    }

    public double getCost() {
        return 0;
    }

    public void assignFaulty(Faculty faculty) {
    }

    public void createSeats(int i) {
    }

    public Person getFaculty() {
        return null;
    }

    public String getRegisteredStudentsCount() {
        return null;
    }

    public String getEmptySeatsCount() {
        return null;
    }

    public void setFaculty(Faculty faculty) {
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        return null;
    }

    public String getNumberOfRegisteredStudents() {
        return null;
    }

    public String getRemainingSeats() {
        return null;
    }

    public int getTotalCourseRevenues() {
        return 0;
    }
    Person faculty = courseOffer.getFaculty();{
    if (faculty != null) {
    String name = faculty.getName();
    System.out.println("Faculty assigned for this course offer: " + name);
    } else {
        System.out.println("No faculty assigned for this course offer.");
    }
}


