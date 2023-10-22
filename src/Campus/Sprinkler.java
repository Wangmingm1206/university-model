/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campus;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Sprinkler {

    private Boolean status; // which takes on the true if sprinkler is active otherwise false 
    private String model;
    private String serialnumber;
    private String lastinspectiondate; 
    private ArrayList<Sprinkler> sprinklers;
    
//  Sprinker spinkler = new Sprikler("294424", "001349");    
    

    public void setLastinspectiondate(String lastinspectiondate) {
        this.lastinspectiondate = lastinspectiondate;
    }
    public ArrayList<Sprinkler> getSprinklers() {
        return sprinklers;
    }
    public void setSprinklers(ArrayList<Sprinkler> sprinklers) {
        this.sprinklers = sprinklers;
    }
public Sprinkler(String m, String s)
    {
        this.status = true;
        this.model = m;
        this.serialnumber = s;
    }
    // if(spinkler.isActive()) then send alert  ...
    public Boolean isActive(){
        return status;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getSerialnumber() {
        return serialnumber;
    }
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }
    
    public String getLastinspectiondate() {
        return lastinspectiondate;
    }
    

    public void reset(){
        status = true;
    }    
    public void disable(){
        status = false;
    }
    public void print() {
    } 
}
