package Town.java;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.lang.reflect.Array;
import java.nio.channels.AlreadyConnectedException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Objects;

/**
 * Street: Has a length and name, has 2 ends that are an intersection (protected fields).
 * The intersections can be added to object street only in a City object.
 * A street can be instantiated, but only the City object can assign the ends to Street object when the City map is created
 *  (That's why the addEnd and getEnds functions are protected, can be accessed from the same package)
 */

public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection end0 = null;
    private Intersection end1 = null;

protected List<Intersection> getEnds()
{
    ArrayList<Intersection> temp = new ArrayList<>();
    temp.add(end0);
    temp.add(end1);
    return temp;
}

protected void addEnd(Intersection newEnd) throws KeyAlreadyExistsException
{
 if(end0 == null)
     end0 = newEnd;
 else if(end1 == null)
        end1 = newEnd;
 else throw new KeyAlreadyExistsException("Street " + this.name + "has already 2 ends attached: " + this.end0 + ", " + this.end1 + "\n tried to add " + newEnd);
}


    public Street(String name, int length)
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
        return name + " length: " + length + " | Connected with: " + end0 + " " + end1 + " ";
    }

    @Override
    public int compareTo(Street o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return length == street.length && name.equals(street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }
}
