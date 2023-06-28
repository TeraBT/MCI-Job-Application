import java.util.List;

public class Wagon {
    private int serialNumber;
    private String manufacturer;
    private int constructionYear;
    private int length;
    private int unladenWeight;
    private int maxPassengerNumber;
    private int maxFreightNumber;
    private List<Passenger> passengerList;
    private List<Freight> freightList;

    public Wagon(int serialNumber,
                 String manufacturer,
                 int constructionYear,
                 int length, int unladenWeight,
                 int maxPassengerNumber,
                 int maxFreightNumber,
                 List<Passenger> passengerList,
                 List<Freight> freightList) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.constructionYear = constructionYear;
        this.length = length;
        this.unladenWeight = unladenWeight;
        this.maxPassengerNumber = maxPassengerNumber;
        this.maxFreightNumber = maxFreightNumber;
        this.passengerList = passengerList;
        this.freightList = freightList;



        if (passengerList.size() > maxPassengerNumber) {
            throw new IllegalStateException("Passengers exceeding limit");
        }

        if (freightList.size() > maxFreightNumber) {
            throw new IllegalStateException("Freight exceeding limit");
        }
    }

    public int getMaxPassengerNumber() {
        return maxPassengerNumber;
    }

    public int getMaxFreightNumber() {
        return maxFreightNumber;
    }

    public int getLength() {
        return length;
    }

    public int getFreightWeight() {
        int freightWeight = 0;

        for (Freight freight : freightList) {
            freightWeight += freight.weight();
        }

        return freightWeight;
    }

    public int getTotalWeight() {

        return getFreightWeight() + unladenWeight;
    }

    public int getPassengerCount() {
        return passengerList.size();
    }

    public int getFreightCount() {
        return freightList.size();
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public List<Freight> getFreightList() {
        return freightList;
    }

    public void setPassengerList(List<Passenger> passengerList) {

        if (passengerList.size() > maxPassengerNumber) {
            throw new IllegalStateException("Passengers exceeding limit");
        }

        this.passengerList = passengerList;
    }

    public void setFreightList(List<Freight> freightList) {

        if (freightList.size() > maxFreightNumber) {
            throw new IllegalStateException("Freight exceeding limit");
        }

        this.freightList = freightList;
    }
}
