public class Cake { //comparing correctness
    private final int MAX_LAYERS = 4;
    private int rating = 0;
    //correct recipe
    public static String correctBat;
    public static int correctLayer;
    public static String correctFrost;
    public static int correctFrostAmt;
    public static String correctTop;
    public static int correctTopAmt;
    //what you made
    private String batter;
    private int layer;
    private String frosting;
    private int frostingAmt;
    private String topping;
    private int toppingAmt;

    //initializing correct customer cake
    public Cake(String batter, int layer, String frosting, int frostAmt, String topping, int toppingAmt) {
        correctBat = batter;
        correctLayer = layer;
        correctFrost = frosting;
        correctFrostAmt = frostAmt;
        correctTop= topping;
        correctTopAmt = toppingAmt;
    }

    public Cake() {
        batter = "";
        layer = 1;
        frosting = "";
        frostingAmt = 0;
        topping = "";
        toppingAmt = 0;
    }


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
        layer++;
    }

    public void chooseBatter(String flavor) {

            batter = flavor;

    }

    public void chooseFrosting(String flavor) {
        if(flavor != null){
            frosting = flavor;
        }
    }

    public void addFrosting() {
        frostingAmt++;
    }

    public void chooseTopping(String top) {
        if (top != null) {
            topping = top;
        }
    }

    public void addTopping() {
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

        if (topping.equals(correctTop)) {
            rating++;
        }
        return rating;
    }

    public int calculateProfit() {
        int profit = rating * 10;
        if (rating >= 5) {
            profit += 5;
        }
        if (rating <= 3) {
            profit -= 5;
        }
        System.out.println();
        return profit;
    }
}
