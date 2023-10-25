/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campus;

/**
 *
 * @author kal bugrara
 */
public class Address {

    private int number;
    private String street;
    private String zipcode;
    private String gps;


    public Address(int n, String s, String zip, String g){
    this.number = n;
    this.street = s;
    this.zipcode = zip;
    this.gps = g;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
    public void print(){
        System.out.println("Address: " + number + " " + street + " " + zipcode + " " + gps);
      
    
    }
}