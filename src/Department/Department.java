
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;
import Persona.Person.Faculty;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.HashMap;


public class Department {

    private String name;
    private CourseCatalog coursecatalog;
    private PersonDirectory persondirectory;
    private StudentDirectory studentdirectory;
    private FacultyDirectory facultydirectory;
    private EmployerDirectory employerdirectory;
    private Degree degree;

    private HashMap<String, CourseSchedule> mastercoursecatalog; // very similar to ArrayList but with String used as indexes

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory();
        degree = new Degree("MSIS");
        
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }
    public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }
    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        if (mastercoursecatalog.containsKey(semester)) {
            throw new IllegalArgumentException("Course Schedule for this semester already exists.");
        }
        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;   
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);
        if (css == null) {
            throw new IllegalArgumentException("No Course Schedule found for this semester.");
        }
        
        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);
        if (sp == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        
        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        if (cs == null) {
            throw new IllegalArgumentException("No Course Schedule found for this semester.");
        }
        CourseOffer co = cs.getCourseOfferByNumber(cn);
        if (co == null) {
            throw new IllegalArgumentException("Course offer not found.");
        }
        co.getEmptySeat();

    }
    public void assignFacultyToCourse(String facultyId, String courseId, String semester) {
        FacultyProfile faculty = facultydirectory.findTeachingFaculty(facultyId);
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty not found.");
        }
        CourseSchedule cs = mastercoursecatalog.get(semester);
        if (cs == null) {
            throw new IllegalArgumentException("No Course Schedule found for this semester.");
        }
        CourseOffer co = cs.getCourseOfferByNumber(courseId);
        if (co == null) {
            throw new IllegalArgumentException("Course offer not found.");
        }
        co.assignFacultyToCourse(faculty);
    }
	public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;    
    }	
    public void printCourseScheduleForSemester(String semester) {
        CourseSchedule cs = mastercoursecatalog.get(semester);
        if (cs == null) {
            throw new IllegalArgumentException("No Course Schedule found for this semester.");
        }
        System.out.println("Course Schedule for " + semester + ":");
        for (CourseOffer co : cs.getAllCourseOffers()) {
            String courseInfo = co.getCourse().getCourseByNumber() + " " + co.getCourse().getCourseName();
            Faculty faculty = co.getFaculty();
            String facultyName = (faculty != null) ? faculty.getName() : "Not Assigned";
            int registeredStudents = co.getTotalSeats() - co.getemptySeatsCount();
            int emptySeats = co.getemptySeatsCount();
            System.out.println(courseInfo + " | Teacher: " + facultyName + " | Registered Students: " + registeredStudents + " | Empty Seats: " + emptySeats);
        }
    }
    
    public void printDepartmentName() {
        System.out.println("Department Name: " + name);
    }
    
        
        
    public void initializeFacultyAndCourses() {
        CourseSchedule csFall2023 = getCourseSchedule("Fall2023"); 
        for (int i = 1; i <= 5; i++) {
            String code = "info" + (5000 + i);
            Course course = coursecatalog.getCourseByNumber(code);
            CourseOffer courseOffer = csFall2023.newCourseOffer(code);
            facultydirectory.getFacultyByIndex(i);  
            courseOffer.generateSeats(25);
        }

    }
}
