package Campus;

import java.time.LocalDate;

public class Sprinkler {

    private Boolean isActive;
    private String model;
    private String serialNumber;
    private LocalDate lastInspectionDate; // changed to LocalDate

    public Sprinkler(String m, String s) {
        this.isActive = true;
        this.model = m;
        this.serialNumber = s;
        this.lastInspectionDate = LocalDate.now(); // set to the current date by default
    }

    public Boolean isActive(){
        return isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(LocalDate lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public void reset(){
        isActive = true;
    }

    public void disable(){
        isActive = false;
    }

    public void print() {
        System.out.println("Model: " + model + " Serial Number: " + serialNumber + " Active: " + isActive + " Last Inspection Date: " + lastInspectionDate);
    }
}
