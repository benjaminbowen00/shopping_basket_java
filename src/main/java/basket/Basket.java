package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;
    private double total;


    public Basket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
        total = 0;
    }

    public int countItems(){
        return this.items.size();
    }

    public void clearItems(){
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public void removeItem(Item item){
        this.items.remove(item);
        this.total -= item.getPrice();
    }

    public void addItem(Item item){
        this.items.add(item);
        this.total += item.getPrice();
    }

    public void addDiscount(IDiscount discount){
        this.discounts.add(discount);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double recalculateTotalNoDiscounts(){
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void applyDiscounts(){
        for (IDiscount discount : discounts){
            setTotal(discount.applyDiscount(items, total));
        }
    }








}
