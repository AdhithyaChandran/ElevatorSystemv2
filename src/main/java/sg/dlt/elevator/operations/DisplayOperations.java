package main.java.sg.dlt.elevator.operations;

import main.java.sg.dlt.elevator.Elevator;
import main.java.sg.dlt.elevator.components.Car;

public class DisplayOperations {
    public void displayCurrentLevel(Car car) {
        //display direction and floornumber
        System.out.println("Source Level :"+car.getCurrentLevel());
    }
}
