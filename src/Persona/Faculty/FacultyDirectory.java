package Persona.Faculty;

import Persona.*;
import Persona.Person.Faculty;
import Department.Department;
import CourseSchedule.CourseOffer;
import java.util.ArrayList;

public class FacultyDirectory {
    
    private Department department;
    private ArrayList<FacultyProfile> teacherlist;
    private ArrayList<FacultyAssignment> facultyAssignments; 

    public FacultyDirectory(Department d) {
        department = d;
        teacherlist = new ArrayList<>();
        facultyAssignments = new ArrayList<>();  
    }

    public FacultyDirectory() {
        teacherlist = new ArrayList<>();
        facultyAssignments = new ArrayList<>();  
    }

    public FacultyProfile newFacultyProfile(String id, String name) {
        FacultyProfile sp = new FacultyProfile(id, name);
        teacherlist.add(sp);
        return sp;
    }
    
    
    public FacultyAssignment assignFacultyToCourseOffer(FacultyProfile fp, CourseOffer co) {
        FacultyAssignment fa = new FacultyAssignment(fp, co);
        facultyAssignments.add(fa);
        return fa;
    }

    
    public FacultyProfile getTopProfessor(){
        double bestratingsofar = 0.0;
        FacultyProfile bestProfSofar = null;
        for(FacultyProfile fp: teacherlist)
           if(fp.getProfAverageOverallRating() > bestratingsofar){
               bestratingsofar = fp.getProfAverageOverallRating();
               bestProfSofar = fp;
           }
        return bestProfSofar;
    }

    
    public FacultyProfile findTeachingFaculty(String id) {
        for (FacultyProfile sp : teacherlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null;
    }

    
    public void printFacultyCourseSchedule(String facultyID) {
        System.out.println("Course Schedule for Faculty ID: " + facultyID);
        for(FacultyAssignment fa: facultyAssignments) {
            if(fa.getFacultyProfile().getPerson().getPersonId().equals(facultyID)) {
                System.out.println(fa.getCourseOffer().getCourse().getCourseName());
            }
        }
    }

    public FacultyProfile getFacultyByIndex(int i) {
        if(i >= 0 && i < teacherlist.size()) {
            return teacherlist.get(i);
        }
        return null; 
    }

    
}
