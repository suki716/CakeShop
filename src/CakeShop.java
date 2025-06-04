public class CakeShop {
    private int dayNum;
    private int totalMoney;
    private int totalStars;
    private int customerNum;

    public CakeShop() {
        CakeHelper.initializeLists();
    }

    public Ingredient spinWheel(){
        return CakeHelper.addRandomIngredient();
    }

    //increment cakeShop vars
    public void addMoney(int profit){
        totalMoney += profit;
    }

    public void addStars(int stars){
        totalStars += stars;
    }

    public void addCustomer(){
        customerNum++;
    }

    public void spin(){
        totalMoney -= 100;
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

    public double avgRating(){
        return (double) totalStars / customerNum;
    }
}
