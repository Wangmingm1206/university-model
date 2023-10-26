package CourseCatalog;
import Department.Department;
import Persona.Person.Faculty;

import java.util.ArrayList;


public class CourseCatalog {
    private Department department;
    private String lastupdated;
    private ArrayList<Course> courselist;
    
    

    public CourseCatalog(Department d){
        courselist = new ArrayList<Course>();
        department = d;
        
    }
    

    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        if (getCourseByNumber(n) != null) {
            System.out.println("Course with number " + n + " already exists in the catalog.");
            return null;
        }
        
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCourseByNumber().equals(n)) return c;
        }
        return null;
    }
    
    

    public void printCourseCatalog(){
        System.out.println("Course Catalog");
        for(Course c: courselist){

            System.out.println(courselist.indexOf(c) + 1 + ". " + c.getCourseByNumber() + " - " + c.getCourseName());
        }
    }

   

}