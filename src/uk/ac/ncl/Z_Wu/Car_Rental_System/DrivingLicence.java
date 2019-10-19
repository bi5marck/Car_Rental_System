package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Date;
import java.util.Random;

/**
 * Author: z.wu
 * Date: 2019/10/17 16:49
 */
public final class DrivingLicence {
    private boolean isFullLicence;
    private final Date dateOfIssie;
    private String third_component;


    public DrivingLicence(Date dateOfIssie, boolean isFullLicence) {
        if (dateOfIssie == null)
            throw new IllegalArgumentException("Data of driving licence issue is null.");
        this.dateOfIssie = dateOfIssie;
        this.isFullLicence = isFullLicence;
        setThird_component();
    }

     private void setThird_component(){
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        this.third_component = A + B;
    }

    String getThird_component(){
        return this.third_component;
    }

     boolean isFullLicence() {
        return isFullLicence;
    }

     Date getDateOfIssie() {
        return (Date) dateOfIssie.clone();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DrivingLicence)) {
            return false;
        }
        final DrivingLicence d = (DrivingLicence) o;
        return third_component.equals(d.third_component)
                && dateOfIssie.equals(d.dateOfIssie)
                &&(isFullLicence==d.isFullLicence);
    }

    public int hashCode() {
        int result = 31;
        result = 31 * result + dateOfIssie.hashCode();
        result = 31 * result + third_component.hashCode();
        return result;
    }
}
