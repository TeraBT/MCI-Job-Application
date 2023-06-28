public class Locomotive {

    private int serialNumber;
    private String manufacturer;
    private int constructionYear;
    private int length;
    private int unladenWeight;
    private int tractionCapacity;

    public Locomotive(int serialNumber, String manufacturer, int constructionYear, int length, int unladenWeight, int tractionCapacity) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.constructionYear = constructionYear;
        this.length = length;
        this.unladenWeight = unladenWeight;
        this.tractionCapacity = tractionCapacity;
    }

    public int getUnladenWeight() {
        return unladenWeight;
    }

    public int getLength() {
        return length;
    }
}
