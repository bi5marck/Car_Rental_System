package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 16:48
 */
public final class Customers {
    private final Person person;
    private final DrivingLicence drivingLicence;
    private String DrivingLicenceNumber;
    private String first_component;
    private String second_component;
    private String third_component;

    public Customers(Person person, DrivingLicence drivingLicence) {
        this.person = person;
        this.drivingLicence = drivingLicence;
    }


}
