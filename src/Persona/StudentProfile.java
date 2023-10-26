
package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;


public class StudentProfile {

    private Person person;
    private Transcript transcript;
    private EmploymentHistroy employmenthistory;

    public StudentProfile(Person p) {
        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
        newCourseLoad("Fall2023");
    }
    public Person getPerson() {
        return this.person; // assuming you have a `person` field in StudentProfile class
    }
    


    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {
        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {
        return transcript.getCourseList();
    }

    public void printStudentNameAndID() {
        System.out.println("Student name, id: " + person.getName() + ", " + person.getPersonId());
    }

    public void printTranscript() {
        printStudentNameAndID();
        transcript.print();
    }

}
