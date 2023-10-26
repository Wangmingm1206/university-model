
package Campus;

import java.util.ArrayList;


public class Building {
    private int number;
    private ArrayList<Floor> floors;
    private Address address;
    
    

    public Building(int n, Address ad){
        number = n;
        address = ad;
        floors = new ArrayList<>();
    
    }
    
    public Floor addNewFloor(int n){
        Floor f = new Floor(n, this); //reference back to building;
        floors.add(f);
        return f;
    }
    public Boolean isBuildingSafe(){
        
        for (Floor f: floors){
            if(!f.isFloorSafe()) return false;
        }//Building is safe if all floors are safe
        return true; //to be completed
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Floor> getFloors() {
        return new ArrayList<>(floors);
    }
    
    

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void print(){
        System.out.println("Building: " + number);
        address.print();
        for(Floor f: floors){
            f.print();
        }
    
}

    
    
}
