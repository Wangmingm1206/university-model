
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import Persona.Person.Faculty;


import java.util.ArrayList;


public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        this.semester = s;
        this.coursecatalog = cc;
        schedule = new ArrayList<CourseOffer>();

    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) {
            System.out.println("Course not found in the catalog");
            return null;
        }
        CourseOffer co = new CourseOffer(c);
        // Faculty faculty;
        // co.assignFaulty(faculty);
        co.generateSeats(25);

        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseByNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }
 
    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : getAllCourseOffers() ) {

            sum = sum + co.calculateTotalRevenues();

        }
        return sum;
    }
    
    

    public ArrayList<CourseOffer> getAllCourseOffers() {
        return schedule;
    }


    



    public void printCourseSchedule() {
        
        System.out.println("Course Schedule for " + this.semester);
        
        System.out.println("------------------------------------");

        
        for (CourseOffer co : schedule) {
            System.out.println("Course: " + co.getCourse().getCourseName());

            System.out.println("Course Number: " + co.getCourseByNumber());
            if (co.getFaculty() != null) {
                System.out.println("Faculty: " + co.getFaculty().getName());
            } else {
                System.out.println("Faculty: Not assigned");
            }
            
            System.out.println("Registered Students: " + co.getRegisteredStudentsCount()); // You'll need to implement this
            System.out.println("Remaining Seats: " + co.getemptySeatsCount()); // You'll need to implement this
            System.out.println("----------------------------");
        }
    }
    
    
        
        
}

    
    

    

