package basket;

public class Item {

    String name;
    Double price;
    Boolean bogof;

    public Item(String name, Double price, Boolean bogof) {
        this.bogof = bogof;
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price) {
        this.bogof = false;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setBogof(Boolean bogof) {
        this.bogof = bogof;
    }

    public Boolean getBogof() {
        return bogof;
    }
}
