package test.uk.ac.ncl.Z_Wu.Car_Rental_System;

import org.junit.Test;
import uk.ac.ncl.Z_Wu.Car_Rental_System.Customer;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Customer Tester.
 *
 * @author Z.Wu
 * @version 1.0
 * @since <pre>oct 24, 2019</pre>
 */
public class CustomerTest {

    /**
     * Method: Customer()
     * Test content: test constructor method
     */
    @Test
    public void testCustomer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();

        //Test first name is null.
        try {
            Customer customer_1 = new Customer("", "W", date, true, "07");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("First name is null."));
        }

        //Test last name is null.
        try {
            Customer customer_1 = new Customer("GY", "", date, true, "07");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Last name is null."));
        }

        //Test third component is incorrect.
        try {
            Customer customer_1 = new Customer("Bob", "W", date, true, "ac");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Third component of driving licence must be 2 numbers."));
        }

        try {
            Customer customer_1 = new Customer("Bob", "W", date, true, "234");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Third component of driving licence must be 2 numbers."));
        }

        try {
            Customer customer_1 = new Customer("Bob", "W", date, true, "2b");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Third component of driving licence must be 2 numbers."));
        }

    }


    /**
     * Method: getFirst_component()
     */
    @Test
    public void testGetFirst_component() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("NW", customer_1.getFirst_component());
    }

    /**
     * Method: getSecond_component()
     */
    @Test
    public void testGetSecond_component() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("2011", customer_1.getSecond_component());
    }

    /**
     * Method: getThird_component()
     */
    @Test
    public void testGetThird_component() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("07", customer_1.getThird_component());
    }

    /**
     * Method: getDrivingLicenceNumber()
     */
    @Test
    public void testGetDrivingLicenceNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("NW-2011-07", customer_1.getDrivingLicenceNumber());
    }

    /**
     * Method: isFullLicence()
     */
    @Test
    public void testIsFullLicence() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertTrue(customer_1.isFullLicence());
        Customer customer_2 = new Customer("Nicky", "Wu", date, false, "07");
        assertFalse(customer_2.isFullLicence());
    }

    /**
     * Method: getDrivingLicenceIssueDate()
     */
    @Test
    public void testGetDrivingLicenceIssuedate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("2011.3.3", customer_1.getDrivingLicenceIssueDate());
    }

    /**
     * Method: getCustomersName()
     */
    @Test
    public void testGetCustomersName() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        assertEquals("Nick Wu", customer_1.getCustomersName());
    }

    /**
     * Method: getCustomersDob()
     */
    @Test
    public void testGetCustomersDob() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_1 = new Customer("Nick", "Wu", date, true, "07");
        //Test default date of birth
        assertEquals("1970.1.1", customer_1.getCustomersDob());
        //Test setDateOfBirth method
        customer_1.setCustomersDob(date);
        assertEquals("2011.3.3", customer_1.getCustomersDob());
    }
}
