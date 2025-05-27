public class CakeShop {
    private int dayNum;
    private int totalMoney;
    private int totalStars;
    private int customerNum;

    public CakeShop() {
        CakeHelper.initializeLists();
    }

    public void spinWheel(){
        CakeHelper.addRandomIngredient();
    }

    //increment cakeShop vars
    public void addMoney(Day day){
        totalMoney += day.getProfit();
    }

    public void addStars(Day day){
        totalStars += day.getStars();
    }

    public void addCustomer(){
        customerNum++;
    }

    //get stats
    public int getTotalMoney(){
        return totalMoney;
    }

    public int getCustomerNum(){
        return customerNum;
    }

    public int getTotalStars(){
        return totalStars;
    }

    public int getDayNum(){
        return dayNum;
    }

    public double getAccuracy(){
        return ((double) totalStars / (customerNum * 5)) * 100;
    }

    public double avgRating(){
        return (double) totalStars / customerNum;
    }
}
