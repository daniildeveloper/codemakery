package codemakery.adress.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates
 *
 * @author Lama
 */
public class DateUtil {

    /**
     * date pattern use for conversion
     */
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /**
     * the date formatter
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * return the given date as well formated string.The above defined
     * {@link DateUtil#DATE_TIME_FORMATTER} is used
     *
     * @param date the date to be returned as a String
     * @return formatted string
     */
    public static String formate(LocalDate date) {
        if (date == null) {
            return null;
        }

        return DATE_TIME_FORMATTER.format(date);
    }

    /**
     * Converts the string in dateformat
     *
     * @param dateString given string to parse
     * @return parsed LocalDate from string
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_TIME_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }

}
