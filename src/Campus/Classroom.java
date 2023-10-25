
package Campus;

import java.util.ArrayList;


public class Classroom {

    private int number;
    private Floor floor;
    private Sprinkler sprinkler;
    private ArrayList<Seat> seats;

    
    public int getNumber() {
        return number;
    }
 
    public Classroom(int n, Floor f) {
        this.number = n;
        this.seats = new ArrayList<>();
        this.floor = f;
        
    
    }
    public void setSprinkler(String m, String sn){
        
        sprinkler = new Sprinkler(m, sn);
        
    }
    public void generateSeats(int size){
        
    }
    public Boolean isRoomSafe(){
        if(sprinkler==null) return false;        
        if(sprinkler.isActive()==true) return true;
        else return false;
    }
       public void setNumber(int number) {
        this.number = number;
    }
    public Floor getFloor() {
        return floor;
    }
    public void setFloor(Floor floor) {
        this.floor = floor;
    }
    public Sprinkler getSprinkler() {
        return sprinkler;
    }
    public void setSprinkler(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    public void print(){
        System.out.println("Classroom: " + number);
        if(sprinkler!=null) sprinkler.print();
        for(Seat s: seats){
            s.print();
        }
    }
}
