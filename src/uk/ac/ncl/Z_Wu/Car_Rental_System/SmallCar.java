package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/18 16:55
 */
public class SmallCar extends AbstractCarFactory {

    private final static Integer whole_litres_capacity = 49;

    public SmallCar(String first_component, String second_component, int fuel) {
        super(first_component, second_component, fuel);
    }

    public Integer getWholeLitresCapacity() {
        return whole_litres_capacity;
    }

    public Integer driveCar(Integer KM) {
        boolean isTankEmpty;
        double km = KM;
        if (KM >= 0 || KM <= 20 * whole_litres_capacity) {
            Integer fuel_consumed;
            if (getCurrentLitres() <= 0) {
                isTankEmpty = true;
            } else {
                isTankEmpty = false;
            }

            if (isTankEmpty) {
                System.out.println("You can't drive this car because it's tank is empty, please add fuel.");
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

}

