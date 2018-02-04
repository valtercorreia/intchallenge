import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerDatabaseTest {


    @Test
    public void sortByNameTest() {
        CustomerDatabase cDB = new CustomerDatabase();
        Customer customer1 = new Customer("Bond");
        Customer customer2 = new Customer("Anna");

        cDB.addCustomerToDB(customer1);
        cDB.addCustomerToDB(customer2);

        cDB.sortByName();

        ArrayList<Customer> expected = new ArrayList<>();
        expected.add(customer2);
        expected.add(customer1);

        assertEquals(expected, cDB.customerDB);
    }

    @Test
    public void sortByNameEmptyTest() {
        CustomerDatabase cDB = new CustomerDatabase();

        cDB.sortByName();

        ArrayList<Customer> expected = new ArrayList<>();

        assertEquals(expected, cDB.customerDB);
    }

    @Test
    public void calculateGCDistanceTest() {
        double result = CustomerDatabase.calculateGreatCircleDistance(53.339428, -6.257664, 53.76139,-7.2875);

        assertEquals(82.64,result, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateGCDistanceInvalidArgs1Test() {
        double result = CustomerDatabase.calculateGreatCircleDistance(100.339428, -6.257664, 53.76139,-7.2875);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateGCDistanceInvalidArgs2Test() {
        double result = CustomerDatabase.calculateGreatCircleDistance(53.339428, -190.257664, 53.76139,-7.2875);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateGCDistanceInvalidArgs3Test() {
        double result = CustomerDatabase.calculateGreatCircleDistance(53.339428, -6.257664, 94.76139,-7.2875);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateGCDistanceInvalidArgs4Test() {
        double result = CustomerDatabase.calculateGreatCircleDistance(53.339428, -6.257664, 53.76139,192.2875);
    }


    @Test
    public void findCustomersWithinRangeTest() {
        CustomerDatabase cDB = new CustomerDatabase();
        Customer customer1 = new Customer("Bond", 1, 53.74452,-7.11167);
        Customer customer2 = new Customer("Anna", 2, 51.885616, -10.424095);

        cDB.addCustomerToDB(customer1);
        cDB.addCustomerToDB(customer2);

        ArrayList<Customer> result = cDB.findCustomersWithinRange(100);

        ArrayList<Customer> expected = new ArrayList<>();
        expected.add(customer1);

        assertEquals(expected, result);
    }

    @Test
    public void importFromJSONFileTest() {
        CustomerDatabase cDB = new CustomerDatabase();

        cDB.importFromJSONFile("./src/test/resources/test.txt");

        Customer customer1 = new Customer("Christina McArdle", 12, 52.986375,-6.043701);

        ArrayList<Customer> expected = new ArrayList<>();
        expected.add(customer1);

        assertEquals(expected, cDB.customerDB);
    }

    @Test
    public void importFromJSONFileEmptyTest() {
        CustomerDatabase cDB = new CustomerDatabase();

        cDB.importFromJSONFile("./src/test/resources/test2.txt");

        ArrayList<Customer> expected = new ArrayList<>();

        assertEquals(expected, cDB.customerDB);
    }


}
