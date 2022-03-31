package Catalog.CommandInterfaces;

import Catalog.Catalog;
import Catalog.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class ViewCommand {
    static final String PATH = "C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\";
    public static void execute(Catalog catalog, String id) throws ItemNotFoundException {
        try {
            SaveCommand.execute(catalog, PATH + "catalog.json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //open with desktop
        try {

            Item item = catalog.findById(id);

            if (item == null) throw new ItemNotFoundException(new Exception());

            if (!Desktop.isDesktopSupported()) System.out.println("DESKTOP IS NOT SUPPORTED");

            Desktop desktop = Desktop.getDesktop();
            //BROWSER
            if (item.getLocation().contains("https://")) {
                if(!desktop.isSupported(Desktop.Action.BROWSE)) {System.out.println("BROWSER IS NOT SUPPORTED"); throw new BrowserException(new Exception());}
                desktop.browse(new URI(item.getLocation()));

            }
            else
            //LOCAL
            {
                File file = new File(item.getLocation());

                if (file.exists()) desktop.open(file);
                else System.out.println("FILE DOESN'T EXIST");
            }

        }   catch (ItemNotFoundException e) {
            throw new ItemNotFoundException(new Exception());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static class ItemNotFoundException extends Exception {
        public ItemNotFoundException(Exception ex) {
            super("Item not found in catalog (in physical memory).", ex);
        }
    }
    public static class BrowserException extends Exception {
        public BrowserException(Exception ex) {
            super("Browser cannot be accessed", ex);
        }
    }
}
