
package Persona;

import Department.Department;
import java.util.ArrayList;


public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentlist;
    private static final int MAX_STUDENTS = 10;

    public StudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList<StudentProfile>();

    }
    
    public StudentProfile newStudentProfile(Person p) {
        if(studentlist.size() < MAX_STUDENTS) {
            StudentProfile sp = new StudentProfile(p);
            studentlist.add(sp);
            return sp;
        } else {
            System.out.println("Maximum number of students reached for this program.");
            return null;
        }
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }

    public ArrayList<StudentProfile> getAllStudentProfiles() {
        return studentlist;
    }
    
}
