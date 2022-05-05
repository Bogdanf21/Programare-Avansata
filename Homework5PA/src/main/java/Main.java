import Catalog.Catalog;
import Catalog.CommandInterfaces.*;
import Catalog.CommandInterfaces.ConceptRelated.AddRandomConcepts;
import Catalog.CommandInterfaces.ConceptRelated.ReportCommand;
import Catalog.Item;
import Catalog.ItemTypes.Book;
import com.github.javafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static final String PATH = "C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\";
    public static void main(String[] args) throws LoadCommand.InvalidCatalogException, IOException {
        Faker faker = new Faker();

        Map<String,String> m1 = new HashMap<>();
        m1.put("id","knuth67");
        m1.put("title","The Art of Computer Programming");
        m1.put("location", PATH + "tacp.txt");
        m1.put( "year","1967");
        m1.put( "author","Donald E. Knuth");
        m1.put( "type","book");

        Map<String,String> m2 = new HashMap<>();
        m2.put("id","java17");
        m2.put("title","The Java Language Specification");
        m2.put("location","https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        m2.put( "year","2021");
        m2.put( "author","James Gosling & others");
        m2.put( "type","book");
        Item i1 = new Book(m1);
        Item i2 = new Book(m2);

       Catalog catalog = new Catalog();
       Command add = new AddCommand(catalog,
               new ArrayList<Item>() {{add(i1); add(i2);}});
        add.execute();


        ArrayList<Item> fakeItems = IntStream.rangeClosed(0,9).
                mapToObj(i -> new Book(
                        Stream.of(new String[][] {
                                {"id",faker.idNumber().valid()},
                                {"title",faker.name().title()},
                                {"location","https://" + faker.company().url()},
                                {"year", String.valueOf(faker.number().numberBetween(1980,2021))},
                        }).collect(Collectors.toMap( data -> data[0], data -> data[1]))
                )).collect(Collectors.toCollection(ArrayList::new));

        add = new AddCommand(catalog, fakeItems);
        add.execute();


        try {
            Command save = new SaveCommand(catalog, PATH + "catalog.json");
            save.execute();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } catch (LoadCommand.InvalidCatalogException e) {
            e.printStackTrace();
        }



       // Command view = new ViewCommand(catalog, "knuth67");
       // view.execute();
        view = new ViewCommand(catalog, "java17");
        view.execute();


        AddRandomConcepts a = new AddRandomConcepts(catalog);
        catalog = a.execute();





try{
    Command report = new ReportCommand(catalog);
    report.execute();
//    Command p = new PrintBonusPart(catalog);
//    p.execute(); Nu am reusit asta, imi da o eroare jgrapht dar obiectele mele accepta concepte (sa fie afisate si in report etc.)

    }
catch(Exception e)
{
    System.out.println(e.getMessage());
}
    }
}
