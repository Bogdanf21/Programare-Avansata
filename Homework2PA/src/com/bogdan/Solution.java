package com.bogdan;

import java.util.List;


/**
 * A class that is returned by Algorithm child classes.
 * <p>
 * Usage:
 * Solution(Room[] assignment,List<Event> events) - where assignment[i] = what room received the event with index i
 */
public class Solution {
    private final Room[] assignment;
    private final List<Event> events;

    Solution(Room[] assignment, List<Event> events) {
        this.events = events;
        this.assignment = assignment;
    }

    ;

    @Override
    public String toString() {
        StringBuilder tempString = new StringBuilder();

        int roomNo = 0;
        for (Event tempEvent : events) // concatenation of every event with the specific room
        {
            tempString.append(tempEvent.getName() + " -> " + assignment[roomNo].name + "\n");
            roomNo++;
        }

        return tempString.toString();
    }


}
