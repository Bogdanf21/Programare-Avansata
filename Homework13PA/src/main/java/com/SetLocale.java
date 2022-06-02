package com;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {

    public static void commnad(Locale locale, ResourceBundle messages)
    {
        String pattern = messages.getString("locale.set");
        Object[] arguments = {locale};
        String text = new MessageFormat(pattern).format(arguments);
        System.out.println(text);
        Locale.setDefault(locale);
    }

}
