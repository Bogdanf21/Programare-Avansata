package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleExplore {

    public static void main(String[] args) {
        String baseName = "res.Messages";
        ResourceBundle messages =
                ResourceBundle.getBundle(baseName, Locale.getDefault());
        boolean isRunning=true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command=null;
        while(isRunning) {
            System.out.println(messages.getString("prompt"));
            try {
                command=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String [] split = command.split("\\s+");
            switch (split[0])
            {
                case "info":
                    Info.command(Locale.forLanguageTag(split[1]),messages);
                    break;
                case "locales":
                    DisplayLocales.command(Locale.getDefault(),messages);
                    break;
                case "locale.set":
                    SetLocale.commnad(Locale.forLanguageTag(split[1]),messages);
                    messages = ResourceBundle.getBundle(baseName, Locale.getDefault());
                    break;
                case "exit":
                    isRunning=false;
                    break;
                default:
                    System.out.println(messages.getString("invalid"));
                    break;
            }
        }

    }

}


