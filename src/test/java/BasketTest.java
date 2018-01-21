import basket.Basket;
import basket.Item;
import discount.Bogof;
import discount.HighSpendDiscount;
import discount.LoyaltyDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BasketTest {

    Basket basket;
    Item item1;
    Item item2;
    LoyaltyDiscount loyaltyDiscount;
    HighSpendDiscount highSpendDiscount;
    Bogof bogof;

    @Before
    public void before(){
        basket = new Basket();
        loyaltyDiscount = new LoyaltyDiscount();
        highSpendDiscount = new HighSpendDiscount();
        bogof = new Bogof();
        item1 = new Item("TV", 500.0);
        item2 = new Item("DVD", 10.0);
        basket.addItem(item1);
        basket.addItem(item2);
    }


    @Test
    public void canClearItems(){
        assertEquals(2, basket.countItems());
        basket.clearItems();
        assertEquals(0, basket.countItems());
    }

    @Test
    public void canRemoveOneItem(){
        basket.removeItem(item1);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void canGetTotal(){
        assertEquals(510.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyLoyaltyDiscount(){
        basket.addDiscount(loyaltyDiscount);
        basket.applyDiscounts();
        assertEquals(499.80, basket.getTotal(), 0.01);
    }

    @Test
    public void cantApplytLoyaltyDiscountTwice(){
        basket.addDiscount(loyaltyDiscount);
        basket.applyDiscounts();
        basket.applyDiscounts();
        assertEquals(499.80, basket.getTotal(), 0.01);
    }

    @Test
    public void noHighSpendDiscountLowTotal(){
        basket.removeItem(item1);
        basket.addDiscount(highSpendDiscount);
        basket.applyDiscounts();
        assertEquals(10.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyHighSpendDiscount(){
        basket.addDiscount(highSpendDiscount);
        basket.applyDiscounts();
        assertEquals(459.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyBogofNoRepeats(){
        basket.addDiscount(bogof);
        basket.applyDiscounts();
        assertEquals(510.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyBogofTwoDvds(){
        basket.addItem(item2);
        basket.addDiscount(bogof);
        basket.applyDiscounts();
        assertEquals(510.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyBogofThreeDvds(){
        basket.addItem(item2);
        basket.addItem(item2);
        basket.addDiscount(bogof);
        basket.applyDiscounts();
        assertEquals(520.0, basket.getTotal(), 0.01);
    }

    @Test
    public void canApplyBogofAndLoyaltyDiscount(){
        basket.addItem(item2);
        basket.addItem(item2);
        basket.addDiscount(bogof);
        basket.addDiscount(loyaltyDiscount);
        basket.applyDiscounts();
        assertEquals(509.60, basket.getTotal(), 0.01);
    }



}
