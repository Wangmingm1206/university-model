package Persona;

import java.util.ArrayList;

import CourseSchedule.CourseOffer;
import Persona.Person.Student;

public class StudentAccount {
    private Student student;
    private double balance;
    private ArrayList<CourseOffer> registeredCourses;

    public StudentAccount(Student student) {
        this.student = student;
        this.balance = 0.0;  
        this.registeredCourses = new ArrayList<>();
    }

    
    public void payTuition(double amount) {
        balance -= amount; 
    }

    
    public void addDebt(double amount) {
        balance += amount;
    }

    
    public double checkBalance() {
        return balance;
    }

    
    public void registerCourse(CourseOffer offering) {
        registeredCourses.add(offering);
        addDebt(offering.getCost());  
    }

   
    public ArrayList<CourseOffer> viewRegisteredCourses() {
        return registeredCourses;
    }

    

}
