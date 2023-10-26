package CourseSchedule;

import CourseCatalog.Course;
import Persona.Person;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import Persona.Person.Faculty;
import Persona.StudentProfile;

import java.util.ArrayList;

public class CourseOffer {

    private Course course;
    private ArrayList<Seat> seatlist;
    private FacultyAssignment facultyassignment;
    private final int TotalSeats = 25;
    // private CourseOffer courseOffer;

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

    public String getCourseByNumber() {
        return course.getCourseByNumber();
    }

    public Course getCourse() {
        return course;
    }


    public void generateSeats(int num) {
        for (int i = 0; i < num; i++) {
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

    public int getemptySeatsCount() {
        return TotalSeats - registeredStudentsCount();
    }

    
    public int calculateTotalRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                sum = sum + course.getCoursePrice();
            }
        }
        return sum;
    }
    
    public Faculty getFaculty() {
        if (facultyassignment != null) {
            return (Faculty) facultyassignment.getFacultyProfile().getPerson();
        }
            return null; 
        }

    
    public Course getSubjectCourse(){
        return course;
    }
    
    public int getCreditHours(){
        return course.getCredits();
    }

    public double getCost() {
        return 0;
    }

    
    
    public void printFacultyAssigned() {
        Faculty faculty = this.getFaculty(); 
        if (faculty != null) {
            String name = faculty.getName();
            System.out.println("Faculty assigned for this course offer: " + name);
        } else {
            System.out.println("No faculty assigned for this course offer.");
    }
}


    public void assignFacultyToCourse(FacultyProfile facultyProfile) {
    }

    public int getTotalSeats() {
        return seatlist.size();
    }

    public int getRegisteredStudentsCount() {
        return registeredStudentsCount();
    }

    
    
    public boolean newSeatAssignment(CourseLoad cl, StudentProfile student) {
        Seat seat = getEmptySeat();
        if (seat != null) {
            seat.assignToStudent(student, cl);
            seat.markAsOccupied();
            return true; // successful assignment
        }
        return false; // no empty seats available
    }



    public void printCourseOffer() {
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Course Number: " + course.getCourseByNumber());
        
        if (facultyassignment != null) {
            System.out.println("Faculty: " + facultyassignment.getFacultyProfile().getPerson().getName());
        } else {
            System.out.println("Faculty: Not assigned");
        }
        
        System.out.println("Registered Students: " + registeredStudentsCount());
        System.out.println("Remaining Seats: " + getemptySeatsCount());
        System.out.println("----------------------------");
    }
    

    



}
