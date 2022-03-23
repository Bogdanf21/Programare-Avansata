import Town.java.City;
import Town.java.Intersection;
import Town.java.Street;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[])
    {
       Faker faker = new Faker();
        List<Intersection> intersections = IntStream.rangeClosed(0,9).mapToObj(i -> new Intersection(faker.name().lastName())).collect(Collectors.toList());
       Random rand = new Random();
       LinkedList<Street> streets = IntStream.rangeClosed(0,16)
                       .mapToObj(i -> new Street(faker.address().streetName(), rand.nextInt(1,10)))
                        .collect(Collectors.toCollection(LinkedList::new));

        streets.sort((Street a, Street b) -> {if(a.getLength() < b.getLength()) return -1; if(a.getLength() == b.getLength()) return 0; return 1;});
        //System.out.println(streets); //LINKED LIST FROM RANDOM STREETS THEN SORTED
        //System.out.println(intersections);

        Map<Intersection,List<Street>> cityMap = new HashMap<>();

        cityMap.put(intersections.get(1), Arrays.asList(streets.get(1),streets.get(2),streets.get(3)));
        cityMap.put(intersections.get(2),Arrays.asList(streets.get(1),streets.get(6),streets.get(4)));
        cityMap.put(intersections.get(3),Arrays.asList(streets.get(2),streets.get(4),streets.get(5),streets.get(7),streets.get(8)));
        cityMap.put(intersections.get(4),Arrays.asList(streets.get(3),streets.get(5),streets.get(16)));
        cityMap.put(intersections.get(5),Arrays.asList(streets.get(6),streets.get(9),streets.get(11),streets.get(10)));
        cityMap.put(intersections.get(6),Arrays.asList(streets.get(16),streets.get(8),streets.get(9),streets.get(14)));
        cityMap.put(intersections.get(7),Arrays.asList(streets.get(7),streets.get(12),streets.get(13)));
        cityMap.put(intersections.get(8),Arrays.asList(streets.get(10),streets.get(12),streets.get(15)));
        cityMap.put(intersections.get(9),Arrays.asList(streets.get(11),streets.get(13),streets.get(14),streets.get(15)));



        Set<Intersection> intersectionSet = new HashSet<>(intersections);
        intersectionSet.add(intersections.get(0));
        if(intersections.get(0) == intersections.get(1))
            System.out.println("\nSET PROPERTY VIOLATED\n");

        System.out.println("\n\n\n\n");

        City ourCity = new City("FIITown",cityMap);

        System.out.println(ourCity + "\n\n\n\n");
        ourCity.printStreetsWithDesiredProperty(7);


    }
}
