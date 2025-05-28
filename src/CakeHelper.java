import java.util.ArrayList;

class CakeHelper {
    //original
    public static ArrayList<Ingredient> batters;
    public static ArrayList<Ingredient> frosting;
    public static ArrayList<Ingredient> toppings;

    //additional
    private static ArrayList<Ingredient> newBatters;
    private static ArrayList<Ingredient> newFrosting;
    private static ArrayList<Ingredient> newToppings;

    public static void initializeLists() {
        //initial batter
        batters = new ArrayList<>();
        Ingredient vanillaBatter = new Ingredient("vanilla", 1, false);
        Ingredient chocoBatter = new Ingredient("chocolate", 1, false);
        Ingredient stbBatter = new Ingredient("strawberry", 1, false);
        batters.add(vanillaBatter);
        batters.add(chocoBatter);
        batters.add(stbBatter);

        //initial frosting Ingredient
        frosting = new ArrayList<>();
        Ingredient vanillaFrost = new Ingredient("vanilla", 1, false);
        Ingredient chocoFrost = new Ingredient("chocolate", 1, false);
        Ingredient stbFrost = new Ingredient("strawberry", 1, false);
        frosting.add(vanillaFrost);
        frosting.add(chocoFrost);
        frosting.add(stbFrost);

        //initial toppings
        toppings = new ArrayList<>();
        Ingredient candle = new Ingredient("candles", 1, false);
        Ingredient strawberries = new Ingredient("strawberries", 1, false);
        Ingredient chocolateBar = new Ingredient("chocolate bars", 1, false);
        toppings.add(candle);
        toppings.add(strawberries);
        toppings.add(chocolateBar);

        //additional batters
        newBatters = new ArrayList<>();
        Ingredient lemonBatter = new Ingredient("lemon",1, true);
        Ingredient matchaBatter = new Ingredient("matcha",1, true);
        newBatters.add(lemonBatter);
        newBatters.add(matchaBatter);

        //additional frostings
        newFrosting = new ArrayList<>();
        Ingredient peppermintFrost = new Ingredient("peppermint",1, true);
        Ingredient peachFrost = new Ingredient("peach", 1, false);
        newFrosting.add(peppermintFrost);
        newFrosting.add(peachFrost);

        //additional toppings
        newToppings = new ArrayList<>();
        Ingredient cinnamon = new Ingredient("cinnamonStick", 1, true);
        Ingredient leaf = new Ingredient("leaf",1, true);
        newToppings.add(cinnamon);
        newToppings.add(leaf);
    }

    public static void addRandomIngredient(){
        int randomCategory = (int) (Math.random() * 3);
        boolean valid = false;
        while (!valid) {
            if (randomCategory == 0 && !isFull(batters)) {
                int randomItem = (int) (Math.random() * newBatters.size());
                batters.add(newBatters.remove(randomItem));
                valid = true;
            } else if (randomCategory == 1 && !isFull(frosting)) {
                int randomItem = (int) (Math.random() * newFrosting.size());
                frosting.add(newFrosting.remove(randomItem));
                valid = true;
            } else if (randomCategory == 2 && !isFull(toppings)) {
                int randomItem = (int) (Math.random() * newToppings.size());
                toppings.add(newToppings.remove(randomItem));
                valid = true;
            }
        }
    }

    public static Cake randomCake(){
        int randomB = (int) (Math.random() * batters.size());
        String randomBatter = batters.get(randomB).getName();
        int randomF = (int) (Math.random() * frosting.size());
        String randomFrosting = frosting.get(randomF).getName();
        int randomT = (int) (Math.random() * toppings.size());
        String randomTopping = toppings.get(randomT).getName();
        int randomLayer = (int) (Math.random() * 3) + 1;
        int randomFrostingNum = (int) (Math.random() * 8) + 1;
        int randomToppingNum = (int) (Math.random() * 8) + 2;
        return new Cake(randomBatter, randomLayer, randomFrosting, randomFrostingNum, randomTopping, randomToppingNum);
    }

    private static boolean isFull(ArrayList<Ingredient> list){
        return list.size() == 5;
    }

}