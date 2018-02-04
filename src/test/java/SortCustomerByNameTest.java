

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class SortCustomerByNameTest {

    private SortCustomerByName sCBNComparator = new SortCustomerByName();

    @Test
    public void compareLowerTest() {
        Customer customer1 = new Customer("Anna");
        Customer customer2 = new Customer("Bond");

        int result = sCBNComparator.compare(customer1, customer2);
        assertTrue(result < 0);
    }

    @Test
    public void compareGreaterTest() {
        Customer customer1 = new Customer("Bond");
        Customer customer2 = new Customer("Anna");
        int result = sCBNComparator.compare(customer1, customer2);

        assertTrue(result > 0);
    }

    @Test
    public void compareEqualTest() {
        Customer customer1 = new Customer("Bond");
        Customer customer2 = new Customer("Bond");
        int result = sCBNComparator.compare(customer1, customer2);

        assertTrue(result == 0);
    }
}
