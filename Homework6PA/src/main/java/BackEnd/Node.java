package BackEnd;

import Commands.Owner;

import java.util.*;
import java.util.stream.Collectors;

public class Node {
    private Owner ownedBy = Owner.NONE;
    private Set<Node> connectedTo;
    private boolean isBlocked = false;

    Node(List<Node> connectedTo) {
        this.connectedTo = new HashSet<>(connectedTo);
    }
    Node()
    {
        this.connectedTo = new HashSet<>();
    }

    public void addConnectionTo(Node node)
    {
        connectedTo.add(node);
    }

}


