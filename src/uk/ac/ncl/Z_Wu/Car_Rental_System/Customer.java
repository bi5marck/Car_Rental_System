package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 16:48
 */
public final class Customer {
    private final Person person;
    private final DrivingLicence drivingLicence;
    private String first_component;
    private String second_component;
    private String third_component;

    public Customer(Person person, DrivingLicence drivingLicence) {
        this.person = person;
        this.drivingLicence = drivingLicence;
        setFirst_component();
        setSecond_component();
        setThird_component();

    }

    private void setFirst_component() {
        this.first_component = person.getFirstName().substring(0, 1).toUpperCase() +
                person.getLastName().substring(0, 1).toUpperCase();
    }

    private void setSecond_component() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(drivingLicence.getDateOfIssie());
        this.second_component = String.valueOf(calendar.get(Calendar.YEAR));
    }

    private void setThird_component() {
        this.third_component = drivingLicence.getThird_component();
    }

    public String getFirst_component() {
        return first_component;
    }

    public String getSecond_component() {
        return second_component;
    }

    public String getThird_component() {
        return third_component;
    }

    public String getDrivingLicenceNumber() {
        return first_component + "-" + second_component + "-" + third_component;
    }

    public boolean isFullLicence() {
        return drivingLicence.isFullLicence();
    }

    public Date getDrivingLicenceIssueDate() {
        return (Date) drivingLicence.getDateOfIssie().clone();
    }

    public String getCustomersName() {
        return person.getFirstName() + " " + person.getLastName();
    }

    public Date getCustomersDob() {
        return (Date) person.getDateOfBirth().clone();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        final Customer customer = (Customer) o;
        return person.equals(customer.person)
                && drivingLicence.equals(customer.drivingLicence)
                && first_component.equals(customer.first_component)
                && second_component.equals(customer.second_component)
                && third_component.equals(customer.third_component);
    }

    public int hashCode() {
        int result = 31;
        result = 31 * result + person.hashCode();
        result = 31 * result + drivingLicence.hashCode();
        result = 31 * result + first_component.hashCode();
        result = 31 * result + second_component.hashCode();
        result = 31 * result + third_component.hashCode();
        return result;
    }


    public String toString() {
        return "Customer's name: " + getCustomersName() + "\n"
                + "Customer's date of birth: " + getCustomersDob() + "\n"
                + "Customer's driving licence number; " + getDrivingLicenceNumber() + "\n"
                + "Is full licence: " + isFullLicence() + "\n"
                + "Issue date of licence: " + getDrivingLicenceIssueDate() + "\n";
    }
}
