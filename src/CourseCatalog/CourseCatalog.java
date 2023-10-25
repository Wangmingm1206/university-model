package CourseCatalog;
import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
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
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }

    public void printCourseCatalog(){
        System.out.println("Course Catalog");
        for(Course c: courselist){
            System.out.println(courselist.indexOf(c) + 1 + ". " + c.getCOurseNumber() + " - " + c.getCourseName());
        }
    }

}