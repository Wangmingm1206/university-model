/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {

    private String number;
    private String name;
    private int credits;
    private int price = 1500; // per credit hour
    private int totalPrice;

    

    

    public Course(String numb, String n, int ch) {
        this.name = n;
        this.number = numb;
        this.credits = ch;
        calculateTotalPrice();
    }
    
    private void calculateTotalPrice(){
        this.totalPrice = this.price * this.credits;
    }
    public String getCourseByNumber() {
        return number;
    }

    public int getCoursePrice() {
        return totalPrice;

    }

    public int getCredits() {
        return credits;
    }

    public String getCourseName() {
        return name;
    }  
    


    public void setPrice(int price) {
        this.price = price;
        calculateTotalPrice();
    }
    public void setCredits(int credits) {
        this.credits = credits;
        calculateTotalPrice();
    }
    public void print(){
        System.out.println("Course: " + number + " " + name + " " + credits + " " + totalPrice);
    }


}