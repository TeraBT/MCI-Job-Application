import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

public class Train {
    private int trainNumber;
    private RailroadCompany railroadCompany;
    private int maxPassengerNumber;
    private int maxWeight;
    private List<Locomotive> locomotiveList;
    private List<Wagon> wagonList;


    public Train(int trainNumber,
                 RailroadCompany railroadCompany,
                 int maxPassengerNumber,
                 int maxWeight,
                 List<Locomotive> locomotiveList,
                 List<Wagon> wagonList) {
        this.trainNumber = trainNumber;
        this.maxPassengerNumber = maxPassengerNumber;
        this.maxWeight = maxWeight;
        this.railroadCompany = railroadCompany;
        this.locomotiveList = locomotiveList;
        this.wagonList = wagonList;
    }

    public void setPassengers(int serialNumberWagon, List<Passenger> passengerList) {
        Optional<Wagon> wagon = this.wagonList.stream().findAny();
        if (wagon.isEmpty()) {
            throw new IllegalArgumentException(serialNumberWagon + "does not exist.");
        } else {
            wagon.get().setPassengerList(passengerList);
        }

    }

    public void setFreight(int serialNumberWagon, List<Freight> freightList) {
        Optional<Wagon> wagon = this.wagonList.stream().findAny();
        if (wagon.isEmpty()) {
            throw new IllegalArgumentException(serialNumberWagon + "does not exist.");
        } else {
            wagon.get().setFreightList(freightList);
        }
    }

    public int getTotalPassengerCount() {
        int totalPassengerCount = 0;

        for (Wagon wagon : wagonList) {
            totalPassengerCount += wagon.getPassengerCount();
        }
        return totalPassengerCount;
    }

    public int getTotalFreightWeight() {
        int totalFreightCount = 0;

        for (Wagon wagon : wagonList) {
            totalFreightCount += wagon.getFreightWeight();
        }
        return totalFreightCount;
    }

    public int getTotalLUnladenLocomotiveWeight() {
        int totalUnladenWeightCount = 0;

        for (Locomotive locomotive : locomotiveList) {
            totalUnladenWeightCount += locomotive.getUnladenWeight();
        }
        return totalUnladenWeightCount;
    }

    public int getTotalWeight() {
        return getTotalFreightWeight() + getTotalLUnladenLocomotiveWeight();
    }

    public int getTotalLength() {
        int totalLength = 0;

        for (Wagon wagon : wagonList) {
            totalLength += wagon.getLength();
        }

        for (Locomotive locomotive : locomotiveList) {
            totalLength += locomotive.getLength();
        }
        return totalLength;
    }

    public boolean maxPassengersExceeded() {
        return maxPassengerNumber < getTotalPassengerCount();
    }

    public boolean maxWeightExceeded() {
        return maxWeight < getTotalWeight();
    }

    public int freePassengerSeats() {
        if (maxPassengersExceeded()) {
            return 0;
        } else {
            return maxPassengerNumber - getTotalPassengerCount();
        }
    }

    public int freeFreightSpace() {
        if (maxWeightExceeded()) {
            return 0;
        } else {
            return maxPassengerNumber - getTotalPassengerCount();
        }
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public RailroadCompany getRailroadCompany() {
        return railroadCompany;
    }

    public int getMaxPassengerNumber() {
        return maxPassengerNumber;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
