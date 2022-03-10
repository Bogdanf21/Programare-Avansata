package Implementations;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{
    private String name;
    private Map<Node,Integer> cost = new HashMap<>();

    public void setCost(Node node, int value)
    {
        cost.put(node,value);
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }


}
