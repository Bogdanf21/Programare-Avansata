package Catalog.CommandInterfaces;

import Catalog.Catalog;
import Catalog.Item;
import java.util.ArrayList;

public class AddCommand {
    public static void execute(Catalog catalog, Item item) {
        catalog.getCatalog().add(item);
    }

    public static void execute(Catalog catalog, ArrayList<Item> items) {
        items.forEach(item -> execute(catalog,item));
    }
}
