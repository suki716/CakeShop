import java.util.ArrayList;

public class Day {
    private double profit;
    private int stars;
    //private int expenses;
    private Cake customer;

    public Day() {

    }

    public Cake start() {
        initializeCake();
        return customer;
    }

    public void initializeCake() {
        String batter = CakeHelper.flavors.get((int) (Math.random() * CakeHelper.flavors.size())).getName();
        int layer = (int) (Math.random() * 4) + 1;
        String frostingStr = CakeHelper.frosting.get((int) (Math.random() * CakeHelper.frosting.size())).getName();
        int frostAmt = (int) (Math.random() * 8) + 1;
        String toppingStr = CakeHelper.toppings.get((int) (Math.random() * CakeHelper.toppings.size())).getName();
        int toppingAmt = (int) (Math.random() * 8) + 1;
        customer = new Cake(batter, layer, frostingStr, frostAmt, toppingStr, toppingAmt);
    }

    public int cakeDone() {
        stars += customer.calculateRating();
        profit += customer.calculateProfit();
        return stars;
    }
}
