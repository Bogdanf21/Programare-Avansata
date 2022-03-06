package com.bogdan;

import java.util.*;

public class Problem {
    private List<Eveniment> events;
    private List<Room> rooms;

    public Problem(Eveniment[] events, Room[] rooms)
    {
     this.events = new ArrayList<Eveniment>();
     this.rooms = new ArrayList<Room>();

        this.events=Arrays.asList(events);
        this.rooms=Arrays.asList(rooms);
    }


    public Problem(){
        this.events = new ArrayList<Eveniment>();
        this.rooms = new ArrayList<Room>();
    };

    public Problem(ArrayList<Eveniment> eveniments, ArrayList<Room> rooms) {
        this.events=eveniments;
        this.rooms=rooms;
    }

    public void setEvents(Eveniment[] events) {
        this.events=Arrays.asList(events);
    }

    public List<Eveniment> getEvents(){return events;}

    public List<Room> getRooms(){return rooms;}

    public void setRooms(Room[] rooms) {
        this.rooms=Arrays.asList(rooms);
    }

    public HashMap<String,String> computeUsedRooms()
    {
      HashMap<String,String> solution = new HashMap<String,String>();
        return solution;
    }

    public void addEvent(Eveniment event)
    {
       this.events.add(event) ;
    }

    public void addRoom(Room room)
    {
        this.rooms.add(room);
    }


    @Override
    public String toString() {
        return (new StringBuilder()
                .append(events + "\n"))
                .append(rooms)
                .toString();
    }
}
