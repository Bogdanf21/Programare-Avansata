package com.bogdan;

import java.util.HashMap;
import java.util.List;

public class Solution {
  private final Room[] assignment;
  private final List<Eveniment> events;

    Solution(Room[] assignment,List<Eveniment> events){
        this.events = events;
        this.assignment = assignment;
    };

    @Override
    public String toString() {
       StringBuilder tempString = new StringBuilder();

       int roomNo = 0;
        for(Eveniment tempEvent : events)
        {
            tempString.append(tempEvent.getName() + " -> " + assignment[roomNo].name + "\n");
            roomNo++;
        }

        return tempString.toString();
    }


}
