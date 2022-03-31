package Catalog.CommandInterfaces.ConceptRelated;

import Catalog.Catalog;
import Catalog.CommandInterfaces.Command;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddRandomConcepts implements Command {
    public static Catalog execute(Catalog catalog) {

        Faker faker = new Faker();
        Random rand = new Random();
        List<String> randomConcepts =
                IntStream.rangeClosed(0,15)
                        .mapToObj(i -> faker.name().title())
                        .collect(Collectors.toSet())
                        .stream()
                        .collect(Collectors.toCollection(ArrayList::new));
        catalog.setAllConcepts(randomConcepts);

        catalog.getCatalog().forEach(
                catalogItem -> {
                    int noOfConcepts = rand.nextInt(1,7);
                    for (int i = 0; i < noOfConcepts; i++) {
                        catalogItem.addConcept(
                                randomConcepts.get(
                                        rand.nextInt(0, randomConcepts.size())
                                )
                        );
                    }
                }
        );
        return catalog;
    }
}
