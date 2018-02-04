/**
 * This class holds information about our customers.
 *
 */

import java.util.Comparator;
import java.util.Objects;

public class Customer{

    private String name;
    private int user_id;
    private double longitude;
    private double latitude;

    public Customer(String name, int user_id, double latitude, double longitude) {
        this.name = name;
        this.user_id = user_id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o){

        //Checks if null
        if (o == null){
            return false;
        }

        //Checks agains itself
        if (this == o){
            return true;
        }

        //Checks if its the same type
        if (this.getClass() != o.getClass()){
            return false;
        }

        Customer anotherCustomer = (Customer) o;

        //Compare customers information
        return Objects.equals(this.name, anotherCustomer.getName())
                && Objects.equals(this.user_id, anotherCustomer.getUser_id())
                && Objects.equals(this.latitude, anotherCustomer.getLatitude())
                && Objects.equals(this.longitude, anotherCustomer.getLongitude());
    }
}
