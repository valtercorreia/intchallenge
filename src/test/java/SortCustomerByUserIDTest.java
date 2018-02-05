

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortCustomerByUserIDTest {

    private SortCustomerByUserID sCBNUIDComparator = new SortCustomerByUserID();

    @Test
    public void compareLowerTest() {
        Customer customer1 = new Customer("Anna", 1, 51.885616, -10.424095);
        Customer customer2 = new Customer("Bond", 2, 53.74452,-7.11167);

        int result = sCBNUIDComparator.compare(customer1, customer2);
        assertTrue(result < 0);
    }

    @Test
    public void compareGreaterTest() {
        Customer customer1 = new Customer("Bond", 2, 53.74452,-7.11167);
        Customer customer2 = new Customer("Anna", 1, 51.885616, -10.424095);
        int result = sCBNUIDComparator.compare(customer1, customer2);

        assertTrue(result > 0);
    }

    @Test
    public void compareEqualTest() {
        Customer customer1 = new Customer("Bond", 2, 53.74452,-7.11167);
        Customer customer2 = new Customer("Bond", 2, 53.74452,-7.11167);
        int result = sCBNUIDComparator.compare(customer1, customer2);

        assertTrue(result == 0);
    }
}
