package com.bogdan;

public class ComputerLab extends Room{


    private String operatingSystem = null;

    public ComputerLab(){};

    ComputerLab(String name, int capacity, String operatingSystem)
    {
        this.name = name;
        this.capacity = capacity;
        this.operatingSystem = operatingSystem;
    }
    ComputerLab(String name, int capacity)
    {
        this.name = name;
        this.capacity= capacity;
    }

    public boolean canHold(Eveniment event) {
        boolean isCorrectRoomType;

        if(event.getName().contains("S") && event.getName().contains("L"))
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
        if(operatingSystem != null)
            temp.append(", Operating System: " + operatingSystem);
        temp.append(")");
        return temp.toString();

    }
}
