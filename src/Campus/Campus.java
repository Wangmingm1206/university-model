package Campus;

import java.util.ArrayList;

public class Campus {
    private String name;
    private ArrayList<Building> buildings;
    private Address campusAddress;

    public Campus(String name, Address campusAddress) {
        this.name = name;
        this.campusAddress = campusAddress;
        this.buildings = new ArrayList<>();
    }

    public Building addNewBuilding(int number, Address address) {
        Building b = new Building(number, address);
        buildings.add(b);
        return b;
    }

    public boolean isCampusSafe() {
        for (Building b : buildings) {
            if (!b.isBuildingSafe()) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Building> getBuildings() {
        return new ArrayList<>(buildings);  // Return a copy to prevent external modification
    }

    public Address getCampusAddress() {
        return campusAddress;
    }

    public void setCampusAddress(Address campusAddress) {
        this.campusAddress = campusAddress;
    }

    public void print() {
        System.out.println("Campus: " + name);
        campusAddress.print();  // Assuming Address class has a print method that displays address details
        for (Building b : buildings) {
            b.print();
        }
    }

    public void addBuilding(Building building1) {
    }
}

