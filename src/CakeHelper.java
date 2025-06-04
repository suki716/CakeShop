import java.util.ArrayList;

class CakeHelper {
    //original
    public static ArrayList<Ingredient> batters;
    public static ArrayList<Ingredient> frosting;
    public static ArrayList<Ingredient> toppings;

    //additional
    private static Ingredient lemonBatter = new Ingredient("lemon",1, true);
    private static Ingredient matchaBatter = new Ingredient("matcha",1, true);

    private static Ingredient peppermintFrost = new Ingredient("peppermint",1, true);
    private static Ingredient peachFrost = new Ingredient("peach", 1, false);

    private static Ingredient cinnamon = new Ingredient("cinnamon", 1, true);
    private static Ingredient leaf = new Ingredient("leaf",1, true);


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
    }

    public static Ingredient addRandomIngredient() {
        ArrayList<Integer> availableCategories = new ArrayList<>();
        if (!isFull(batters)) {
            availableCategories.add(0);
        }
        if (!isFull(frosting)) {
            availableCategories.add(1);
        }
        if (!isFull(toppings)) {
            availableCategories.add(2);
        }
        if (availableCategories.isEmpty()) {
            return null;
        }
        int randomCategory = availableCategories.get((int) (Math.random() * availableCategories.size()));
        Ingredient newIngredient = null;
        if (randomCategory == 0) {
            if (!batters.contains(lemonBatter)) {
                newIngredient = lemonBatter;
                batters.add(lemonBatter);
            } else if (!batters.contains(matchaBatter)) {
                newIngredient = matchaBatter;
                batters.add(matchaBatter);
            }
        } else if (randomCategory == 1) {
            if (!frosting.contains(peppermintFrost)) {
                newIngredient = peppermintFrost;
                frosting.add(peppermintFrost);
            } else if (!frosting.contains(peachFrost)) {
                newIngredient = peachFrost;
                frosting.add(peachFrost);
            }
        } else if (randomCategory == 2) {
            if (!toppings.contains(cinnamon)) {
                newIngredient = cinnamon;
                toppings.add(cinnamon);
            } else if (!toppings.contains(leaf)) {
                newIngredient = leaf;
                toppings.add(leaf);
            }
        }
        if (newIngredient != null) {
            System.out.println("Added " + newIngredient.getName());
        } else {
            System.out.println("all added!");
        }
        return newIngredient;
    }

    public static Cake randomCake(){
        int randomB = (int) (Math.random() * batters.size());
        String randomBatter = batters.get(randomB).getName();
        int randomF = (int) (Math.random() * frosting.size());
        String randomFrosting = frosting.get(randomF).getName();
        int randomT = (int) (Math.random() * toppings.size());
        String randomTopping = toppings.get(randomT).getName();
        int randomLayer = (int) (Math.random() * 2) + 1;
        int randomFrostingNum = (int) (Math.random() * 8) + 1;
        int randomToppingNum = (int) (Math.random() * 8) + 2;
        return new Cake(randomBatter, randomLayer, randomFrosting, randomFrostingNum, randomTopping, randomToppingNum);
    }

    public static boolean isFull() {
        if (isFull(toppings) && isFull(batters) && isFull(frosting)) {
            return true;
        }
        return false;
    }

    private static boolean isFull(ArrayList<Ingredient> list){
        return list.size() == 5;
    }

}
