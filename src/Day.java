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
        customer = CakeHelper.randomCake();
    }

    public int cakeDone() {
        stars += customer.calculateRating();
        profit += customer.calculateProfit();
        return stars;
    }
}
