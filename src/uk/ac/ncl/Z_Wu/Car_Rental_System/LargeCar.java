package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/18 16:59
 */
public class LargeCar extends AbstractCarFactory {

    private final static Integer whole_litres_capacity = 60;

    public LargeCar(String first_component, String second_component, int fuel) {
        super(first_component, second_component,fuel);
    }

    public Integer getWholeLitresCapacity() {
        return whole_litres_capacity;
    }

    public Integer driveCar(Integer KM) {
        boolean isTankEmpty;
        double km=KM;
        if (KM >= 0 && KM <= 5 * 10 + 55 * 15) {
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
                if (km <= 50) {
                    fuel_consumed = (int) Math.ceil(km / 10);
                    current_fuel_litres = current_fuel_litres - fuel_consumed;
                    return fuel_consumed;
                } else {
                    fuel_consumed = 5 + (int) Math.ceil((km - 50) / 15);
                    current_fuel_litres = current_fuel_litres - fuel_consumed;
                    return fuel_consumed;
                }
            }
        } else {
            throw new IllegalArgumentException("Please enter the right kilometres number.(0 or 875");
        }
    }
}

