package Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    private ArrayList<Person> personlist;
    private ArrayList<Person.Student> studentlist;
    private ArrayList<Person.Faculty> facultylist;

    public PersonDirectory() {
        personlist = new ArrayList<>();
        studentlist = new ArrayList<>();
        facultylist = new ArrayList<>();
    }

    public Person newPerson(String id, String name) {
        Person p = new Person(id, name);
        personlist.add(p);
        return p;
    }

    public Person.Student newStudent(String id, String name) {
        Person.Student student = new Person.Student(id, name);
        studentlist.add(student);
        return student;
    }

    public Person.Faculty newFaculty(String id, String name) {
        Person.Faculty faculty = new Person.Faculty(id, name);
        facultylist.add(faculty);
        return faculty;
    }

    public Person findPerson(String id) {
        for (Person p : personlist) {
            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }

    public Person.Student findStudent(String id) {
        for (Person.Student student : studentlist) {
            if (student.isMatch(id)) {
                return student;
            }
        }
        return null; // not found after going through the whole list
    }

    public Person.Faculty findFaculty(String id) {
        for (Person.Faculty faculty : facultylist) {
            if (faculty.isMatch(id)) {
                return faculty;
            }
        }
        return null; // not found after going through the whole list
    }
}
