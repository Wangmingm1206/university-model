/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campus;

import java.util.ArrayList;


public class Floor {

    private int number;
    private ArrayList<Classroom> rooms;
    private Building building;
    
    
    
    public Floor(int n, Building b) {
        this.number = n;
        this.building = b;
        this.rooms = new ArrayList<>();
    }
    public void newRoom(int n){
            Classroom r = new Classroom(n, this); //pass the floor object for reference
            rooms.add(r);
    }
    public Boolean isFloorSafe() { 
        for (Classroom room : rooms) {
            if (!room.isRoomSafe()) {
                return false;
            }
        }
        return true;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public ArrayList<Classroom> getRooms() {
        return rooms;
    }
    public void setRooms(ArrayList<Classroom> rooms) {
        this.rooms = rooms;
    }
    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }
    public void print() {
        System.out.println("Floor number: " + number);
        for (Classroom room : rooms) {
            room.print();
        }
    }
}
