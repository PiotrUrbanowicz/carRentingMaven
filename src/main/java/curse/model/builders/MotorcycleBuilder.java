package curse.model.builders;

import curse.model.Motorcycle;

public class MotorcycleBuilder {

    private Motorcycle motorcycle=new Motorcycle();

    public MotorcycleBuilder() {
        motorcycle.setRent(false);
    }


    public MotorcycleBuilder plate(String plate) {
        this.motorcycle.setPlate(plate);
        return this;
    }

    public MotorcycleBuilder price(double price) {
        this.motorcycle.setPrice(price);
        return this;
    }

    public MotorcycleBuilder cart(boolean cart) {
        this.motorcycle.setCart(cart);
        return this;
    }

    public Motorcycle build(){
        return this.motorcycle;
    }






}
