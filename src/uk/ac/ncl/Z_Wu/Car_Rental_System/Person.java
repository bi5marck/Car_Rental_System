package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 17:19
 * This class is person class and used by {@link Customer}.
 */
final class Person {
    private final String firstName;
    private final String lastName;
    private Date dateOfBirth;

    /**
     * Set first name and last name.
     *
     * @param firstName is person's first name.
     * @param lastName  is person's last name.
     * @throws IllegalArgumentException if first name or last name is null.
     *                                  <p>
     *                                  This method also set person's default date of birth as 1970.1.1
     */

    Person(String firstName, String lastName) {
        if (firstName.length() == 0)
            throw new IllegalArgumentException("First name is null.");
        this.firstName = firstName;
        if (lastName.length() == 0)
            throw new IllegalArgumentException("Last name is null.");
        this.lastName = lastName;

        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 1, 1);
        this.dateOfBirth = calendar.getTime();
    }

    /**
     * This method can set person's date of birth.
     * Person's default date of birth as 1970.1.1 and it can be
     * reset by this method.
     *
     * @param date is a object of person's new date of birth.
     */
    void setDateOfBirth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.dateOfBirth = calendar.getTime();
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

    /**
     * Override equals() and hashcode() method so that
     * person who has the same name and date of birth
     * will be considered as one person.
     */
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
        return firstName + " " + lastName;
    }
}
