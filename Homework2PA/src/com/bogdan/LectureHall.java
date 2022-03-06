package com.bogdan;

public class LectureHall extends Room {



private boolean hasProjector = false;

    public LectureHall(){};

    public LectureHall(String name, int capacity,boolean hasProjector) {
        this.name = name;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }

    public LectureHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public void addProjector() {
        if(!hasProjector)
            this.hasProjector = true;
        else
            System.out.println("Warning: hasProjector is already false");
    }

    public void removeProjector() {
        if(hasProjector)
            this.hasProjector = false;
        else
            System.out.println("Warning: hasProjector is already true");
    }



    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append(name + "(");
        temp.append("cap=" + capacity);
        temp.append(", Lecture Hall");
        if(hasProjector)
            temp.append(", Projector: yes");
        temp.append(")");
        return temp.toString();

    }

    @Override
    public boolean canHold(Eveniment event) {
        boolean isCorrectRoomType;

        if(event.getName().contains("C"))
            isCorrectRoomType = true;
        else
            isCorrectRoomType = false;



        return event.getParticipantsNumber() <= this.capacity && isCorrectRoomType;
    }
}
