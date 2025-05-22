public class Cake { //comparing correctness
    private final int MAX_LAYERS = 4;
    private int rating = 0;
    //correct recipe
    private String batter;
    private String frosting;
    private String topping;
    private int correctLayer;
    private int correctFrost;
    private int correctTopping;
    //what you made
    private int layer;
    private int frostingAmt;
    private int toppingAmt;

    //initializing correct customer cake
    public Cake(String batter, int layer, String frosting, int frostAmt, String topping, int toppingAmt) {
        this.batter = batter;
        this.correctLayer = layer;
        this.frosting = frosting;
        this.frostingAmt = frostAmt;
        this.topping = topping;
        this.toppingAmt = toppingAmt;
    }

    public Cake() {}

    public void addLayer() {
        layer++;
    }

    public void addFrosting(String flavor) {
        if (flavor.equals(frosting)) {
            frostingAmt++;
        }
    }

    public void addTopping(String topping) {
        if (this.topping.equals(topping)) {
            toppingAmt++;
        }
    }

    public int calculateRating() {
        if (layer == correctLayer) {
            rating++;
        }
        if (frostingAmt > 0) {
            rating++;
        }
        if (frostingAmt == correctFrost) {
            rating++;
        }
        if (toppingAmt > 0) {
            rating++;
        }
        if (toppingAmt == correctTopping) {
            rating++;
        }
        return rating;
    }

    public int calculateProfit() {
        int profit = rating * 4;
        if (rating == 5) {
            profit += 5;
        }
        if (rating <= 2) {
            profit -= 5;
        }
        return profit;
    }
}
