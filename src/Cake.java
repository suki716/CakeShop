public class Cake { //comparing correctness
    private final int MAX_LAYERS = 4;
    private int rating = 0;
    //correct recipe
    private String correctBat;
    private int correctLayer;
    private String correctFrost;
    private int correctFrostAmt;
    private String correctTop;
    private int correctTopAmt;
    //what you made
    private String batter;
    private int layer;
    private String frosting;
    private int frostingAmt;
    private String topping;
    private int toppingAmt;

    //initializing correct customer cake
    public Cake(String batter, int layer, String frosting, int frostAmt, String topping, int toppingAmt) {
        this.correctBat = batter;
        this.correctLayer = layer;
        this.correctFrost = frosting;
        this.correctFrostAmt = frostAmt;
        this.correctTop= topping;
        this.correctTopAmt = toppingAmt;
    }

    public Cake() {}


    //getters
    public String getCorrectBat(){
        return correctBat;
    }

    public int getCorrectLayer(){
        return correctLayer;
    }

    public String getCorrectFrost(){
        return correctFrost;
    }

    public int getCorrectFrostAmt() {
        return correctFrostAmt;
    }

    public String getCorrectTop(){
        return correctTop;
    }

    public int getCorrectTopAmt(){
        return correctTopAmt;
    }

    public void addLayer() {
        if (layer < 3) {
            layer++;
        }
    }

    public void chooseBatter(String flavor) {
        batter = flavor;
    }

    public void addFrosting(String flavor) {
        if (frosting != null){
            frosting = flavor;
        }
        frostingAmt++;
    }

    public void addTopping(String top) {
        if (topping != null){
            topping = top;
        }
        toppingAmt++;
    }

    public int calculateRating() {
        if (batter.equals(correctBat)){
            rating++;
        }

        if (layer == correctLayer) {
            rating++;
        }

        if (frosting.equals(correctFrost)) {
            rating++;
        }

        if (frostingAmt == correctFrostAmt) {
            rating++;
        }

        if (toppingAmt == correctTopAmt) {
            rating++;
        }

        if (toppingAmt == correctTopAmt) {
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
