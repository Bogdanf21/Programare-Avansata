package Implementations;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    //… constructors, getters, setters

    public Network()
    {
        this.nodes = new ArrayList<>();
    }
    public Network(List<Node> nodes)
    {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    //… toString, etc.
}
