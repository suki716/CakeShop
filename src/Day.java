import java.util.ArrayList;

public class Day {
    private int profit;
    private int stars;
    private int customerNum;
    //private int expenses;
    private Cake customer;

    public Day() {
        stars = 0;
        profit = 0;
        customerNum = 1;
    }

    public Cake newCustomer() {
        initializeCake();
        customerNum++;
        stars = 0;
        profit = 0;
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

    public int getStars(){
        return stars;
    }

    public int getProfit(){
        return profit;
    }
}
