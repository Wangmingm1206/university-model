package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;

import CourseCatalog.Course;

public class Transcript {

    private StudentProfile student;
    private HashMap<String, CourseLoad> courseloadlist;
    private final String FALL_2023 = "Fall 2023";
    private UserAccount userAccount;

    CourseLoad currentcourseload;

    public Transcript(StudentProfile studentProfile) {
        this.student = studentProfile;
        this.userAccount = userAccount;
        this.courseloadlist = new HashMap<>();
    }

    public StudentProfile getStudentProfile() {
        return student;
    }

    public CourseLoad newCourseLoad(String semester) {
        if (!courseloadlist.containsKey(FALL_2023)) {
            currentcourseload = new CourseLoad(FALL_2023);
            courseloadlist.put(FALL_2023, currentcourseload);
        } else {
            currentcourseload = courseloadlist.get(FALL_2023);
        }
        return currentcourseload;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return courseloadlist.get(semester);
    }
    
    public CourseLoad getCurrentCourseLoad() {
        return currentcourseload;
    }

    public float getStudentTotalScore() {
        float sum = 0;
        for (CourseLoad cl : courseloadlist.values()) {
            sum += cl.getSemesterScore();
        }
        return sum;
    }

    public int getStudentSatifactionIndex() {
        ArrayList<SeatAssignment> courseregistrations = getCourseList();
        int sum = 0;
        for (SeatAssignment sa : courseregistrations) {
            if (sa.getLiked()) {
                sum += 1;
            }
        }
        return sum;
    }

    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList<SeatAssignment> temp2 = new ArrayList<>();
        for (CourseLoad cl : courseloadlist.values()) {
            temp2.addAll(cl.getSeatAssignments());
        }
        return temp2;
    }

    public void print() {
        System.out.println("------- Student transcript --------- ");
        for (CourseLoad eachCourseload : courseloadlist.values()) {
            eachCourseload.print();
        }
    }

}
