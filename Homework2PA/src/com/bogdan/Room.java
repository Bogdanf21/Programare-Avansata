package com.bogdan;

public class Room {
    private String name;
    private int capacity;
    private RoomType type;


    public Room(String name,int capacity, RoomType type) {
        this.name = name;
        this.type = type;
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

    @Override
    public String toString() {
        return (
                (new StringBuilder().append(this.name))
                        .append(" " + this.type.toString() ))
                        .toString();
    }
}



