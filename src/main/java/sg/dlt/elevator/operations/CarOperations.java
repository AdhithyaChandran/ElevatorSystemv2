package main.java.sg.dlt.elevator.operations;

import main.java.sg.dlt.elevator.components.Car;
import main.java.sg.dlt.elevator.components.Display;
import main.java.sg.dlt.elevator.operations.processrequest.InternalRequest;
import main.java.sg.dlt.elevator.operations.processrequest.Processor;
import main.java.sg.dlt.elevator.operations.processrequestqueue.Request;
import main.java.sg.dlt.elevator.operations.processrequestqueue.PrioritySetter;

public class CarOperations {
    public Boolean checkLoad
            (double currentLoad) {

        Boolean loadFlag = false;
        int loadLimit = 1050;
        if (currentLoad < loadLimit) {
            loadFlag = true;
        } else {
            loadFlag = false;
        }

        return loadFlag;
    }

    public void decideLevel(Car car, InternalRequest[] internalRequest)//receives the list of destinationLevel and assigns  them priorities based on the difference in sourceLevel and destination level
    {
        Processor processor = new Processor();
        PrioritySetter PrioritySetter = processor.assignPriority(internalRequest);//creates  a priority queue
        while (!PrioritySetter.isEmpty()) {
            Request destinationRequest = PrioritySetter.remove();
            System.out.println("Level : " + destinationRequest.level + " Range : " + destinationRequest.range);
            long start = System.nanoTime();
            car.setCurrentLevel(moveTo(car, destinationRequest));
            long end = System.nanoTime();
            System.out.println("Time taken :" + (end - start) / 1000);
            System.out.println("People remaining : " + PrioritySetter.size());
        }
    }

    int moveTo(Car car, Request destinationRequest) {
        Display display = new Display();
        if (car.getCurrentLevel() < destinationRequest.level) {
            while (car.getCurrentLevel() != destinationRequest.level) {
                car.setCurrentLevel(car.getCurrentLevel()+ 1);
                System.out.println("-You are at : " + car.getCurrentLevel());
            }
        } else {
            while (car.getCurrentLevel() != destinationRequest.level) {
                car.setCurrentLevel(car.getCurrentLevel()- 1);
                System.out.println("-You are at : " + car.getCurrentLevel());
            }
        }
        display.displayLevel(car);
        return car.getCurrentLevel();
    }
}
