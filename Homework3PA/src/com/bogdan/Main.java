package com.bogdan;

import Implementations.Computer;
import Implementations.Network;
import Implementations.Node;

public class Main {

    public static void main(String[] args) {
	Network n1 = new Network();
    n1.addNode(new Computer());
    n1.addNode(new Computer());
    }
}
