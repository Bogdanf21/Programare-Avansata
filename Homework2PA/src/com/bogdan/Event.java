package com.bogdan;

public class Event {
    private String name = "No name given";
    private int participantsNumber;
    private int startTime;
    private int endTime;

    /**
     * Constructor for Event class.
     * Available options:
     * <p>
     * Event() - empty event
     * <p>
     * Event(int participantsNumber, int startTime, int endTime) - no name given
     * <p>
     * Event(String name, int participantsNumber, int startTime, int endTime)
     */
    public Event() {
    }

    /**
     * Constructor for Event class.
     * Available options:
     * <p>
     * Event() - empty event
     * <p>
     * Event(int participantsNumber, int startTime, int endTime) - no name given
     * <p>
     * Event(String name, int participantsNumber, int startTime, int endTime)
     */
    public Event(String name, int participantsNumber, int startTime, int endTime) {
        this.name = name;
        this.participantsNumber = participantsNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Constructor for Event class.
     * Available options:
     * <p>
     * Event() - empty event
     * <p>
     * Event(int participantsNumber, int startTime, int endTime) - no name given
     * <p>
     * Event(String name, int participantsNumber, int startTime, int endTime)
     */
    public Event(int participantsNumber, int startTime, int endTime) {
        this.participantsNumber = participantsNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Getter for name
     */
    public String getName() {
        return name;
    }


    /**
     * Setter for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for participants number
     *
     * @return
     */
    public int getParticipantsNumber() {
        return participantsNumber;
    }

    /**
     * Setter for participants number
     *
     * @param participantsNumber
     */
    public void setParticipantsNumber(int participantsNumber) {
        this.participantsNumber = participantsNumber;
    }

    /**
     * Getter for start time
     *
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Setter for start time
     *
     * @param startTime
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter for end time
     *
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Setter for start time
     *
     * @param endTime
     */
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
        Event other = (Event) obj;
        return name.equals(other.name);
    }
}
