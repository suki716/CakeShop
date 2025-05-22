import java.util.ArrayList;

class CakeHelper {
    public static ArrayList<Ingredient> flavors;
    public static ArrayList<Ingredient> frosting;
    public static ArrayList<Ingredient> toppings;
    public static ArrayList<Ingredient> decoration;

    public static void initializeLists() {
        //initial batter
        flavors = new ArrayList<>();
        Ingredient vanillaBatter = new Ingredient("vanilla", 1, false);
        Ingredient chocoBatter = new Ingredient("chocolate", 1, false);
        Ingredient stbBatter = new Ingredient("strawberry", 1, false);
        flavors.add(vanillaBatter);
        flavors.add(chocoBatter);
        flavors.add(stbBatter);

        //initial frosting Ingredient
        frosting = new ArrayList<>();
        Ingredient vanillaFrost = new Ingredient("vanilla", 1, false);
        Ingredient chocoFrost = new Ingredient("chocolate", 1, false);
        Ingredient stbFrost = new Ingredient("strawberry", 1, false);
        frosting.add(vanillaFrost);
        frosting.add(chocoFrost);
        frosting.add(stbFrost);

        //initial toppings
        Ingredient candle = new Ingredient("candle", 1, false);
        Ingredient strawberries = new Ingredient("strawberry", 1, false);
        Ingredient chocolateBar = new Ingredient("chocolate", 1, false);
        toppings.add(candle);
        toppings.add(strawberries);
        toppings.add(chocolateBar);

        //initial decorations
    }

    public static void addRandom(){
        int randomCategory = (int) (Math.random() * 3);
        if (randomCategory == 0){
            
        } else if (randomCategory == 1){

        } else if (randomCategory == 2){

        }
    }

}