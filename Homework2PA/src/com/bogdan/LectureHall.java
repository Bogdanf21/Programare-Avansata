package com.bogdan;


/**
 * Extension of the class: Room
 *
 */
public class LectureHall extends Room {



private boolean hasProjector = false;


    /**
     * Constructor for Lecture Hall.
     *
     * Options:
     *
     *  <p> LectureHall(){}</p>
     *  <p>LectureHall(String name, int capacity)</p>
     *  <p>LectureHall(String name, int capacity,boolean hasProjector)</p>
     *
     */
    public LectureHall(){};
    /**
     * Constructor for Lecture Hall.
     *
     * Options:
     *
     *  <p> LectureHall(){}</p>
     *  <p>LectureHall(String name, int capacity)</p>
     *  <p>LectureHall(String name, int capacity,boolean hasProjector)</p>
     *
     */
    public LectureHall(String name, int capacity,boolean hasProjector) {
        this.name = name;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }
    /**
     * Constructor for Lecture Hall.
     *
     * Options:
     *
     *  <p> LectureHall(){}</p>
     *  <p>LectureHall(String name, int capacity)</p>
     *  <p>LectureHall(String name, int capacity,boolean hasProjector)</p>
     *
     */
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

    /**
     * Override of method canHold from Room class.
     * It verifies if the room is large enough (participantsNumber <= lectureHallCapacity) and if the event is right for this room (in this case if it is a course)
     * @param event
     */
    @Override
    public boolean canHold(Event event) {
        boolean isCorrectRoomType;

        if(event.getName().contains("C"))
            isCorrectRoomType = true;
        else
            isCorrectRoomType = false;



        return event.getParticipantsNumber() <= this.capacity && isCorrectRoomType;
    }
}
