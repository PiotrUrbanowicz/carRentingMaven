package curse.model;

public class Bus extends Vehicle {

    private int seats;


    public Bus() {
    }

    public Bus(String plate, double price, boolean rent, int seats) {
        super(plate, price,rent);
        this.seats = seats;
    }
    public Bus(String[] data) {
        super(data[1],Double.parseDouble(data[2]),Boolean.parseBoolean(data[3]));
        this.seats=Integer.parseInt(data[4]);
    }
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return super.toString()+" "+this.getSeats();
    }

    @Override
    public String convertToData() {
        return super.convertToData()+";"+this.getSeats();
    }
}
