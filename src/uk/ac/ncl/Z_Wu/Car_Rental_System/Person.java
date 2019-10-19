package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 17:19
 */
public final class Person {
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth = new Date();

    public Person(String firstName, String lastName) {
        if (firstName.length() == 0)
            throw new IllegalArgumentException("First name is null.");
        this.firstName = firstName;
        if (lastName.length() == 0)
            throw new IllegalArgumentException("Last name id null.");
        this.lastName = lastName;
    }

     Date getDateOfBirth() {
        return (Date) dateOfBirth.clone();
    }

     String getFirstName() {
        return firstName;
    }

     String getLastName() {
        return lastName;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        final Person p = (Person) o;
        return firstName.equals(p.firstName) && lastName.equals(p.lastName);
    }

    public int hashCode() {
        int result = 31;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    public String toString() {
        return firstName + "" + lastName;
    }
}
