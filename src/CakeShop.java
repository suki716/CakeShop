public class CakeShop {
    private double totalProfit;
    private int level;
    private int avgRating;
    private Day day;

    public CakeShop() {
        CakeHelper.initializeLists();
    }

    public Cake startDay() { //starting a new day
        day = new Day();
        return day.start();
    }

    public Day getDay() {
        return day;
    }

    public void spinWheel(){
        CakeHelper.addRandomIngredient();
    }
}
