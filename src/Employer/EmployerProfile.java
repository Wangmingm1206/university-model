/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employer;

import Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerProfile {
    private String name;
    private ArrayList<Employment> employments = new ArrayList<>();
    
    public EmployerProfile(String n){  //could be company instead of just a name as a string
        this.name = n;
        
    }
         public boolean isMatch(String id){
        if(name.equals(id)) return true;             //String is an object and can do equal matach
        return false;
    }
    
}
