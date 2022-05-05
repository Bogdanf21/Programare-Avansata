package com.bogdan;


/**
 * Abstract class implemented by LectureHall and ComputerLab. It should not be instantiated.
 * <p>
 * method canHold should be Implemented, and it will return a boolean value.
 */
public abstract class Room {
    protected String name = "Unknown";
    protected int capacity = -1;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean canHold(Event event);

}





