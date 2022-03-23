package Town.java;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City {
    final private String name;
    private Map<Intersection, List<Street>> cityMap;
    private Set<Street> streetSet;

   public City(String name, Map<Intersection,List<Street>> cityMap)
    {
        this.name = name;
        this.cityMap = cityMap;
        streetSet = new HashSet<Street>();


        for(Map.Entry<Intersection,List<Street>> entry : cityMap.entrySet()) //see Street object documentation for the reason for this for
        {
            Intersection streetEndToBeAdded = entry.getKey();
            entry.getValue().stream().forEach(street -> {street.addEnd(streetEndToBeAdded);});
            streetSet.addAll(entry.getValue());
        }
        //add ends to streets
    }

    public void put(Intersection other, List<Street> streets)
    {
        cityMap.put(other,streets);
        streets.stream().forEach(street -> {street.addEnd(other);}); //see Street object documentation for the reason for this forEach
    }
    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void printStreetsWithDesiredProperty(int minLength)
    {
        System.out.println("Streets that are connected to at least 3 other streets and have length >= " + minLength + ":");
       streetSet.stream().filter(street -> {

            if(street.getLength() < minLength) return false;
            List<Intersection> theIntersectionsConnectedByThis = street.getEnds();

            int numberOfStreetsOnEnd0 = cityMap.get(theIntersectionsConnectedByThis.get(0)).size();
            int numberOfStreetsOnEnd1 = cityMap.get(theIntersectionsConnectedByThis.get(1)).size();
            if(numberOfStreetsOnEnd0 + numberOfStreetsOnEnd1 - 2 >=3) // ends - 2 because each intersection is connected to the current street
                return true;
            return false;
        }).forEach(street -> {
            System.out.println(street);
        });
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{\n");
       cityMap.forEach((intersection, streets) -> {
           sb.append("Intersection " + intersection.getName() + " connected to: ");
           streets.stream().forEach(street -> sb.append(" " + street.getName() + " "));
           sb.append("\n");
       });
       sb.append("}");
        return sb.toString();
    }
}
