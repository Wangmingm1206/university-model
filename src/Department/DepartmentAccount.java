package Department;

import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;

public class DepartmentAccount {
    private Department department;

    public DepartmentAccount(Department d){
        department = d;
    }
        
    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule css = department.getCourseSchedule(semester);
        return css.calculateTotalRevenues();
    }

    public void printCourseScheduleForSemester(String semester) {
        CourseSchedule css = department.getCourseSchedule(semester);
        if(css == null) {
            System.out.println("No course schedule found for semester: " + semester);
            return;
        }

        System.out.println("Course Schedule for " + semester + ":");
        for(CourseOffer co : css.getAllCourseOffers()) {
            System.out.println("Course Name: " + co.getCourse().getCourseName());
            System.out.println("Faculty: " + co.getFaculty().getName());
            System.out.println("Registered Students: " + co.getNumberOfRegisteredStudents());
            System.out.println("Remaining Seats: " + co.getRemainingSeats());
            System.out.println("-------------------------------");
        }
    }
}

