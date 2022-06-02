package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {

    public static void command(Locale locale, ResourceBundle messages)
    {

        String pattern = messages.getString("info");
        Object[] arguments = {locale.getDisplayCountry()};
        String text = new MessageFormat(pattern).format(arguments);
        System.out.println(text);

        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setCurrency(Currency.getInstance(locale));


        System.out.println("Currency: " + numberFormat.getCurrency().getDisplayName());


        DateFormatSymbols dfs = new DateFormatSymbols(Locale.getDefault());
        String weekdays[] = dfs.getWeekdays();

        Calendar cal = Calendar.getInstance(locale);

        System.out.print("Week Days: ");
        for(String dayOfWeek1: weekdays)
            System.out.print(dayOfWeek1 + " ");

        System.out.println();
        String months[] = dfs.getMonths();
        System.out.print("Months: ");
        for(String month: months)
            System.out.print(month+" ");


        System.out.println();
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        System.out.println("Today: " + today.format(formatter));

    }
}
