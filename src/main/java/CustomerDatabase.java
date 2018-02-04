/**
 *
 * This class holds information about various customers on our platform,
 * while also providing some functions to retrieve meaningful information
 * about the customer data.
 */

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerDatabase {

    ArrayList<Customer> customerDB = new ArrayList<>();;
    double officeLat = 53.339428;
    double officeLong = -6.257664;

    public CustomerDatabase(double officeLat, double officeLong) {
        this.officeLat = officeLat;
        this.officeLong = officeLong;
    }

    public CustomerDatabase() {
    }

    /**
     * Returns the great circle distance between two given points, based on their
     * latituted and longitude coordinates, using the first formula found in
     * the following Wikipedia article.
     * https://en.wikipedia.org/wiki/Great-circle_distance
     *
     * @param  location1Lat  the latitude of the first point.
     * @param  location2Lat the latitude of the second point.
     * @param  location1Long  the longitude of the first point.
     * @param  location2Long the longitude of the second point.
     * @return      the great circle distance between the two locations
     */
    public static double calculateGreatCircleDistance(double location1Lat, double location1Long, double location2Lat, double location2Long){
        final int EARTH_RADIUS_KILOMETERS = 6371;

        if(Math.abs(location1Lat) > 90 || Math.abs(location2Lat) > 90){
            throw new IllegalArgumentException();
        }

        if(Math.abs(location1Long) > 180 || Math.abs(location2Long) > 180){
            throw new IllegalArgumentException();
        }

        double lat1 = Math.toRadians(location1Lat);
        double lat2 = Math.toRadians(location2Lat);

        double long1 = Math.toRadians(location1Long);
        double long2 = Math.toRadians(location2Long);

        double centralAngle = Math.acos((Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(long2-long1)));

        double distance = EARTH_RADIUS_KILOMETERS * centralAngle;
        return distance;
    }

    /**
     * Search customers in the database that are within a specified distance (in Km)
     * from the given office location
     *
     * @param  rangeKilometers  an absolute URL giving the base location of the image
     * @return      an ArrayList with all the customers within the specified range
     */
    public ArrayList<Customer> findCustomersWithinRange(int rangeKilometers){

        ArrayList<Customer> customersWithinRange = new ArrayList<>();

        for(Customer tmpCustomer : customerDB){
            double customerRange = calculateGreatCircleDistance(officeLat, officeLong, tmpCustomer.getLatitude(), tmpCustomer.getLongitude());
            if(customerRange <= rangeKilometers){
                customersWithinRange.add(tmpCustomer);
            }
        }

        return customersWithinRange;
    }

    /**
     * Reads a given JSON file, which should contain customer information
     * in JSON format and imports it into the customer database.
     * <p>
     * The GSON library is used to parse JSON.
     *
     * @param  filePath the path to the file where the contents should be imported from.
     */
    public void importFromJSONFile(String filePath){
        Gson gson = new Gson();


        try(BufferedReader jsonBufferedReader = new BufferedReader(new FileReader(filePath))){
            String customerJson;

            while((customerJson = jsonBufferedReader.readLine()) != null){
                Customer tmpCustomer = gson.fromJson(customerJson, Customer.class);
                if(customerDB != null){
                    customerDB.add(tmpCustomer);
                }
            }
        }catch (FileNotFoundException ex){
            System.err.println("Incorrect file path.");
        }catch (IOException ex){
            System.err.println("An error occurred while trying to read your file.");
        }
    }

    /**
     * Sorts the customer database by name.
     * It uses the SortCustomerByName comparator.
     *
     */
    public void sortByName(){

        if(customerDB != null){
            customerDB.sort(new SortCustomerByName());
        }
    }

    public void addCustomerToDB(Customer customer){
        if(customerDB != null){
            customerDB.add(customer);
        }
    }

}
