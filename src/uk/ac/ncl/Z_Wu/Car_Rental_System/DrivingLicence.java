package uk.ac.ncl.Z_Wu.Car_Rental_System;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: z.wu
 * Date: 2019/10/17 16:49
 * This class is DrivingLicence class and used by {@link Customer}.
 */
final class DrivingLicence {
    private final Boolean isFullLicence;
    private final Date dateOfIssie;

    DrivingLicence(Date dateOfIssie, boolean isFullLicence) {
        if (dateOfIssie == null)
            throw new IllegalArgumentException("Data of driving licence issue is null.");
        this.dateOfIssie = dateOfIssie;
        this.isFullLicence = isFullLicence;
    }

    boolean isFullLicence() {
        return isFullLicence;
    }

    Date getDateOfIssie() {
        return (Date) dateOfIssie.clone();
    }

    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfIssie);
        //return dateOfIssie + " " + "This is full licence: " + isFullLicence;
        return calendar.get(Calendar.YEAR) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
