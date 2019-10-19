package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: z.wu
 * Date: 2019/10/18 15:56
 */
public abstract class AbstractCarFactory implements Car {

    public final static String SMALL_CAR = "small";
    public final static String LARGE_CAR = "large";

    private final static Map<CarRegistrationNumber, Car> cars = new HashMap<>();
    private final CarRegistrationNumber carRegistrationNumber;
    private final String first_component;
    private final String second_component;
    int current_fuel_litres;

    AbstractCarFactory(String first_component, String second_component, int fuel) {
        this.first_component = first_component;
        this.second_component = second_component;
        this.current_fuel_litres = fuel;
        this.carRegistrationNumber = new CarRegistrationNumber(first_component, second_component);
    }

    public static Car getInstance(String type, String registrationNumber, int fuel) {
        String first_c = registrationNumber.substring(0, 4);
        String second_c = registrationNumber.substring(4, 7);
        CarRegistrationNumber cRN = new CarRegistrationNumber(first_c, second_c);
        Car car = cars.get(cRN);
        if (car != null)
            return car;

        if (type.equals(SMALL_CAR)) {
            car = new SmallCar(first_c, second_c, fuel);
        } else if (type.equals(LARGE_CAR)) {
            car = new LargeCar(first_c, second_c, fuel);
        } else {
            throw new IllegalArgumentException("Only have small cars and large cars.");
        }
        cars.put(cRN, car);
        return car;
    }

    public CarRegistrationNumber getRegistrationNumber() {
        return new CarRegistrationNumber(carRegistrationNumber.getFirstComponent(), carRegistrationNumber.getSecondComponent());
    }

    public Integer addFuel(Integer litres) {
        if (litres < 0) {
            throw new IllegalArgumentException("Litre can't be negative.");
        } else {
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

    public String getFirst_component() {
        return first_component;
    }

    public String getSecond_component() {
        return second_component;
    }

    public abstract Integer getWholeLitresCapacity();

    public abstract Integer driveCar(Integer KM);

    public String toString() {
        return "Registration Number: " + carRegistrationNumber + " Current Fuel: " + current_fuel_litres + "L";
    }

}
