package com.bogdan;

public class Eveniment {
    private String name = "No name given";
    private int participantsNumber;
    private int startTime;
    private int endTime;


    public Eveniment() {}



    public Eveniment(String name, int participantsNumber, int startTime, int endTime){
        this.name = name;
        this.participantsNumber = participantsNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Eveniment(int participantsNumber, int startTime, int endTime){
        this.participantsNumber = participantsNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getParticipantsNumber() {
        return participantsNumber;
    }

    public void setParticipantsNumber(int participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String toString() {
       StringBuilder temp = new StringBuilder();
       temp.append(name + "(");
       temp.append("size=" + participantsNumber);
        temp.append(", start=" + startTime);
        temp.append(", end=" + endTime + ")");
    return temp.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
       Eveniment other = (Eveniment) obj;
        return name.equals(other.name);
    }
}
