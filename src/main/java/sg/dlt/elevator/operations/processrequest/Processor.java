package main.java.sg.dlt.elevator.operations.processrequest;


import main.java.sg.dlt.elevator.components.Car;
import main.java.sg.dlt.elevator.operations.processrequestqueue.PrioritySetter;
import main.java.sg.dlt.elevator.operations.processrequestqueue.RequestQueue;

import java.util.Scanner;

public class Processor {


    public InternalRequest[] getRequest(Car car) {
        int i = 0;
        new RequestQueue(5);
        Scanner sc = new Scanner(System.in);
        InternalRequest[] internalRequestList = new InternalRequest[5];
        while (i != 5) {
            System.out.print("Enter Destination Level : ");
            int destinationLevel = sc.nextInt();
            InternalRequest internalRequest = new InternalRequest(destinationLevel, (int) System.nanoTime(), car.getCurrentLevel());
            RequestQueue.queueEnqueue(internalRequest);
            internalRequestList = RequestQueue.giveQueue();
            i += 1;
        }
        return internalRequestList;
    }

    // 1.Priority 1.Requested time 2.Range 3.Current Load



    //externalRequests = [{direction, timeStamp, sourceLevel}]
    //internalRequests = [{timeStamp, destinationLevel , sourceLevel}]


    //linking externalRequest of one user to his internalRequest



    public PrioritySetter assignPriority(InternalRequest[] internalRequests) {
        PrioritySetter pq = new PrioritySetter(internalRequests.length);
        int[] rangeList = calculateRange(internalRequests);
        pq.displayQueue();
        for (int i = 0; i < rangeList.length; i++) {
            pq.insert(internalRequests[i].destinationLevel, rangeList[i], internalRequests[i].sourceLevel);
        }
        return pq;
    }

    int[] calculateRange(InternalRequest[] internalRequests) {
        int[] rangeList = new int[internalRequests.length];
        for (int i = 0; i < internalRequests.length; i++) {
            rangeList[i] = internalRequests[i].destinationLevel - internalRequests[i].sourceLevel;
        }
        return rangeList;
    }



    //Once the requestQueue object is passed into decideLevel ,
    // we need to calculate range and assign a priority to each level in the queue
    //floors will be traversed based on the priority


}
