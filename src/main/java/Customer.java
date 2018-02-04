/**
 * This class holds information about our customers.
 *
 */

import java.util.Comparator;

public class Customer{

    private String name;
    private int user_id;
    private float longitude;
    private float latitude;

    public Customer(String name, int user_id, float longitude, float latitude) {
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


}
