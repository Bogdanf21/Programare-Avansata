package Catalog.CommandInterfaces;

import Catalog.Catalog;
import Catalog.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class CatalogUtil {
    static final String PATH = "C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\";


    public void list(Catalog c) {
        StringBuilder builder = new StringBuilder();
        c.getCatalog().forEach(i -> {
                    builder.append("Type = ").append(String.valueOf(i)).append(" ID = ").append(i.getId());
                    builder.append(" Title = ").append(i.getLocation());
                    builder.append(" Location = ").append(i.getLocation());
                    builder.append("\n");
                    builder.append(i.getProperties());
                    builder.append("\n");
                }
        );
        System.out.println(builder);
    }

    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path), catalog);
    }

    public static Catalog load(String path) throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static void add(Catalog catalog, Item item) {
        catalog.getCatalog().add(item);
    }

    public static void add(Catalog catalog, ArrayList<Item> items) {
        items.forEach(item -> CatalogUtil.add(catalog,item));
    }


    public static void view(Catalog catalog, String id) throws ItemNotFoundException {
        try {
            CatalogUtil.save(catalog, PATH + "catalog.json");
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
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
