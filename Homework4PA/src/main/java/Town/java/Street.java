package Town.java;

public class Street implements Comparable<Street> {
    private String name;
    private int length;


   public Street(String name,int length)
    {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "length: " + length;
    }

    @Override
    public int compareTo(Street o) {
        return this.name.compareTo(o.getName());
    }
}
