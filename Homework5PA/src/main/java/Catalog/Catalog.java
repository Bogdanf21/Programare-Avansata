package Catalog;

import java.util.ArrayList;

public class Catalog {
   private ArrayList<Item> catalog = new ArrayList<Item>();

   public Catalog(){};
   public Catalog(ArrayList<Item> catalog)
   {
       this.catalog = catalog;
   }

    public ArrayList<Item> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Item> catalog) {
        this.catalog = catalog;
    }

    public Item findById(String id) {
        Item item =  catalog.stream()
                .filter(item1 -> item1.getId().equals(id))
                .findAny()
                .orElse(null);
        return item;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Catalog{");
        sb.append("catalog=").append(catalog);
        sb.append('}');
        return sb.toString();
    }
}
