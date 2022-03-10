package com.bogdan;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Extension of Algorithm Class, solves a Problem with a Greedy method.
 */
public class GreedyAlgorithm extends Algorithm {
    /**
     * Just a greedy Algorithm constructor to solve the problem
     */
    GreedyAlgorithm(Problem problem) {
        this.problem = problem;
        Comparator<Event> eventComparator = new Comparator<Event>() {
            @Override
            public int compare(Event event1, Event event2) {
                if (event1.getStartTime() == event2.getStartTime())
                    return 0;
                else if (event1.getStartTime() < event2.getStartTime())
                    return -1;
                return 1;

            }

        };
        problem.getEvents().sort(eventComparator);

    }


    @Override
    public Solution solve() {

        List<Room> rooms = problem.getRooms(); // got the rooms / events in a more accessible variant

        List<Event> events = problem.getEvents();

        Room[] assignment = new Room[events.size()]; // initialize the assignment array (from indications lab2)

        int eventsAssigned = 0; // so I know if all the events are assigned

        int eventPos = 0;
        int minimumStartTime;
        for (Room tempRoom : rooms) // take one room, fill it with as many events as possible
        {
            minimumStartTime = events.get(0).getStartTime(); // if the events are ordered by date, this is the first hour for an event to occur

            eventPos = 0;

            if (eventsAssigned != events.size()) // enter the for loop only if there are events that are not assigned
                for (Event tempEvent : events) {
                    if (assignment[eventPos] == null) //if event is not assigned
                        if (tempRoom.canHold(tempEvent) && tempEvent.getStartTime() >= minimumStartTime) {
                            assignment[eventPos] = tempRoom; // assign the tempRoom to event with position eventPos in events list
                            minimumStartTime = tempEvent.getEndTime(); // events ordered by date and time
                            eventsAssigned++;
                        }
                    eventPos++;
                }
        }
        if (eventsAssigned != events.size()) // if not all events are assigned to a room
        {
            Room unassigned = new LectureHall("Not enough space for this event", 0); // dummy object for easiness of error implementation
            for (int i = 0; i < assignment.length; i++) {
                if (assignment[i] == null)
                    assignment[i] = unassigned;
            }
        }
        return new Solution(assignment, events); // solution object to be returned
    }
}
