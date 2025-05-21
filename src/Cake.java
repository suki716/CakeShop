public class Cake { //comparing correctness
    private final int MAX_LAYERS = 4;
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

    public Cake() {

    }

    public void addLayer() {
        layer++;
    }

    public void addFrosting(String flavor) {
        if (flavor.equals(batter)) {
            frostingAmt++;
        }
    }

    public void addTopping(String topping) {
        if (this.topping.equals(topping)) {
            toppingAmt++;
        }
    }

    public int calculateRating() {

    }
}
