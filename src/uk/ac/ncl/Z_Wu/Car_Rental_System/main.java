package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
//        Car a = new SmallCar("21", 4);
//        System.out.println(a.addFuel(100));
//        System.out.println(a);
//        Car b = new LargeCar("21321", 28);
//        System.out.println(b.addFuel(100));
//        System.out.println(b);

//        String a = "HA01";
//        String b = a.substring(0, 2);
//        String c = a.substring(2, 4);
//        System.out.println(b.matches("[A-Z]{2}"));
//        System.out.println(c.matches("[0-9]{2}"));
//        int r = a.length();
//        System.out.println(r);
//
//        int c=1;
//        double b = c;
//        int a = (int) Math.ceil(b/20);
//        System.out.println(a);

//
//        Person person_1=new Person("philips","wang");
//        Person person_2=new Person("djstar","L");
//        Calendar calendar=Calendar.getInstance();
//        calendar.set(2011,2+1,3);
//        Date date_1=calendar.getTime();
//        DrivingLicence drivingLicence_1=new DrivingLicence(date_1,true);
//        DrivingLicence drivingLicence_2=new DrivingLicence(date_1,true);
//        Customer customer_1=new Customer(person_1,drivingLicence_1);
//        Customer customer_2=new Customer(person_2,drivingLicence_2);
//        System.out.println(customer_1.getThird_component());
//        System.out.println(customer_2.getThird_component());
//        Set<Customer> set=new HashSet<>();
//        set.add(customer_1);
//        set.add(customer_2);
//        System.out.println(set);

        final Car car_1 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG57HXE", 25);
        final Car car_2 = AbstractCarFactory.getInstance(AbstractCarFactory.SMALL_CAR, "NG57HXE", 20);
        Boolean a = (car_1 == car_2);
        System.out.println(a);
        System.out.println(car_1.getFirst_component());
        System.out.println(car_1.getCurrentLitres());
        System.out.println(car_1.isCarTankFull());
        System.out.println(car_1.getWholeLitresCapacity());
        System.out.println(car_1.getRegistrationNumber());
        System.out.println(car_1.driveCar(20));
        System.out.println(car_1.getCurrentLitres());
        System.out.println(car_1.addFuel(100));
        System.out.println(car_1.getCurrentLitres());
        System.out.println(car_1.getSecond_component());


    }


}
