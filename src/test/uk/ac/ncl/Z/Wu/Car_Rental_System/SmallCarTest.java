package test.uk.ac.ncl.Z.Wu.Car_Rental_System;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import uk.ac.ncl.Z.Wu.Car_Rental_System.*;

import static org.junit.Assert.*;

/**
 * SmallCar Tester.
 *
 * @author <Z.Wu>
 * @version 1.0
 * @since <pre>Ê®ÔÂ 15, 2019</pre>
 */
public class SmallCarTest {

    private CarRegistrationNumber a = new CarRegistrationNumber("AX01", "ZER");
    Car car_a = new SmallCar(a, 2);
    Car car_f = new SmallCar(a, 49);

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getRegistrationNumber()
     */
    @Test
    public void testGetRegistrationNumber() throws Exception {
//TODO: Test goes here...
        CarRegistrationNumber b = new CarRegistrationNumber("AX01", "ZER");
        Car car = new SmallCar(b, 2);
        System.out.println(car.getRegistrationNumber());

    }

    /**
     * Method: addFuel(Integer litres)
     */
    @Test
    public void testAddFuel() throws Exception {
//TODO: Test goes here...
        SmallCar car_d = new SmallCar(a, 2);
        assertEquals(47, car_d.addFuel(47), 0);
        SmallCar car_e = new SmallCar(a, 2);
        assertEquals(47, car_e.addFuel(100), 0);
    }

    /**
     * Method: getCurrentLitres()
     */
    @Test
    public void testGetCurrentLitres() throws Exception {
//TODO: Test goes here...
        assertEquals(2, car_a.getCurrentLitres(), 0);
    }

    /**
     * Method: isCarTankFull()
     */
    @Test
    public void testIsCarTankFull() throws Exception {
//TODO: Test goes here...
        assertFalse(car_a.isCarTankFull());
        assertTrue(car_f.isCarTankFull());
    }

    /**
     * Method: toString()
     */
    @Ignore
    public void testToString() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: getWholeLitresCapacity()
     */
    @Test
    public void testGetWholeLitresCapacity() throws Exception {
        assertEquals(49, car_a.getWholeLitresCapacity(), 0);
    }

    /**
     * Method: driveCar(Integer KM)
     */
    @Test
    public void testDriveCar() throws Exception {
//TODO: Test goes here...
        Car car_b = new SmallCar(a, 49);
        Car car_c = new SmallCar(a, 20);
        assertEquals(1, car_b.driveCar(1), 0);
        assertEquals(48, car_b.getCurrentLitres(), 0);
        assertEquals(49, car_c.driveCar(980), 0);
        assertEquals(-29, car_c.getCurrentLitres(), 0);
        int i = car_c.driveCar(980);
        assertEquals(0, i, 0);
    }


} 
