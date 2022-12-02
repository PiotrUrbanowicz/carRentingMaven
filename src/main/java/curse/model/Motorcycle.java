package curse.model;

public class Motorcycle extends Vehicle{

    private boolean cart;

    public Motorcycle() {
    }

    public Motorcycle(String plate, int price,boolean rent, boolean cart) {
        super(plate, price,rent);
        this.cart = cart;
    }

    public Motorcycle(String[] data) {
        super(data[1],Double.parseDouble(data[2]),Boolean.parseBoolean(data[3]));
     //   this.cart=Boolean.parseBoolean(data[4]);
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return super.toString()+" "+((this.isCart())? "NIE":"TAK");
    }

    @Override
    public String convertToData() {
        return super.convertToData()+";"+this.isCart();
    }
}
