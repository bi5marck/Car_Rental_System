package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/15 22:11
 */
public final class CarRegistrationNumber {

    private String first_component;
    private String second_component;

    public CarRegistrationNumber(String first_component, String second_component) {
        setFirstComponent(first_component);
        setSecondComponent(second_component);
    }

     String getFirstComponent() {
        return first_component;
    }

     String getSecondComponent() {
        return second_component;
    }

    private void setFirstComponent(String first_component) {
        if (first_component.length() == 4) {
            String letters = first_component.substring(0, 2);
            String digits = first_component.substring(2, 4);
            if (letters.matches("[A-Z]{2}") && digits.matches("[0-9]{2}")) {
                this.first_component = first_component;
            } else {
                throw new IllegalArgumentException("Wrong format.");
            }
        } else {
            throw new IllegalArgumentException("Wrong format.");
        }
    }

    private void setSecondComponent(String second_component) {
        if (second_component.length() == 3) {
            if (second_component.matches("[A-Z]{3}")) {
                this.second_component = second_component;
            } else {
                throw new IllegalArgumentException("Wrong format.");
            }
        } else {
            throw new IllegalArgumentException("Wrong format.");
        }
    }

    public String toString() {
        return first_component + " " + second_component;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarRegistrationNumber)) {
            return false;
        }
        final CarRegistrationNumber car = (CarRegistrationNumber) o;
        return first_component.equals(car.first_component) && second_component.equals(car.second_component);
    }

    public int hashCode() {
        int result = 31;
        result = 31 * result + first_component.hashCode();
        result = 31 * result + second_component.hashCode();
        return result;
    }

}
