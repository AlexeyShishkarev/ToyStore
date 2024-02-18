package model.store;

public class Toys extends Goods{

    private double price;
    private int quantity;


    public Toys(int id, String name, int significance, double price, int quantity) {
        super(id, name, significance);
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "Цена: " + price + "\n" + "Значимость: " + getSignificance() + "\n";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
