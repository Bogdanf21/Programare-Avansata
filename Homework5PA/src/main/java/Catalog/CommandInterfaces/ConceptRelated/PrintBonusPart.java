package Catalog.CommandInterfaces.ConceptRelated;

import Catalog.Catalog;
import Catalog.CommandInterfaces.Command;
import Catalog.Item;
import org.jgrapht.Graph;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.HashSet;
import java.util.Set;

public class PrintBonusPart implements Command {
    private Catalog catalog;



    public PrintBonusPart(Catalog catalog)
    {
        this.catalog = catalog;
    }

    public void execute() {

        Set<Item> itemSet = new HashSet<>(catalog.getCatalog());
        Set<String> conceptSet = new HashSet<>(catalog.getAllConcepts());

        Graph<Object, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        catalog.getCatalog().forEach(graph::addVertex);
        catalog.getAllConcepts().forEach(graph::addVertex);
        catalog.getCatalog().forEach(
                item ->
                {
                    item.getConcepts().forEach(
                            concept ->
                            {
                                graph.addEdge(item, concept);
                            }
                    );
                }
        );
        // pentru largest set - maximum matching

        // minimum edge cover = maximum matching

        try {
            HopcroftKarpMaximumCardinalityBipartiteMatching<Object,DefaultEdge> bipartiteMatching = new HopcroftKarpMaximumCardinalityBipartiteMatching(graph, itemSet, conceptSet);
            System.out.println(bipartiteMatching.getMatching());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }





    }
}
