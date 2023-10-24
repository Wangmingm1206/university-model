package Persona;

import java.util.ArrayList;

public class Person {
    
    private String id;
    private String name;

    public Person (String id, String name){
        this.name = name;
        this.id = id;
    }
    
    public String getPersonId(){
        return id;
    }

    public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
    
    
    public static class Student extends Person {
        private double grade;

        public Student(String id, String name) {
            super(id, name);
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        
    }

    
    public static class Faculty extends Person {
        private ArrayList<String> coursesTaught;

        public Faculty(String id, String name) {
            super(id, name);
            this.coursesTaught = new ArrayList<>();
        }

        public ArrayList<String> getCoursesTaught() {
            return coursesTaught;
        }

        public void addCourse(String course) {
            if (!coursesTaught.contains(course)) {
                coursesTaught.add(course);
            }
        }

        
    }
}
