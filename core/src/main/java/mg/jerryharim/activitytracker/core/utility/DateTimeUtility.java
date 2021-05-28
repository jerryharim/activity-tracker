package mg.jerryharim.activitytracker.core.utility;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtility {

    public static LocalTime toHourOfDay(String timeToParse) {
        return LocalTime.parse(timeToParse, DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * The format of dateToParse must like this : dd-MM-yyy
     * @param dateToParse
     * @return LocaDate
     */
    public static LocalDate toDayMonthYear(String dateToParse) {
        return LocalDate.parse(dateToParse, DateTimeFormatter.ofPattern("dd-MM-yyy"));
    }

}
