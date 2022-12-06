package main.java.sg.dlt.elevator.operations.processrequestqueue;

public class Request {
    public int level;
    public int range;

    int sourceLevel;


    /**
     * Constructor
     **/
    public Request(int level, int range, int sourceLevel) {
        this.level = level;
        this.range = range;
        this.sourceLevel = sourceLevel;
    }

    public String toString() {
        return "Level : " + level + "\nPriority : " + range;
    }
}
