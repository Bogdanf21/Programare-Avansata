package Catalog.CommandInterfaces;

import Catalog.Catalog;
import Catalog.Item;
import java.util.ArrayList;

public class AddCommand implements Command {
    Catalog catalog;
    Item item = null;
    ArrayList<Item> itemArrayList = null;
    public AddCommand(Catalog catalog, Item item)
    {
        this.catalog = catalog;
        this.item = item;
    }
   public AddCommand(Catalog catalog, ArrayList<Item> itemArrayList)
    {
        this.catalog = catalog;
        this.itemArrayList = itemArrayList;
    }

    public void execute() {
        if(item == null)
            itemArrayList.forEach(i -> addOneItem(i));
        else
            catalog.getCatalog().add(item);
    }

   public void addOneItem(Item i) {
        this.catalog.getCatalog().add(i);
   }
}

