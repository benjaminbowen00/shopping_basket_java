package discount;

import basket.Item;

import java.util.*;

public class Bogof implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {

        Set<Item> itemSet = new HashSet(items);
        for(Item item: itemSet){
            int itemFreqeuncy = Collections.frequency(items, item);
            total -= (itemFreqeuncy/2) * item.getPrice();
        }
        return total;
    }




    public HashMap<Item, Integer> countItemFrequencies(ArrayList<Item> items) {
        HashMap<Item, Integer> itemFrequencies = new HashMap<>();
        for (Item item : items) {
            if (itemFrequencies.containsKey(item)) {
                itemFrequencies.put(item, itemFrequencies.get(item) + 1);
            } else {
                itemFrequencies.put(item, itemFrequencies.get(item));
            }
        }
        return itemFrequencies;
    }
}
