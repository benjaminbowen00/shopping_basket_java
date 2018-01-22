package discount;

import basket.Item;

import java.util.*;

public class Bogof implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {

        ArrayList<Item> bogofItems = getBogofItems(items);


        Set<Item> itemSet = new HashSet(bogofItems);

        for(Item item: itemSet){
            int itemFreqeuncy = Collections.frequency(items, item);
            total -= (itemFreqeuncy/2) * item.getPrice();
        }
        return total;
    }

    public ArrayList<Item> getBogofItems(ArrayList<Item> items){
        ArrayList<Item> bogofItems = new ArrayList<>();
        for(Item item : items){
            if(item.getBogof()==true){bogofItems.add(item);}
        }
        return bogofItems;
    }



//alternative approach using hashmap

//    public HashMap<Item, Integer> countItemFrequencies(ArrayList<Item> items) {
//        HashMap<Item, Integer> itemFrequencies = new HashMap<>();
//        for (Item item : items) {
//            if (itemFrequencies.containsKey(item)) {
//                itemFrequencies.put(item, itemFrequencies.get(item) + 1);
//            } else {
//                itemFrequencies.put(item, itemFrequencies.get(item));
//            }
//        }
//        return itemFrequencies;
//    }
}
