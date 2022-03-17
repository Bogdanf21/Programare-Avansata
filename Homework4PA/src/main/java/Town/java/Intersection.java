package Town.java;

public class Intersection implements Comparable<Intersection> {
    private String name;
    public Intersection(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
      return "Intersection " + name;
    }

    @Override
    public int compareTo(Intersection o) {
        return this.name.compareTo(o.getName());
    }
}
