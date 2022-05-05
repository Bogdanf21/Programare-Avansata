package com.bogdan;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        ArrayList<Event> events = new ArrayList<Event>(
                Arrays.asList(C1, C2, L1, L2, L3)
        );

        ArrayList<Room> rooms = new ArrayList<Room>();

        rooms.add(new ComputerLab("401", 30));
        rooms.add(new ComputerLab("403", 30));
        rooms.add(new ComputerLab("405", 30));
        rooms.add(new LectureHall("309", 100));

        System.out.println(rooms);
        System.out.println(events);

        Problem pb = new Problem(events, rooms);


        System.out.println(pb);

        Algorithm greedy = new GreedyAlgorithm(pb);

        Solution sol = greedy.solve();

        System.out.println(sol);


    }
}
