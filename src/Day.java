import java.util.ArrayList;

public class Day {
    private int customers;
    private int profit;
    private int stars;
    private int expenses;
    private Cake customer;

    private ArrayList<Ingredient> flavors;
    private ArrayList<Ingredient> toppings;
    private ArrayList<Ingredient> decoration;

    public Day() {
        //flavors
        flavors.add(new Ingredient("vanilla", 1, false));
    }

    public void initializeCake() {
        customer = new Cake();
    }
}
