package main.java.sg.dlt.elevator.components;

import main.java.sg.dlt.elevator.Elevator;
import main.java.sg.dlt.elevator.operations.DisplayOperations;

public class Display {
    public void displayLevel(Car car){
        DisplayOperations displayOperations = new DisplayOperations();
        displayOperations.displayCurrentLevel(car);
    }
}
