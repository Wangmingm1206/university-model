
package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;

import CourseCatalog.Course;


public class Transcript {

    private StudentProfile student;
    private HashMap<String, CourseLoad> courseloadlist;

    CourseLoad currentcourseload;

    public Transcript(StudentProfile userAccount) {
        student = userAccount;
        courseloadlist = new HashMap<String, CourseLoad>();
    }





    public Transcript(UserAccount userAccount) {
    }





    public StudentProfile getStudentProfile() {
        return student;
    }
    
    public static void assignGrade(Course course, String grade) {
        Transcript.assignGrade(course, grade);
    }
    

    public CourseLoad newCourseLoad(String semester) {

        currentcourseload = new CourseLoad(semester);
        courseloadlist.put(semester, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return courseloadlist.get(semester);

    }

    public float getStudentTotalScore() {

        float sum = 0;

        for (CourseLoad cl : courseloadlist.values()) {
            sum = sum + cl.getSemesterScore();

        }
        return sum;
    }
    //sat index means student rated their courses with likes;
    public int getStudentSatifactionIndex() {
        ArrayList<SeatAssignment> courseregistrations = getCourseList();
        int sum = 0;
        for (SeatAssignment sa : courseregistrations) {

            if (sa.getLiked()) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    //generate a list of all courses taken so far (seetassignments) 
    //from multiple semesters (course loads)
    //from seat assignments we will be able to access the course offers

    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList<SeatAssignment> temp2 = new ArrayList<>();

        for (CourseLoad cl : courseloadlist.values()) { //extract cl list as objects --ignore label
            temp2.addAll(cl.getSeatAssignments()); //merge one array list to another
        }

        return temp2;

    }

    public void print(){
        System.out.println("------- Student transcript --------- ");
        for (CourseLoad eachCourseload : courseloadlist.values()) {
            eachCourseload.print();
        }   
    }

}
