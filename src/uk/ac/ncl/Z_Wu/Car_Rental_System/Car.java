package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * @author z.wu
 * @since <pre>2019/10/14 16:42</pre>
 * This interface contains all the methods which car can use.
 */
public interface Car {

    /**
     * This method returns car's registration number.
     *
     * @return a String object contains car's registration number.
     */
    String getRegistrationNumber();


    /**
     * This method returns car's whole liters capacity of fuel tank.
     *
     * @return a car's whole liters capacity of fuel tank.
     */
    Integer getWholeLitresCapacity();


    /**
     * This method returns car's current liters capacity in fuel tank.
     *
     * @return a car's current liters capacity in fuel tank.
     */
    Integer getCurrentLitres();


    /**
     * This method returns if car's fuel tank is full.
     *
     * @return a boolean value which indicates if this car's fuel tank is full.
     */
    Boolean isCarTankFull();


    /**
     * This method adds a given number of litres to car's fuel tank(up to tank's capacity)
     * and return how much fuel is added.
     *
     * @param litres is the given number of fuel litres.
     * @return the number of fuel which is added to car's tank practically.
     */
    Integer addFuel(Integer litres);


    /**
     * This method can drive car for a given number of kilometers
     * and return the number of fuel which is consumed during journey.
     *
     * @param KM is the given number of kilometers this car should drive.
     * @return the number of fuel which is consumed during journey.
     */
    Integer driveCar(Integer KM);


    /**
     * This method can get the first component of car's registration number.
     *
     * @return the first component of car's registration number.
     */
    String getFirst_component();


    /**
     * This method can get the second component of car's registration number.
     *
     * @return the second component of car's registration number.
     */
    String getSecond_component();


    /**
     * This method can get the type of current car(small car or large car).
     *
     * @return the type of current car.
     */
    String getType();


    /**
     * This method sets current car's state in {@link Car_Rental_Company}.
     * <p>This method sets current car's state as true when it is issued so that it can be driven.<br>
     * It also sets current car's state as false when it's rental contract is terminated so that it can't be driven any more.
     *
     * @param b should be true if this car is rented.
     */
    void setRented(Boolean b);
}
