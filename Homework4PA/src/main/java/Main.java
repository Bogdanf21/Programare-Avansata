import Town.java.Intersection;
import Town.java.Street;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[])
    {
        System.out.println("hello world");
        var intersections = IntStream.rangeClosed(0,3).mapToObj(i -> new Intersection("v" + i)).collect(Collectors.toList());
        List<Intersection> nodeList = new ArrayList<>();
        System.out.println(intersections);
        Map<Intersection,List<Street>> cityMap = new HashMap<>();
       



    }
}
