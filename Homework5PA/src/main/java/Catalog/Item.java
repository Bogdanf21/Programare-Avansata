package Catalog;

import java.util.Map;

public abstract class Item {
    protected String id;
    protected String title;
    protected String location;
    protected Map<String,String> properties;
    protected Item(Map<String,String> properties)
    {
        try{
        this.id = properties.get("id");
        properties.remove("id");
        this.location = properties.get("location");
        properties.remove("location");
        this.title = properties.get("title");
        properties.remove("title");
        this.properties = properties;}
        catch(Exception e){
            System.out.println(e.getMessage() + "\n");
            System.out.println(e.getCause() + "\n");
            System.out.println("One of the fields id, location, title not found");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }
}
