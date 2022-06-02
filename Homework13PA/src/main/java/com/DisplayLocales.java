package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {

    public static void command(Locale l, ResourceBundle messages)
    {

        System.out.println(messages.getString("locales"));
        Locale available[] = l.getAvailableLocales();
        String s;
        for(Locale locale : available) {
            s = locale.getDisplayCountry() + "\t" +
                    locale.getDisplayLanguage(locale);
            System.out.println(s);
        }
    }
}
