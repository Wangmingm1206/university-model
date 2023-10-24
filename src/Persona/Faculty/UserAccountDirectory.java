/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.Faculty;

import Persona.*;
import Department.Department;
import java.util.ArrayList;

import CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class UserAccountDirectory {

    Department department;
    ArrayList<UserAccount> studentlist;

    public UserAccountDirectory(Department d) {

        department = d;
        studentlist = new ArrayList<>();

    }

    public UserAccount newUserAccount(Person p) {

        UserAccount sp = new UserAccount(p);
        studentlist.add(sp);
        return sp;
    }

    public UserAccount findStudent(String id) {
        for (UserAccount sp : studentlist) {
            if (sp.getPerson().getPersonId().equals(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    public ArrayList<UserAccount> getAllStudents() {
        return studentlist;
    }
    
    // Assuming a method in UserAccount class to register a course
    public void registerStudentForCourse(UserAccount student, Course course) {
        student.registerCourse(course);
    }
}
