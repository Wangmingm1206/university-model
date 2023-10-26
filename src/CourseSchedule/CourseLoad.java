package CourseSchedule;

import Persona.Person.Student;
import Persona.StudentProfile;
import java.util.ArrayList;

public class CourseLoad {
    
    String semester;
    ArrayList<SeatAssignment> seatlist;
    
    public CourseLoad(String semester) {
        this.semester = semester;
        seatlist = new ArrayList<>();
    }

    public SeatAssignment registerStudentForCourse(CourseOffer co, StudentProfile sp) {
        // Check if the course offer has empty seats
        if (co.getemptySeatsCount() > 0) {
            Seat seatToAssign = co.getEmptySeat();
            boolean isAssigned = co.newSeatAssignment(this, sp);
            if (isAssigned) {
                
                
                
                if (sp.getPerson() instanceof Student) {
                    Student student = (Student) sp.getPerson();
                    return sa;
                }
            }

        }
        return null;  // No seats available
    }

    public float getSemesterScore() {
        float sum = 0;
        for (SeatAssignment sa : seatlist) {
            sum = sum + sa.getCourseStudentScore();
        }
        return sum;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatlist;
    }

    public void print() {
        System.out.println("-- Registered courses in " + semester + " --");
        for (SeatAssignment sa : seatlist) {
            sa.printSeatInfo();
        }
    }
}
