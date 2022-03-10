Project to solve the rooms and events problem.

Event Class has :
String name = "No name given";
int participantsNumber;
int startTime;
int endTime;

Can be instantiated through multiple constructors, check the javadoc.

Room class is abstract, extended to LectureHall and ComputerLab;
Room has:
String name;
int capacity;

LectureHall and ComputerLab have particular properties:
boolean hasProjector (lectureHall)
String operatingSystem (ComputerLab)

The problem has:
private List<Event> events;
private List<Room> rooms;

It is passed to Algorithm, extended to GreedyAlgorithm and is solved by abstract method solve();

It returns a Solution Object:

private final Room[] assignment;
private final List<Event> events;

where assignment[i] is the room assigned to event i (specified in List);


