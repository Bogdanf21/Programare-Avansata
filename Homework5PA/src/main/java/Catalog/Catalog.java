package Catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
   private ArrayList<Item> catalog = new ArrayList<Item>();
   private List<String> allConcepts = new ArrayList<>();

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

    public List<String> getAllConcepts() {
        return allConcepts;
    }

    public void setAllConcepts(List<String> allConcepts) {
        this.allConcepts = allConcepts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Catalog{");
        sb.append("catalog=").append(catalog);
        sb.append('}');
        return sb.toString();
    }

}
