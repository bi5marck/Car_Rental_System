package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 16:48
 * This method is Customer class and it uses {@link DrivingLicence} and {@link Person}.
 */
public final class Customer {
    private final Person person;
    private final DrivingLicence drivingLicence;
    private String first_component;
    private String second_component;
    private final String third_component;
    private final String first_name;
    private final String last_name;
    private final Boolean isFullLicence;

    /**
     * This is the constructor of Customer class.
     *
     * @param first_name      is customer's first name.
     * @param last_name       is customer's last name.
     * @param dateOfIssie     is date object of customer's driving licence's issue date.
     * @param isFullLicence   is if customer's driving licence is a full licence.
     * @param third_component is customer's driving licence's third component.
     * @throws IllegalArgumentException if third component is not 2 digits.
     */
    public Customer(String first_name, String last_name, Date dateOfIssie, Boolean isFullLicence, String third_component) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.isFullLicence = isFullLicence;
        if ((third_component.length() != 2) && (third_component.matches("[0-9]{2}"))) {
            throw new IllegalArgumentException("Third component of driving licence must be 2 numbers.");
        }
        this.third_component = third_component;
        this.person = new Person(this.first_name, this.last_name);
        this.drivingLicence = new DrivingLicence(dateOfIssie, this.isFullLicence);
        setFirst_component();
        setSecond_component();
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

    public void setCustomersDob(Date date) {
        person.setDateOfBirth(date);
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

    /**
     * This method can get customer's driving licence's issue date.
     *
     * @return the String type of customer's driving licence's issue date.
     */
    public String getDrivingLicenceIssueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) drivingLicence.getDateOfIssie().clone());
        return calendar.get(Calendar.YEAR) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public String getCustomersName() {
        return person.getFirstName() + " " + person.getLastName();
    }

    public String getCustomersDob() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) person.getDateOfBirth().clone());
        return calendar.get(Calendar.YEAR) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.DAY_OF_MONTH);
    }

    Date getCustomersDobObj() {
        return (Date) person.getDateOfBirth().clone();
    }

    /**
     * Override equals() and hashcode() method so that
     * customers who has the same name and date of birth
     * will be considered as the same one.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        final Customer customer = (Customer) o;
        return person.equals(customer.person)
                && first_name.equals(customer.first_name)
                && last_name.equals(customer.last_name);
    }

    public int hashCode() {
        int result = 31;
        ;
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        return result;
    }


    public String toString() {
        return "Customer's name: " + getCustomersName() + "\n"
                + "Customer's date of birth: " + getCustomersDob() + "\n"
                + "Customer's driving licence number; " + getDrivingLicenceNumber() + "\n"
                + "Is full licence: " + isFullLicence + "\n"
                + "Issue date of licence: " + getDrivingLicenceIssueDate() + "\n";
    }
}
