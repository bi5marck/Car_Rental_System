package test.uk.ac.ncl.Z_Wu.Car_Rental_System;

import org.junit.Test;
import uk.ac.ncl.Z_Wu.Car_Rental_System.*;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * SmallCar Tester.
 *
 * @author Z.Wu
 * @version 1.0
 * @since <pre>oct 23, 2019</pre>
 */
public class SmallCarTest {

    /**
     * Method: getRegistrationNumber()
     * Test content: If first component registration number's input is correct.
     */
    @Test
    public void testFirstComponent_RegistrationNumber() {
        //Test first component contains 3 letters and 1 digits.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NEE5TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 letters and 1 digits in another sequence.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NEEW4YG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 digits and 1 letters.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "N465TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 3 digits and 1 letters in another sequence.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "5R65TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 4 digits.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "4465TYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component contains 4 letters.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NEWTTYG", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component's length is incorrect.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "N3TYG", 25);
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
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG576TY", 25);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Wrong format."));
        }

        //Test first component's length is incorrect.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG57H", 25);
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
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG57HXE", 25);
        assertEquals("NG57 HXE", car_1.getRegistrationNumber());
    }


    /**
     * Method: addFuel(Integer litres)
     */
    @Test
    public void testAddFuel() {
        //Test add negative value of fuel.
        try {
            final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG57HTY", 25);
            car_1.addFuel(-2);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Fuel value can't be negative."));
        }

        //Test add return value and function of this method.
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG87HTY", 25);
        assertEquals(10, car_1.addFuel(10), 0);
        assertEquals(35, car_1.getCurrentLitres(), 0);

        //Test add more fuel than car's whole fuel tank capacity.
        assertEquals(14, car_1.addFuel(100), 0);
        assertEquals(49, car_1.getWholeLitresCapacity(), 0);
    }

    /**
     * Method: getCurrentLitres()
     */
    @Test
    public void testGetCurrentLitres() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG38HTY", 25);
        assertEquals(25, car_1.getCurrentLitres(), 0);
    }

    /**
     * Method: isCarTankFull()
     */
    @Test
    public void testIsCarTankFull() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG67HTY", 25);
        final Car car_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG56HGY", 49);
        assertFalse(car_1.isCarTankFull());
        assertTrue(car_2.isCarTankFull());
    }

    /**
     * Method: getFirst_component()
     */
    @Test
    public void testGetFirst_component() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "KP06CHK", 25);
        assertEquals("KP06", car_1.getFirst_component());
    }

    /**
     * Method: getSecond_component()
     */
    @Test
    public void testGetSecond_component() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "BR67HTY", 25);
        assertEquals("HTY", car_1.getSecond_component());
    }

    /**
     * Method: getWholeLitresCapacity()
     */
    @Test
    public void testGetWholeLitresCapacity() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "TI30BFR", 25);
        assertEquals(49, car_1.getWholeLitresCapacity(), 0);
    }

    /**
     * Method: driveCar(Integer KM)
     * Thees test instances here don't test any methods in {@link Car_Rental_Company}, only for drive() method.
     */
    @Test
    public void testDriveCar() {
        //This car can't be driven because it is not rented.
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PR89ABC", 49);
        assertEquals(0, car_1.driveCar(10), 0);


        //Use Car_Rental_Company to issue car and drive car.
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.set(2017, 3, 3);
        Date date_1 = calendar_1.getTime();
        Customer customer_1 = new Customer("Dan", "D", date_1, true, "65");
        Customer customer_2 = new Customer("Jay", "Min", date_1, true, "49");


        final Car car_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PS89ABC", 49);
        final Car car_3 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "PW89PBC", 35);
        Map<Car, Boolean> CarBooleanMap = new HashMap<>();
        CarBooleanMap.put(car_2, true);
        CarBooleanMap.put(car_3, true);
        Car_Rental_Company car_rental_company = new Car_Rental_Company(CarBooleanMap);
        car_rental_company.issueCar(customer_1, "small");
        car_rental_company.issueCar(customer_2, "small");
        assertEquals(2, car_rental_company.getCar(customer_1).driveCar(40), 0);
        assertEquals(1, car_rental_company.getCar(customer_2).driveCar(17), 0);
        assertEquals(49, car_rental_company.getCar(customer_2).driveCar(961), 0);
        assertEquals(-1, car_rental_company.getCar(customer_2).getCurrentLitres(), 0);

    }

    /**
     * Method: getType()
     */
    @Test
    public void testGetType() {
        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "ER67HTY", 25);
        assertEquals("small", car_1.getType());
    }

}
