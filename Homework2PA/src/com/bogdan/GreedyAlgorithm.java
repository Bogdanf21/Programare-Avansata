package com.bogdan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Just a greedy Algorithm to solve the problem
 * **/

public class GreedyAlgorithm extends Algorithm {

GreedyAlgorithm(Problem problem)
{
    this.problem = problem;


}


    @Override
    public Solution solve() {

        List<Room> rooms = problem.getRooms();

        List<Eveniment> events = problem.getEvents();

        Room[] assignment = new Room[events.size()];

        int eventPos = 0;
        int minimumStartTime;
        for(Room tempRoom : rooms)
        {
            minimumStartTime = 8;
            eventPos = 0;
            for(Eveniment tempEvent : events)
            {
                if(assignment[eventPos] == null)
                    if(tempRoom.canHold(tempEvent) && tempEvent.getStartTime() >= minimumStartTime)
                    {
                        assignment[eventPos] = tempRoom;
                        minimumStartTime=tempEvent.getEndTime();
                    }


                eventPos++;
            }
        }
       /* System.out.println("RESULT");
        for(int i=0;i<assignment.length;i++)
        {
            System.out.println(assignment[i] + ",  ");
        }*/
        return new Solution(assignment,events);
}
}
