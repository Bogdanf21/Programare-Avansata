package com.bogdan;

public abstract class Room{
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

    public abstract boolean canHold(Eveniment event);

}





/*
public class Room {
    private String name;
    private int capacity;
    private RoomType type;


    public Room(String name,int capacity, RoomType type) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room other = (Room) obj;
        return name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }




}
*/



