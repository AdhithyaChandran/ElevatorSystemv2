package main.java.sg.dlt.elevator;

import main.java.sg.dlt.elevator.components.Car;
import main.java.sg.dlt.elevator.operations.processrequest.Processor;
import main.java.sg.dlt.elevator.operations.processrequest.InternalRequest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class RunLift {
    public static void main(String[] args) {
        liftProcessor();
    }

    public static void liftProcessor() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++) {
            scheduler.schedule(new LiftMovement(), 5, TimeUnit.SECONDS);
        }
        scheduler.shutdown();

    }


    static class LiftMovement implements Runnable {
        @Override
        public void run() {
            Processor processor = new Processor();
            Car car = new Car(0);
            Elevator elevator = new Elevator(3);
            if (car.checkLoad(Math.random() * (1050 + 1) + 0)) {
                InternalRequest[] internalRequests = processor.getRequest(car);
                car.decideLevel(car, internalRequests);
            } else {
                System.out.println("Overweight!");
            }
        }

    }


}
