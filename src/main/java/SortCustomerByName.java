/* This class implements a comparator based on the customer name
 *
 */

import java.util.Comparator;

public class SortCustomerByName implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2){
        if(customer1 == null){
            System.err.println("Customer 1 not properly initialized");
        }

        if(customer2 == null){
            System.err.println("Customer 2 not properly initialized");
        }

        return customer1.getName().compareToIgnoreCase(customer2.getName());
    }
}
