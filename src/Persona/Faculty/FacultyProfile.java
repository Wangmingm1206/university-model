
package Persona.Faculty;

import Persona.*;
import CourseSchedule.CourseOffer;
import java.util.ArrayList;


public class FacultyProfile {

    private Person person;
    private ArrayList <FacultyAssignment> facultyassignments; 
    
    public FacultyProfile(Person string) {

        person = string;
        facultyassignments = new ArrayList<>();
    }
    
    public FacultyProfile(String name) {
    }

    public Person getPerson(){
        return person;
    }

    public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyassignments){
            
            sum = sum + fa.getRating();
            
        }
        //divide by the total number of faculty assignments
        
        return sum/(facultyassignments.size()*1.0); //this ensure we have double/double
        
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        
        return fa;
    }
    
    public FacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }
    public ArrayList<FacultyAssignment> getCoursesTaughtThisSemester() {
        
        return facultyassignments;
    }


    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

}
