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
        layer = 1;
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
        System.out.println(batter);
    }

    public void chooseFrosting(String flavor) {
        frosting = flavor;
        System.out.println(frosting);
    }

    public void addFrosting() {
        frostingAmt++;
    }

    public void chooseTopping(String top) { topping = top; }

    public void addTopping() {
        toppingAmt++;
    }

    public int calculateRating() {
        if (batter.equals(correctBat)){
            rating++;
            System.out.println(batter);
            System.out.println("correct Batter");
        }

        if (layer == correctLayer) {
            rating++;
            System.out.println(layer);
            System.out.println("correct layer");
        }

        if (frosting.equals(correctFrost)) {
            rating++;
            System.out.println(frosting);
            System.out.println("correct frsoting");
        }

        if (frostingAmt == correctFrostAmt) {
            rating++;
            System.out.println(frostingAmt);
            System.out.println("correct frosting amt");
        }

        if (toppingAmt == correctTopAmt) {
            rating++;
            System.out.println(toppingAmt);
            System.out.println("correct topping amt");
        }

        if (topping.equals(correctTop)) {
            rating++;
            System.out.println(topping);
            System.out.println("correct topping");
        }
        System.out.println(rating);
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
