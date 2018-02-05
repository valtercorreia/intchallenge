import java.util.ArrayList;

/**
 * This class solves the following challenge while
 * also providing a possible usage of all classes.
 *
 * Challenge: Write a program that will read the full
 * list of customers and output the names and user ids
 * of matching customers (within 100km),
 * sorted by User ID (ascending).
 */

public class Example {

    public static void main(String[] args){
        CustomerDatabase customerDatabase = new CustomerDatabase();

        customerDatabase.importFromJSONFile("./src/main/resources/gistfile1.txt");

        customerDatabase.sortByUserID();

        ArrayList<Customer> challengeResult = customerDatabase.findCustomersWithinRange(100);

        for(Customer customer : challengeResult){
            System.out.println("Customer " + customer.getName() + " with User ID " + customer.getUser_id());
        }

    }

}
