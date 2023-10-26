package Campus;

import java.util.ArrayList;

public class CampusMainExample {

    public static void main(String[] args) {
        // 0. Create Address object
        Address address1 = new Address(123, "Main St", "12345", "40.7128, -74.0060");
        
        // 1. Create campus object
        Campus myCampus = new Campus(null, address1);

        // 2. Create and add buildings
        Building building1 = new Building(1, address1);
        myCampus.addBuilding(building1); 

        // 3. Create and floors
        Floor floor1 = new Floor(1, building1);
        Floor floor2 = new Floor(2, building1);
        

        // 4. Create and add rooms
        Classroom room101 = new Classroom(101, floor1);
        Classroom room102 = new Classroom(102, floor1);
        Classroom room201 = new Classroom(201, floor2);
        Classroom room202 = new Classroom(202, floor2);

        floor1.setRooms(new ArrayList<>() {{ add(room101); add(room102); }});
        floor2.setRooms(new ArrayList<>() {{ add(room201); add(room202); }});

        new Sprinkler("ModelA", "SN001");
        new Sprinkler("ModelA", "SN002");

        

        // 6. Write methods to determine if campus is safe
        if (myCampus.isCampusSafe()) {
            System.out.println("The campus is safe.");
        } else {
            System.out.println("The campus is not safe.");
        }
    }
}
