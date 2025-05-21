public class Ingredient {
    private boolean locked;
    private double cost;
    private String name;

    public Ingredient(String name, double cost, boolean locked) {
        this.name = name;
        this.cost = cost;
        this.locked = locked;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public boolean getLocked() {
        return locked;
    }

    public void unLocked() {
        locked = false;
    }
}
