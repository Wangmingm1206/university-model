/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */

import WorkAreas.Workarea;

/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    Person person;
    Workarea landingworkarea;
    
    public UserAccount(Person p){
        person = p;
    }

    public void registerCourse(Course course) {
    }

    public Person getPerson() {
        return null;
    }
    
}