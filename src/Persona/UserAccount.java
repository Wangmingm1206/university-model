
package Persona;

import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import WorkAreas.Workarea;


public class UserAccount {
    private Person person;
    private Workarea landingworkarea;
    private Transcript transcript;
    
    public UserAccount(Person p){
        person = p;
        transcript = new Transcript(this);
    }

    public void registerCourse(Course course) {
        CourseLoad courseLoad = transcript.newCourseLoad("Fall 2023"); // Assuming 'newCourseLoad' creates a new course load if not present.
        courseLoad.addCourse(course);
    
    
    }

    public Person getPerson() {
        return null;
    }
    
}