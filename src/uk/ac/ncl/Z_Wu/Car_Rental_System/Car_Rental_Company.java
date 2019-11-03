package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.*;

/**
 * Author: z.wu
 * Date: 2019/10/19 19:41
 * This class uses instances of {@link AbstractCarFactory} and {@link Customer}.
 * Before use this class, you need some instances of {@link AbstractCarFactory} and {@link Customer}
 * and a HashMap which stores all your instances of {@link AbstractCarFactory}.
 */
public class Car_Rental_Company {

    private Map<Car, Boolean> CarBooleanMap;
    private Map<Customer, Car> CarCustomerMap = new HashMap<>();

    /**
     * The constructor needs all company's instances of cars.
     *
     * @param carBooleanMap is a HashMap which saves all company's
     *                      cars and their rental state.
     * @throws IllegalArgumentException if HashMap is null.
     */
    public Car_Rental_Company(Map<Car, Boolean> carBooleanMap) {
        if (carBooleanMap == null)
            throw new IllegalArgumentException("Car rental map is null.");
        this.CarBooleanMap = carBooleanMap;
    }

    /**
     * The method can get the number of cars of the specified type that are available to be rented.
     *
     * @param type is the car type.
     * @return the he number of cars of the specified type that are available to be rented.
     * @throws IllegalArgumentException if car type is neither "small" nor "large".
     */
    public int availableCars(String type) {
        int number = 0;
        if (type.equals("small")) {
            for (Car car : CarBooleanMap.keySet()) {
                if (CarBooleanMap.get(car) && car.getType().equals("small"))
                    number = number + 1;
            }
        } else if (type.equals("large")) {
            for (Car car : CarBooleanMap.keySet()) {
                if (CarBooleanMap.get(car) && car.getType().equals("large"))
                    number = number + 1;
            }
        } else {
            throw new IllegalArgumentException("Please enter \"small\" or \"large\".");
        }
        return number;
    }

    /**
     * The method can get a collection of all the cars currently rented.
     *
     * @return a HashSet which contains all the cars currently rented.
     */
    public Set<Car> getRentedCars() {
        Set<Car> rentedCars = new HashSet<>();
        for (Car car : CarBooleanMap.keySet()) {
            if (!CarBooleanMap.get(car))
                rentedCars.add(car);
        }
        return rentedCars;
    }

    /**
     * The method can get a car which is rented by a given customer.
     *
     * @param customer is the given customer.
     * @return a car which is rented by a given customer.
     */
    public Car getCar(Customer customer) {
        return CarCustomerMap.get(customer);
    }

    /**
     * The method issue a specific car for given customer.
     * It will determines if given customer is eligible to rent a car if there are available cars.
     * Customer must have a full licence to rent a car.
     * Customer can't rent more than one car at a time.
     * Customer must be 20 years old and held licence for more than 1 year to rent a small car.
     * Customer must be 25 years old and held licence for more than 5 year to rent a small car.
     *
     * @param customer  is the object of given customer.
     * @param typeOfCar is the car type customer wants.
     * @return if car can be issued.
     * @throws IllegalArgumentException if car type is neither "small" nor "large".
     */
    public Boolean issueCar(Customer customer, String typeOfCar) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar_dob = Calendar.getInstance();
        Date date_dob = customer.getCustomersDobObj();
        calendar_dob.setTime(date_dob);
        int age = calendar.get(Calendar.YEAR) - calendar_dob.get(Calendar.YEAR);
        int hold_year = calendar.get(Calendar.YEAR) - Integer.valueOf(customer.getSecond_component());

        if (typeOfCar.equals("small")) {
            if (availableCars(typeOfCar) > 0 && customer.isFullLicence()
                    && getCar(customer) == null && age >= 20 && hold_year >= 1) {  //get a car from CarBooleanMap and put it in CarCustomerMap
                for (Car car : CarBooleanMap.keySet()) {
                    if (CarBooleanMap.get(car) && car.getType().equals("small")) {
                        CarBooleanMap.put(car, false);
                        CarCustomerMap.put(customer, car);
                        car.setRented(true);
                        if (!car.isCarTankFull()) {
                            car.addFuel(car.getWholeLitresCapacity() - car.getCurrentLitres());
                        }
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (typeOfCar.equals("large")) {
            if (availableCars(typeOfCar) > 0 && customer.isFullLicence()
                    && getCar(customer) == null && age >= 25 && hold_year >= 5) {   //get a car from CarBooleanMap and put it in CarCustomerMap
                for (Car car : CarBooleanMap.keySet()) {
                    if (CarBooleanMap.get(car) && car.getType().equals("large")) {
                        CarBooleanMap.put(car, false);
                        CarCustomerMap.put(customer, car);
                        car.setRented(true);
                        if (!car.isCarTankFull()) {
                            car.addFuel(car.getWholeLitresCapacity() - car.getCurrentLitres());
                        }
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("You can only issue small car or large car.");
        }

    }

    /**
     * The method can terminate given customer's rental contract.
     * It removes the record of rental from system so that this car can be rented again
     * and it also returns the amount of fuel need to fill car's tank.
     *
     * @param customer is the given customer.
     * @return the amount of fuel need to fill car's tank.
     */
    public int terminateRental(Customer customer) {
        int fuel_needed = 0;

        Iterator<Map.Entry<Customer, Car>> it = CarCustomerMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Customer, Car> entry = it.next();
            if (entry.getKey().equals(customer)) {
                CarBooleanMap.put(getCar(customer), true);
                getCar(customer).setRented(false);
                fuel_needed = getCar(customer).getWholeLitresCapacity() - getCar(customer).getCurrentLitres();
                it.remove();
                break;
            }
        }
        return fuel_needed;
    }

}
