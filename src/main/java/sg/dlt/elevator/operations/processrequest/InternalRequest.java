package main.java.sg.dlt.elevator.operations.processrequest;

public class InternalRequest {
    public int sourceLevel;

    public int destinationLevel;

    int requestedAt;

    public InternalRequest(int destinationLevel, int requestedAt, int sourceLevel) {
        this.destinationLevel = destinationLevel;
        this.requestedAt = requestedAt;
        this.sourceLevel = sourceLevel;
    }

}
