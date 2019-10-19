//package test.uk.ac.ncl.Z_Wu.Car_Rental_System;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import uk.ac.ncl.Z_Wu.Car_Rental_System.Car;
//import uk.ac.ncl.Z_Wu.Car_Rental_System.CarRegistrationNumber;
//import uk.ac.ncl.Z_Wu.Car_Rental_System.LargeCar;
//
//import static org.junit.Assert.*;
//
///**
// * LargeCar Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>Ê®ÔÂ 16, 2019</pre>
// */
//public class LargeCarTest {
//    private CarRegistrationNumber carRegistrationNumber = new CarRegistrationNumber("AX01", "ZER");
//
//    @Before
//    public void before() throws Exception {
//    }
//
//    @After
//    public void after() throws Exception {
//    }
//
//
//    /**
//     * Method: getRegistrationNumber()
//     */
//    @Test
//    public void testGetRegistrationNumber() throws Exception {
////TODO: Test goes here...
//
//
//    }
//
//    /**
//     * Method: addFuel(Integer litres)
//     */
//    @Test
//    public void testAddFuel() throws Exception {
////TODO: Test goes here...
//        Car car_a=new LargeCar(carRegistrationNumber,20);
//        assertEquals(20,car_a.addFuel(20),0);
//        assertEquals(40,car_a.getCurrentLitres(),0);
//        assertEquals(20,car_a.addFuel(100),0);
//        assertEquals(60,car_a.getCurrentLitres(),0);
//    }
//
//    /**
//     * Method: getCurrentLitres()
//     */
//    @Test
//    public void testGetCurrentLitres() throws Exception {
////TODO: Test goes here...
//
//    }
//
//    /**
//     * Method: isCarTankFull()
//     */
//    @Test
//    public void testIsCarTankFull() throws Exception {
////TODO: Test goes here...
//
//    }
//
//    /**
//     * Method: toString()
//     */
//    @Ignore
//    public void testToString() throws Exception {
////TODO: Test goes here...
//    }
//
//    /**
//     * Method: getWholeLitresCapacity()
//     */
//    @Test
//    public void testGetWholeLitresCapacity() throws Exception {
////TODO: Test goes here...
//    }
//
//    /**
//     * Method: driveCar(Integer KM)
//     */
//    @Test
//    public void testDriveCar() throws Exception {
////TODO: Test goes here...
//        Car car_a = new LargeCar(carRegistrationNumber, 60);
//        assertEquals(6 ,car_a.driveCar(60),0);
//        assertEquals(54,car_a.getCurrentLitres(),0);
//        Car car_b=new LargeCar(carRegistrationNumber,60);
//        assertEquals(2,car_b.driveCar(20),0);
//        assertEquals(58,car_b.getCurrentLitres(),0);
//    }
//
//
//}
