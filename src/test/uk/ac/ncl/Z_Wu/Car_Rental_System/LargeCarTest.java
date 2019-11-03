package test.uk.ac.ncl.Z_Wu.Car_Rental_System;

import org.junit.Test;
import uk.ac.ncl.Z_Wu.Car_Rental_System.*;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Large Tester.
 *
 * @author Z.Wu
 * @version 1.0
 * @since <pre>oct 23, 2019</pre>
 */
public class LargeCarTest {

    /**
     * Method: getRegistrationNumber()
     * Test content: If first component registration number's input is correct.
     */
    @Test
    public void testFirstComponent_RegistrationNumber() {
        //Test first component contains 3 letters and 1 digits.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NEE5TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 letters and 1 digits in another sequence.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NEEW4YG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 digits and 1 letters.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "N465TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 digits and 1 letters in another sequence.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "5R65TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 4 digits.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "4465TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 4 letters.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NEWTTYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component's length is incorrect.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "N3TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong length of registration number."));
        }
        System.out.println("FirstComponent_RegistrationNumber() test finishes!");
    }

    /**
     * Method: getRegistrationNumber()
     * Test content: If second component registration number's input is correct.
     */
    @Test
    public void testSecondComponent_RegistrationNumber() {
        //Test second component contains digits.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG576TY", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component's length is incorrect.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG57H", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong length of registration number."));
        }
        System.out.println("SecondComponent_RegistrationNumber() test finishes!");
    }

    /**
     * Method: getRegistrationNumber()
     * Test content: If this method can get correct value.
     */
    @Test
    public void testGetRegistrationNumber() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG57HXE", 25);
        assertEquals("NG57 HXE", car_1.getRegistrationNumber());
        assertEquals("NG57", car_1.getFirst_component());
        assertEquals("HXE", car_1.getSecond_component());
    }


    /**
     * Method: addFuel(Integer litres)
     */
    @Test
    public void testAddFuel() {
        //Test add negative value of fuel.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG57HTY", 25);
            car_1.addFuel(-2);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Fuel value can't be negative."));
        }

        //Test add return value and function of this method.
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG87HTY", 25);
        assertEquals(10, car_1.addFuel(10), 0);
        assertEquals(35, car_1.getCurrentLitres(), 0);

        //Test add more fuel than car's whole fuel tank capacity.
        assertEquals(25, car_1.addFuel(100), 0);
        assertEquals(60, car_1.getCurrentLitres(), 0);
    }


    /**
     * Method: isCarTankFull() and getCurrentLitres()
     */
    @Test
    public void testIsCarTankFull() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG67HTY", 25);
        final Car car_2 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "NG56HGY", 60);
        assertFalse(car_1.isCarTankFull());
        assertTrue(car_2.isCarTankFull());
        assertEquals(25, car_1.getCurrentLitres(), 0);
    }

    /**
     * Method: driveCar(Integer KM)
     * Thees test instances here don't test any methods in {@link Car_Rental_Company}, only for drive() method.
     */
    @Test
    public void testDriveCar() {
        //This car can't be driven because it is not rented.
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PR89ABC", 49);
        assertEquals(0, car_1.driveCar(10), 0);


        //Use Car_Rental_Company to issue car and drive car.
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2011, 3, 3);
        Date date_1 = calendar_1.getTime();
        Customer customer_1 = new Customer("Dan", "D", date_1, true, "65");
        Customer customer_2 = new Customer("Jay", "Min", date_1, true, "49");


        final Car car_2 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PS89ABC", 50);
        final Car car_3 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "PW89PBC", 35);
        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(car_2, true);
        CarBooleanMap.put(car_3, true);
        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);
        car_rental_company.issueCar(customer_1, "large");
        car_rental_company.issueCar(customer_2, "large");
        //Test first 50 kilometres.
        assertEquals(1, car_rental_company.getCar(customer_1).driveCar(8), 0);
        assertEquals(5, car_rental_company.getCar(customer_1).driveCar(41), 0);

        //Test reminder kilometres.
        assertEquals(5, car_rental_company.getCar(customer_2).driveCar(50), 0);
        assertEquals(6, car_rental_company.getCar(customer_2).driveCar(65), 0);
        assertEquals(11, car_rental_company.getCar(customer_2).driveCar(132), 0);
        assertEquals(38, car_rental_company.getCar(customer_2).getCurrentLitres(), 0);
        assertEquals(39, car_rental_company.getCar(customer_2).driveCar(550), 0);
        assertEquals(-1, car_rental_company.getCar(customer_2).getCurrentLitres(), 0);
    }

    /**
     * Method: getType()
     */
    @Test
    public void testGetType() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.LARGE_CAR, "ER67HTY", 25);
        assertEquals("large", car_1.getType());
    }

}
