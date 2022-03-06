package com.bogdan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
Eveniment C1 = new Eveniment("C1",100,8,10);
Eveniment C2 = new Eveniment("C2",100,10,12);
Eveniment L1 = new Eveniment("L1",30,8,10);
Eveniment L2 = new Eveniment("L2",30,8,10);
Eveniment L3 = new Eveniment("L3",30,10,12);
ArrayList<Eveniment> eveniments = new ArrayList<Eveniment>(
        Arrays.asList(C1,C2,L1,L2,L3)
);

ArrayList<Room> rooms = new ArrayList<Room>();

rooms.add(new ComputerLab("401", 30));
rooms.add(new ComputerLab("403", 30));
rooms.add(new ComputerLab("405", 30));
rooms.add(new LectureHall("309", 100));

System.out.println(rooms);
System.out.println(eveniments);

Problem pb = new Problem(eveniments,rooms);


        System.out.println(pb);

        Algorithm greedy = new GreedyAlgorithm(pb);

        Solution sol = greedy.solve();

        System.out.println(sol);


    }
}
