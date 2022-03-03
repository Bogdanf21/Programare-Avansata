package com.bogdan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
Eveniment C1 = new Eveniment("C1",100,8,10);
Eveniment C2 = new Eveniment("C2",100,10,12);
Eveniment L1 = new Eveniment("L1",30,8,10);
Eveniment L2 = new Eveniment("L2",30,8,10);
Eveniment L3 = new Eveniment("L3",100,10,12);
ArrayList<Eveniment> eveniments = new ArrayList<Eveniment>(
        Arrays.asList(C1,C2,L1,L2,L3)
);

ArrayList<Room> rooms = new ArrayList<Room>();
rooms.add(new Room("401", 30, RoomType.COMPUTER_LAB));
rooms.add(new Room("403", 30, RoomType.COMPUTER_LAB));
rooms.add(new Room("405", 30, RoomType.COMPUTER_LAB));
rooms.add(new Room("403", 30, RoomType.COMPUTER_LAB));

        System.out.println(rooms);
        System.out.println(eveniments);
    }
}
