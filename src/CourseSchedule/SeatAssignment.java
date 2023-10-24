
package CourseSchedule;

import CourseCatalog.Course;


public class SeatAssignment {
    private float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    private Seat seat;
    private boolean like; //true means like and false means not like
    private CourseLoad courseload;

    public SeatAssignment(CourseLoad cl, Seat s, float g){
        this.seat = s;
        this.courseload = cl;
        
    }
     
    public boolean getLike(){
        return like;
    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public float getGrade(){
        return grade;
    }
    public void setGrade(float grade){
        this.grade = grade;
    }
    
    
    public void setLike(boolean like){
        this.like = like;
    }
   
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    public Seat getSeat(){
        return seat;
    }
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    public Course getAssociatedCourse(){
        return getCourseOffer().getSubjectCourse();
    }
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }
    
    public void printSeatInfo(){
        System.out.println(getAssociatedCourse().getCOurseNumber() + " " + getAssociatedCourse().getCourseName()+ " | " + getCreditHours() + " credits | " + "Grade: " + grade);
    }
    
}
