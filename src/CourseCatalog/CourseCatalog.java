package CourseCatalog;
import Department.Department;
import java.util.ArrayList;


public class CourseCatalog {
    private Department department;
    private String lastupdated;
    private ArrayList<Course> courselist;
    
    

    public CourseCatalog(Department d){
        courselist = new ArrayList<Course>();
        department = d;
        initializeCourses();
    }
    private void initializeCourses() {
        newCourse("info5001", "Application Design & Modeling", 4);
        newCourse("info5100", "Application Engineering Development", 4);
        newCourse("info5200", "Data Science Fundamentals", 4);
        newCourse("info5300", "Cloud Computing", 4);
        newCourse("info5400", "Advanced DB Management", 4);
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

    public Object getFacultyDirectory() {
        return null;
    }

}