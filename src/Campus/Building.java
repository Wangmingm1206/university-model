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
public class Building {
    private int number;
    private ArrayList<Floor> floors;
    private Address address;
    
    

    public Building(int n, Address ad){
        this.number = n;
        this.address = ad;
        this.floors = new ArrayList();
    
    }
    
    public Floor addNewFloor(int n){
        Floor f = new Floor(n, this); //reference back to building;
        floors.add(f);
        return f;
    }
    public Boolean isBuildingSafe(){
        
        //Building is safe if all floors are safe
        return true; //to be completed
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void print(){
        System.out.println("Building: " + number + " " + address);
        for(Floor f: floors){
            f.print();
        }
    }
    
}
