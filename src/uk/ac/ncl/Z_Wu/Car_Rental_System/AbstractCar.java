package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/14 17:15
 */
public abstract class AbstractCar implements Car {

    private final CarRegistrationNumber r_number;
     Integer current_fuel_litres;

    AbstractCar(CarRegistrationNumber number, Integer current_fuel_litres) {
        this.r_number = new CarRegistrationNumber(number.getFirstComponent(),number.getSecondComponent());
        this.current_fuel_litres = current_fuel_litres;
    }

    public CarRegistrationNumber getRegistrationNumber() {
        return new CarRegistrationNumber(r_number.getFirstComponent(),r_number.getSecondComponent());
    }

    public Integer addFuel(Integer litres) {
        if(litres<0){
            throw new IllegalArgumentException("Litre can't be negative.");
        }
        else {
            Integer practical_add;
            if (current_fuel_litres == getWholeLitresCapacity()) {
                practical_add = 0;
            } else if (current_fuel_litres + litres > getWholeLitresCapacity()) {
                practical_add = getWholeLitresCapacity() - current_fuel_litres;
                current_fuel_litres = current_fuel_litres + practical_add;
            } else {
                current_fuel_litres = current_fuel_litres + litres;
                practical_add = litres;
            }
            return practical_add;
        }
    }

    public Integer getCurrentLitres() {
        return current_fuel_litres;
    }

    public boolean isCarTankFull() {
        return (getCurrentLitres() == getWholeLitresCapacity());
    }

    public String toString() {
        return "Registration Number: " + r_number + " Current Fuel: " + current_fuel_litres + "L";
    }


}
