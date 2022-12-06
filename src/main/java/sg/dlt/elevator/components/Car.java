package main.java.sg.dlt.elevator.components;

import main.java.sg.dlt.elevator.operations.processrequest.InternalRequest;
import main.java.sg.dlt.elevator.operations.CarOperations;

public class Car {

    private int currentLevel;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public Car(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public boolean checkLoad(double load){
        CarOperations carOperations = new CarOperations();
        return carOperations.checkLoad(load);
    }

    public void decideLevel(Car car, InternalRequest[] internalRequests){
        CarOperations carOperations = new CarOperations();
        carOperations.decideLevel(car, internalRequests);
    }
}
