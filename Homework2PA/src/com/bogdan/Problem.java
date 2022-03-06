package com.bogdan;

import java.util.*;

public class Problem {
    private List<Event> events;
    private List<Room> rooms;

    /**
     * Constructor for Problem class.
     *
     * Available options:
     * Problem() - empty
     * Problem(Event[] events, Room[] rooms)
     * Problem(List<Event> events, List<Room> rooms)
     *
     */
    public Problem(Event[] events, Room[] rooms)
    {
     this.events=Arrays.asList(events);
     this.rooms=Arrays.asList(rooms);
    }

    /**
     * Constructor for Problem class.
     *
     * Available options:
     * Problem() - empty
     * Problem(Event[] events, Room[] rooms)
     * Problem(List<Event> events, List<Room> rooms)
     *
     */
    public Problem(){
        this.events = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }
    /**
     * Constructor for Problem class.
     *
     * Available options:
     * Problem() - empty
     * Problem(Event[] events, Room[] rooms)
     * Problem(List<Event> events, List<Room> rooms)
     *
     */
    public Problem(ArrayList<Event> events, ArrayList<Room> rooms) {
        this.events= events;
        this.rooms=rooms;
    }

    public void setEvents(Event[] events) {
        this.events=Arrays.asList(events);
    }

    public List<Event> getEvents(){return events;}

    public List<Room> getRooms(){return rooms;}

    public void setRooms(Room[] rooms) {
        this.rooms=Arrays.asList(rooms);
    }

    public void addEvent(Event event)
    {
       this.events.add(event) ;
    }

    public void addRoom(Room room)
    {
        this.rooms.add(room);
    }


    @Override
    public String toString() {

        StringBuilder temp = new StringBuilder();
        temp.append(events);
        temp.append("\n");
        temp.append(rooms);
        return temp.toString();

    }
}
