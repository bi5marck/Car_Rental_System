package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/14 16:42
 */
public interface Car {

CarRegistrationNumber getRegistrationNumber();

Integer getWholeLitresCapacity();

Integer getCurrentLitres();

boolean isCarTankFull();

Integer addFuel(Integer litres);

Integer driveCar(Integer KM);

String getFirst_component();

String getSecond_component();

}
