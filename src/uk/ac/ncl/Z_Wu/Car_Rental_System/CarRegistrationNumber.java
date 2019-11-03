package uk.ac.ncl.Z_Wu.Car_Rental_System;

/**
 * Author: z.wu
 * Date: 2019/10/15 22:11
 * This class is car's registration number class and used by {@link AbstractCarFactory}.
 */
public final class CarRegistrationNumber {

    private String first_component;
    private String second_component;

    CarRegistrationNumber(String first_component, String second_component) {
        setFirstComponent(first_component);
        setSecondComponent(second_component);
    }

    /**
     * This method can get first component of car's registration number.
     *
     * @return the first component of car's registration number.
     */
    String getFirstComponent() {
        return first_component;
    }

    /**
     * This method can get second component of car's registration number.
     *
     * @return the second component of car's registration number.
     */
    String getSecondComponent() {
        return second_component;
    }

    /**
     * This method sets first component of car's registration number.
     *
     * @param first_component is the first component of car's registration number.
     * @throws IllegalArgumentException if first component is not the form of
     *                                  two letters followed by two digits.
     */
    private void setFirstComponent(String first_component) {
        String letters = first_component.substring(0, 2);
        String digits = first_component.substring(2, 4);
        if (letters.matches("[A-Z]{2}") && digits.matches("[0-9]{2}")) {
            this.first_component = first_component;
        } else {
            throw new IllegalArgumentException("Wrong format.");
        }
    }

    /**
     * This method sets second component of car's registration number.
     *
     * @param second_component is the second component of car's registration number.
     * @throws IllegalArgumentException if second component is not the form of
     *                                  three letters.
     */
    private void setSecondComponent(String second_component) {
        if (second_component.matches("[A-Z]{3}")) {
            this.second_component = second_component;
        } else {
            throw new IllegalArgumentException("Wrong format.");
        }

    }

    public String toString() {
        return first_component + " " + second_component;
    }

}
