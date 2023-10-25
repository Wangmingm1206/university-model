/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import java.util.ArrayList;

import CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    private String semester;
    private ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public float getSemesterScore(){ //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }
    public ArrayList<SeatAssignment> getSeatAssignments(){
        return seatassignments;
        }
    public int getEmptySeatsCount() {
        int count = 0;
        for (SeatAssignment sa : seatassignments) {
            if (!sa.isSeatOccupied()) {
                count++;
                }
            }
            return count;
        } 
    public void print(){
        System.out.println("Semester: "+semester);
        for (SeatAssignment eachRegistredSeat: seatassignments){
            System.out.print(seatassignments.indexOf(eachRegistredSeat)+1 + ". ");
            eachRegistredSeat.printSeatInfo();
        }
    }
    public void addCourse(Course course) {
    }

}
