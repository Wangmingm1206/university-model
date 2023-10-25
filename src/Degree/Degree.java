package Degree;

import CourseCatalog.Course;
import CourseSchedule.SeatAssignment;
import Persona.StudentProfile;
import java.util.ArrayList;

public class Degree {

    private String title;
    private ArrayList<Course> corelist;
    private ArrayList<Course> electives;

    public Degree(String name) {
        title = name;
        corelist = new ArrayList<>();
        electives = new ArrayList<>();
    }

    public void addCoreCourse(Course c) {
        corelist.add(c);
    }

    public void addElectiveCourse(Course c) {
        electives.add(c);
    }

    public boolean isStudentReadyToGraduate(StudentProfile sp) {
        ArrayList<SeatAssignment> sas = sp.getCourseList();

        return validateCoreClasses(sas) && validateElectiveClasses(sas);
    }

    public boolean validateCoreClasses(ArrayList<SeatAssignment> sas) {
        for (Course c : corelist) {
            if (!isCoreSatisfied(sas, c)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateElectiveClasses(ArrayList<SeatAssignment> sas) {
        for (SeatAssignment sa : sas) {
            if (isElectiveSatisfied(sa)) {
                return true; 
            }
        }
        return false; 
    }

    public boolean isCoreSatisfied(ArrayList<SeatAssignment> sas, Course c) {
        for (SeatAssignment sa : sas) {
            if (sa.getAssociatedCourse().equals(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isElectiveSatisfied(SeatAssignment sa) {
        for (Course c : electives) {
            if (sa.getAssociatedCourse().equals(c)) {
                return true;
            }
        }
        return false;
    }
}
