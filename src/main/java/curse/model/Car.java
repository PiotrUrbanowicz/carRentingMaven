package curse.model;

public class Car extends Vehicle{

    public Car() {
    }

    public Car(String plate, double price, boolean rent) {
        super(plate, price, rent);
    }

    public Car(String[] data) {
        super(data[1],Double.parseDouble(data[2]),Boolean.parseBoolean(data[3]));
    }
}
