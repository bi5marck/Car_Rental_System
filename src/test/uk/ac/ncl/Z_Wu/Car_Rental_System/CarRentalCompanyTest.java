package test.uk.ac.ncl.Z_Wu.Car_Rental_System;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import uk.ac.ncl.Z_Wu.Car_Rental_System.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * CarRentalCompany Tester.
 *
 * @author z.wu
 * @since <pre>2019/10/24 15:53</pre>
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarRentalCompanyTest {
    /**
     * Method: testAvailableCars(),GetRentedCars()
     * Test if testAvailableCars() can get right number of available cars.
     */
    @Test
    public void test_01_AvailableCar_GetRentedCars_GetCars() {
        final Car smallCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "FR56OUY", 25);
        final Car smallCar_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "FR57AXE", 25);
        final Car smallCar_3 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "VF54JTY", 30);

        final Car largeCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "BG54WSQ", 25);
        final Car largeCar_2 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PL64COT", 25);
        final Car largeCar_3 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PW30OIE", 30);

        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(smallCar_1, true);
        CarBooleanMap.put(smallCar_2, true);
        CarBooleanMap.put(smallCar_3, true);

        CarBooleanMap.put(largeCar_1, true);
        CarBooleanMap.put(largeCar_2, true);
        CarBooleanMap.put(largeCar_3, true);

        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2011, 2 + 1, 3);
        Date date_1 = calendar_1.getTime();
        Customer customer_1 = new Customer("Jay", "Li", date_1, true, "23");
        Customer customer_2 = new Customer("Bob", "Nick", date_1, true, "16");

        //Test if testAvailableCars() can get right number of available cars.
        assertEquals(3, car_rental_company.availableCars("small"));
        assertEquals(3, car_rental_company.availableCars("large"));
        car_rental_company.issueCar(customer_1, "small");
        car_rental_company.issueCar(customer_2, "large");
        assertEquals(2, car_rental_company.availableCars("small"));
        assertEquals(2, car_rental_company.availableCars("large"));

        //Test GetRentedCars()
        System.out.println(car_rental_company.getRentedCars());

    }

    /**
     * Method: testGetCar()
     */
    @Test
    public void test_02_GetCar() {
        final Car smallCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG54OUY", 25);
        final Car largeCar_4 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "SE23VGT", 25);

        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(smallCar_1, true);
        CarBooleanMap.put(largeCar_4, true);
        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2011, 2 + 1, 3);
        Date date_1 = calendar_1.getTime();
        Customer customer_1 = new Customer("Jay", "Li", date_1, true, "23");
        Customer customer_2 = new Customer("Ben", "Mac", date_1, true, "98");
        assertNull(null, car_rental_company.getCar(customer_1));
        car_rental_company.issueCar(customer_1, "small");
        car_rental_company.issueCar(customer_2, "large");
        assertEquals(smallCar_1, car_rental_company.getCar(customer_1));
        assertEquals(largeCar_4, car_rental_company.getCar(customer_2));
    }

    /**
     * Method: testIssueCar()
     */
    @Test
    public void test_03_IssueCar() {
        final Car smallCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PO12CFR", 25);
        final Car smallCar_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PO76CFR", 25);
        final Car smallCar_3 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "KH09DEW", 30);
        final Car smallCar_4 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "VE84CFP", 20);
        final Car smallCar_5 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PY16BEQ", 20);

        final Car largeCar_5 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "BT09MMM", 25);
        final Car largeCar_6 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PP33QAZ", 25);

        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(smallCar_1, true);
        CarBooleanMap.put(smallCar_2, true);
        CarBooleanMap.put(smallCar_3, true);
        CarBooleanMap.put(smallCar_4, true);
        CarBooleanMap.put(smallCar_5, true);
        CarBooleanMap.put(largeCar_5, true);
        CarBooleanMap.put(largeCar_6, true);
        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);

        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2011, 2 + 1, 3);
        Date date_1 = calendar_1.getTime();

        //the person renting the car must have a full driving licence
        Customer customer_1 = new Customer("Jack", "Wang", date_1, false, "98");
        assertFalse(car_rental_company.issueCar(customer_1, "small"));
        Customer customer_2 = new Customer("Jacky", "Zhou", date_1, false, "48");
        assertFalse(car_rental_company.issueCar(customer_2, "large"));


        //Customers can't rent more than one car at a time
        Customer customer_3 = new Customer("Jack", "Wang", date_1, true, "98");
        assertTrue(car_rental_company.issueCar(customer_3, "small"));
        assertFalse(car_rental_company.issueCar(customer_3, "large"));
        assertEquals(4, car_rental_company.availableCars("small"));


        //Customers must be at least 20 years old and must have held their licence for at least 1 year to rent small car
        //

        //Customers' age < 20
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011, 2 + 1, 3);
        Date date = calendar.getTime();
        Customer customer_4 = new Customer("Jack", "Wang", date_1, true, "98");
        customer_1.setCustomersDob(date);   //change customer's date of birth as 2011.3.3
        assertFalse(car_rental_company.issueCar(customer_4, "small"));

        //Customers' licence hold  < 1 year
        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.set(2019, 2 + 1, 3);
        Date date_2 = calendar_2.getTime();
        Customer customer_5 = new Customer("Philips", "Wang", date_2, true, "98");
        assertFalse(car_rental_company.issueCar(customer_5, "small"));


        //Customers must be at least 25 years old and must have held their licence for at least 5 year to rent large car
        //

        //Customers' age < 25
        Calendar calendar_6 = Calendar.getInstance();
        calendar_6.set(2011, 2 + 1, 3);
        Date date_6 = calendar_6.getTime();
        Customer customer_6 = new Customer("Fanta", "Wang", date_6, true, "28");
        customer_6.setCustomersDob(date);   //change customer's date of birth as 2011.3.3
        assertFalse(car_rental_company.issueCar(customer_4, "large"));

        //Customers' licence hold  < 5 year
        Calendar calendar_7 = Calendar.getInstance();
        calendar_7.set(2015, 2 + 1, 3);
        Date date_7 = calendar_2.getTime();
        Customer customer_7 = new Customer("Fuji", "Wang", date_7, true, "98");
        assertFalse(car_rental_company.issueCar(customer_7, "large"));

    }


    /**
     * Method: testTerminateRental()
     */
    @Test
    public void test_04_TerminateRental() {
        final Car smallCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "QM23UYT", 25);
        final Car smallCar_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "BN78HGF", 25);
        final Car smallCar_3 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "RE87NBF", 30);
        final Car smallCar_4 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "EQ92EWQ", 20);
        final Car smallCar_5 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "MI88CDE", 20);

        final Car largeCar_7 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "AK47BBQ", 25);
        final Car largeCar_8 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "XX00XXX", 25);

        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(smallCar_1, true);
        CarBooleanMap.put(smallCar_2, true);
        CarBooleanMap.put(smallCar_3, true);
        CarBooleanMap.put(smallCar_4, true);
        CarBooleanMap.put(smallCar_5, true);
        CarBooleanMap.put(largeCar_7, true);
        CarBooleanMap.put(largeCar_8, true);

        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2011, 2 + 1, 3);
        Date date_1 = calendar_1.getTime();
        Customer customer_1 = new Customer("Jay", "Li", date_1, true, "23");
        Customer customer_2 = new Customer("Bob", "Nick", date_1, true, "16");
        //Before rent cars
        assertEquals(5, car_rental_company.availableCars("small"));
        assertEquals(2, car_rental_company.availableCars("large"));
        //Rent cars
        car_rental_company.issueCar(customer_1, "small");
        car_rental_company.issueCar(customer_2, "large");
        //After renting cars
        assertEquals(4, car_rental_company.availableCars("small"));
        assertEquals(1, car_rental_company.availableCars("large"));
        car_rental_company.getCar(customer_1).driveCar(100);
        car_rental_company.getCar(customer_2).driveCar(100);
        //Terminate Rental
        assertEquals(5, car_rental_company.terminateRental(customer_1));
        assertEquals(9, car_rental_company.terminateRental(customer_2));
        //Cars come back
        assertEquals(5, car_rental_company.availableCars("small"));
        assertEquals(2, car_rental_company.availableCars("large"));
    }

    /**
     * Method: testDuplicateInstancesOfCar()
     */
    @Test
    public void test_05_DuplicateInstancesOfCar() {

        //create an instance of small car which is as same as smallCar_5 in test_04_TerminateRental() method
        try {
            final Car smallCar_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "MI88CDE", 20);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Car registration number is duplicated."));
        }


        //create an instance of large car which is as same as largeCar_8
        try {
            final Car largeCar_8 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "XX00XXX", 20);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Car registration number is duplicated."));
        }


    }

    /**
     * Method: testNumberOfCarInstance()
     */
    @Test
    public void test_06_NumberOfCarInstance() {

        //create 21st instance of small car
        try {
            final Car smallCar_15 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PO87CDW", 20);
            final Car smallCar_16 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "YG06BJO", 20);
            final Car smallCar_17 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "XY15VXK", 20);
            final Car smallCar_18 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "CJ56GKM", 20);
            final Car smallCar_19 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "DM60HOC", 20);
            final Car smallCar_20 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "XI50BFR", 20);
            final Car smallCar_21 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "XK70DHK", 20);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("You can only creat 20 instances of small car."));
        }

        //create 11st instance of large car
        try {
            final Car largeCar_9 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "GT35CRT", 20);
            final Car largeCar_10 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "ER79VFR", 20);
            final Car largeCar_11 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "TE09GTE", 20);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("You can only creat 10 instances of large car."));
        }

    }


}
