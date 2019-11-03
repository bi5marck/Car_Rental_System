package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: z.wu
 *
 * @since <pre>2019/10/18 15:56</pre>
 * This class implements {@link Car} and use {@link CarRegistrationNumber}.
 * It is also a factory class for different types of cars.
 */
public abstract class AbstractCarFactory implements Car {

    /**
     * Small car type.
     */
    public final static String SMALL_CAR = "small";

    /**
     * Large car type.
     */
    public final static String LARGE_CAR = "large";

    /**
     * A map of car registration number to instantiate car.
     */
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


    /**
     * This method is a factory of cars.
     *
     * @param type               is car's type(small or large)
     * @param registrationNumber is car's registration number.
     * @param fuel               is car's current fuel.
     * @return an instance of car with a unique registration number.
     * @throws IllegalArgumentException if car type and registration number is null.
     * @throws IllegalArgumentException if car registration number is duplicated.
     * @throws IllegalArgumentException if try to create more than 20 instances of
     *                                  <p>
     *                                  small car or more than 10 instances of large car.
     */
    public static Car getInstance(String type, String registrationNumber, int fuel) {
        if (registrationNumber.length() != 7)
            throw new IllegalArgumentException("Wrong length of registration number.");
        if (type.length() == 0) {
            throw new IllegalArgumentException("Car type is null.");
        }
        String first_c = registrationNumber.substring(0, 4);
        String second_c = registrationNumber.substring(4, 7);
        int i = 1;
        int j = 1;
        CarRegistrationNumber cRN = new CarRegistrationNumber(first_c, second_c);
        Car car = cars.get(cRN);
        if (car != null)
            return car;

        for (CarRegistrationNumber crn : cars.keySet()) {
            if (cars.get(crn).getType().equals(SMALL_CAR)) {
                i = i + 1;
            }
            if (cars.get(crn).getType().equals(LARGE_CAR)) {
                j = j + 1;
            }
            if (cars.get(crn).getRegistrationNumber().replaceAll(" ", "").equals(registrationNumber))
                throw new IllegalArgumentException("Car registration number is duplicated.");
        }
        if (type.equals(SMALL_CAR)) {
            if (i > 20) {
                throw new IllegalArgumentException("You can only creat 20 instances of small car.");
            } else {
                car = new SmallCar(first_c, second_c, fuel);
            }
        } else if (type.equals(LARGE_CAR)) {
            if (j > 10) {
                throw new IllegalArgumentException("You can only creat 10 instances of large car.");
            } else {
                car = new LargeCar(first_c, second_c, fuel);
            }
        } else {
            throw new IllegalArgumentException("Only have small cars and large cars.");
        }
        cars.put(cRN, car);
        return car;
    }

    /**
     * This method can return car's registration number.
     *
     * @return car's registration number in String type.
     */
    public String getRegistrationNumber() {
        CarRegistrationNumber a = new CarRegistrationNumber(carRegistrationNumber.getFirstComponent(), carRegistrationNumber.getSecondComponent());
        return a.getFirstComponent() + " " + a.getSecondComponent();
    }


    /**
     * This method can add fuel for a car.
     * If try to add more fuel than car's whole fuel tank capacity,
     * this method only add up to tank's capacity.
     *
     * @param litres is the Litre number of fuel to add for this car.
     * @return the practical fuel which is add to fuel tank.
     * @throws IllegalArgumentException if try to add a negative number of fuel.
     */
    public Integer addFuel(Integer litres) {
        if (litres < 0) {
            throw new IllegalArgumentException("Fuel value can't be negative.");
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

    public Boolean isCarTankFull() {
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

    public abstract String getType();

    public abstract void setRented(Boolean b);

    public String toString() {
        return "Car type: " + getType() + "\n" + "Registration Number: " + carRegistrationNumber + "\n"
                + "Current Fuel: " + current_fuel_litres + "L " + "\n";
    }

}
