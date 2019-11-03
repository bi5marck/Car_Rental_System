package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/18 16:55
 * This class extends {@link AbstractCarFactory}.
 */
final class SmallCar extends AbstractCarFactory {

    private Boolean isRented = false;

    /**
     * Small car's whole litres capacity.
     */
    private final static Integer whole_litres_capacity = 49;

    /**
     * Small car's type.
     */
    private final static String Car_Type = "small";

    SmallCar(String first_component, String second_component, int fuel) {
        super(first_component, second_component, fuel);
        if (fuel > whole_litres_capacity)
            throw new IllegalArgumentException("Small car's whole litres capacity is 49.");
    }

    public Integer getWholeLitresCapacity() {
        return whole_litres_capacity;
    }

    /**
     * This method can drive a car for a given number of kilometres.
     *
     * @param KM is the given number of kilometres.
     * @return the number of whole litres of fuel consumed during journey
     * and all journey require partial litre will need a whole additional
     * Litre in this method. If car's tank is empty or this car is not currently
     * rented, it will return 0.
     */
    public Integer driveCar(Integer KM) {
        boolean isTankEmpty;
        double km = KM;
        if (KM >= 0 && KM <= 20 * whole_litres_capacity) {
            Integer fuel_consumed;
            if (getCurrentLitres() <= 0) {
                isTankEmpty = true;
            } else {
                isTankEmpty = false;
            }
            if (isTankEmpty) {
                System.out.println("You can't drive this car because it's tank is empty, no journey has been undertaken. ( "
                        + this.getRegistrationNumber() + " ).");
                return 0;
            } else if (!isRented) {
                System.out.println("You can't drive this car because it's tank is empty, no journey has been undertaken. ( "
                        + this.getRegistrationNumber() + " ).");
                return 0;
            } else {
                fuel_consumed = (int) Math.ceil(km / 20);
                current_fuel_litres = current_fuel_litres - fuel_consumed;
                return fuel_consumed;
            }
        } else {
            throw new IllegalArgumentException("Please enter the right kilometres number.(0 - 980");
        }
    }

    public String getType() {
        return Car_Type;
    }

    public void setRented(Boolean b) {
        this.isRented = b;
    }

}

