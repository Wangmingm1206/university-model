package Persona.Faculty;

import Persona.*;
import Persona.Person.Faculty;
import Department.Department;
import CourseSchedule.CourseOffer;
import java.util.ArrayList;

public class FacultyDirectory {
    
    private Department department;
    private ArrayList<FacultyProfile> teacherlist;
    private ArrayList<FacultyAssignment> facultyAssignments; // List to store faculty assignments

    public FacultyDirectory(Department d) {
        department = d;
        teacherlist = new ArrayList<>();
        facultyAssignments = new ArrayList<>();  // Initialize faculty assignments list
    }

    public FacultyDirectory() {
        teacherlist = new ArrayList<>();
        facultyAssignments = new ArrayList<>();  // Initialize faculty assignments list
    }

    public FacultyProfile newFacultyProfile(String string) {
        FacultyProfile sp = new FacultyProfile(string);
        teacherlist.add(sp);
        return sp;
    }
    
    // Assign a faculty to a course offer
    public FacultyAssignment assignFacultyToCourseOffer(FacultyProfile fp, CourseOffer co) {
        FacultyAssignment fa = new FacultyAssignment(fp, co);
        facultyAssignments.add(fa);
        return fa;
    }

    // Find the top professor based on ratings
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

    // Find a faculty by ID
    public FacultyProfile findTeachingFaculty(String id) {
        for (FacultyProfile sp : teacherlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null;
    }

    // Print the course schedule for faculty
    public void printFacultyCourseSchedule(String facultyID) {
        System.out.println("Course Schedule for Faculty ID: " + facultyID);
        for(FacultyAssignment fa: facultyAssignments) {
            if(fa.getFacultyProfile().getPerson().getPersonId().equals(facultyID)) {
                System.out.println(fa.getCourseOffer().getCourse().getCourseName());
            }
        }
    }

    public Faculty findFaculty(String facultyId) {
        return null;
    }



    public Faculty getFacultyByIndex(int i) {
        return null;
    }

    // Additional methods can be added as per further requirements
}
