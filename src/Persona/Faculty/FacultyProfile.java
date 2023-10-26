
package Persona.Faculty;

import Persona.*;
import Persona.Person.Faculty;
import CourseSchedule.CourseOffer;
import java.util.ArrayList;


public class FacultyProfile {

    private Person person;
    private ArrayList <FacultyAssignment> facultyassignments; 
    
    public FacultyProfile(Person person) {

        this.person = person;
        this.facultyassignments = new ArrayList<>();
    }
    
    public FacultyProfile(String id,String name) {
        
        this.person = new Faculty(id, name);
        this.facultyassignments = new ArrayList<>();
    }

    public Faculty getPerson(){
        return (Faculty) person;
    }

    public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyassignments){
            
            sum = sum + fa.getRating();
            
        }
        if(facultyassignments.size() == 0) {
            return 0.0;
        }
        
        return sum/facultyassignments.size(); //this ensure we have double/double
        
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        co.assignFacultyToCourse(this);
        return fa;
    }
    
    public CourseOffer getCourseOffer(String courseid){
        for(FacultyAssignment fa : facultyassignments) {
            if(fa.getCourseOffer().getCourseByNumber().equals(courseid)) {
                return fa.getCourseOffer();
            }
        }
        return null; 
    }
    public ArrayList<FacultyAssignment> getCoursesTaughtThisSemester() {
        
        return facultyassignments;
    }


    public boolean isMatch(String id) {
        
        return person.getPersonId().equals(id);
    }

}
