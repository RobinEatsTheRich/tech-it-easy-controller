package Robin.TechItEasy;

public class Television {
    private String name;
    private int serialNumber;
    private double price;

    public Television(String name, int serialNumber, double price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
