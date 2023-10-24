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
public class Campus {
    
    private Address address;
    private ArrayList<Building> buildings;
    
   

    public Campus(Address a){
    
        address = a;
        buildings = new ArrayList<>();
        
    }
     public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
    public void print(){
        System.out.println("Campus: " + address);
        for(Building b: buildings){
            b.print();
        }
    }
}
