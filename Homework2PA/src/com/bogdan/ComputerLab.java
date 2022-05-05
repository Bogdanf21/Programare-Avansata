package com.bogdan;

public class ComputerLab extends Room {


    private String operatingSystem = null;

    /**
     * Default ComputerLab constructor.
     * <p>
     * Options:
     * <p>
     * ComputerLab()
     * <p>
     * ComputerLab(String name, int capacity)
     * <p>
     * ComputerLab(String name, int capacity, String operatingSystem)
     */
    ComputerLab() {
    }

    ;

    /**
     * Default ComputerLab constructor.
     * <p>
     * Options:
     * <p>
     * ComputerLab()
     * <p>
     * ComputerLab(String name, int capacity)
     * <p>
     * ComputerLab(String name, int capacity, String operatingSystem)
     */
    ComputerLab(String name, int capacity, String operatingSystem) {
        this.name = name;
        this.capacity = capacity;
        this.operatingSystem = operatingSystem;
    }

    /**
     * Default ComputerLab constructor.
     * <p>
     * Options:
     * <p>
     * ComputerLab()
     * <p>
     * ComputerLab(String name, int capacity)
     * <p>
     * ComputerLab(String name, int capacity, String operatingSystem)
     */
    ComputerLab(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    /**
     * Override of method canHold from Room class.
     * It verifies if the room is large enough (participantsNumber <= lectureHallCapacity) and if the event is right for this room (in this case if it is a Lab/Seminary)
     *
     * @param event
     */
    @Override
    public boolean canHold(Event event) {
        boolean isCorrectRoomType;

        if (event.getName().contains("S") || event.getName().contains("L"))
            isCorrectRoomType = true;
        else
            isCorrectRoomType = false;


        return event.getParticipantsNumber() <= this.capacity && isCorrectRoomType;
    }


    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append(name + "(");
        temp.append("cap=" + capacity);
        temp.append("lab");
        if (operatingSystem != null)
            temp.append(", Operating System: " + operatingSystem);
        temp.append(")");
        return temp.toString();

    }
}
