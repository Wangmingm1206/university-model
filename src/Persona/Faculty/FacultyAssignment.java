/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.Faculty;

import CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    private double tracerating;
    private CourseOffer courseoffer;
    private FacultyProfile facultyprofile;

    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        this.courseoffer = co;
        this.facultyprofile = fp;
        this.tracerating = 0.0;
    }

    public double getRating(){
        
        return tracerating;
    }
    public void setProfRating(double r){
           
        tracerating = r;
       }
    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
        
    
    }
    public CourseOffer getCourseOffer() {
        return courseoffer;
    }
}
