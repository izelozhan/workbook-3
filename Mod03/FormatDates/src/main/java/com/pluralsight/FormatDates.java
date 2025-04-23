package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime rightNow = LocalDateTime.now();
        String input = "5:02 on 05-Sep-2021";


        //  Month/Day/Year
        DateTimeFormatter mdyFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String mdyFormattedDate = today.format(mdyFormat);
        System.out.println("Today is (Month/Day/Year): " + mdyFormattedDate);

        // Year-Month-Day
        System.out.println("Today is: " + today);

        //Month(String) Day, Year
        //MMMM dd, yyyy
        DateTimeFormatter stringMonthFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String stringMonthFormattedDate = today.format(stringMonthFormat);
        System.out.println("Today is (Month Day, Year): " + stringMonthFormattedDate);

        //Day(String), Month(3 letter) Day, Year Hour(GMT TIME)
        //EEEE, MMM dd, yyyy
        DateTimeFormatter dayMonthFormat = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm");
        String gmtFormattedDate = rightNow.format(dayMonthFormat);
        System.out.println("Today is (Day(String), Month(3 letter) Day, Year Hour(GMT TIME): " + gmtFormattedDate);
    }

}

