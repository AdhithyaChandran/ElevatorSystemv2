package main.java.sg.dlt.elevator;

public class Elevator {
    public int getSourceLevel() {
        return sourceLevel;
    }

    public void setSourceLevel(int sourceLevel) {
        this.sourceLevel = sourceLevel;
    }

    private int sourceLevel;

    public Elevator(int sourceLevel) {
        this.sourceLevel = sourceLevel;
    }



}
