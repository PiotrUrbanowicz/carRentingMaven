package curse.model;

public class Vehicle {

    private String plate;
    private boolean rent;
    private double price;

    public Vehicle(){

    }
    public Vehicle(String plate, double price, boolean rent) {
        this.plate = plate;
        this.price = price;
        this.rent = rent;
    }

    public String getPlate() {

        return plate;
    }

    public boolean isRent() {
        return rent;
    }

    public double getPrice() {
        return price;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String toString(){

        return new StringBuilder()
                .append(this.getPlate())
                .append(" ")
                .append(this.getPrice())
                .append(" ")
                .append(this.rent? "Nie":"TAK")
                .toString();

    }
    public String convertToData(){

        return new StringBuilder()
                .append(this.getClass().getSimpleName())
                .append(";")
                .append(this.getPlate())
                .append(";")
                .append(this.getPrice())
                .append(";")
                .append(this.isRent())
                .toString();
    }


}
