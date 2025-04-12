public class Item {

    private String name;
    private String description; // Description of the item
    private int cost;           // Cost of the item in Krono

    private int kronoMult;

    public Item(String name, String description, int cost, int kronoMult) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.kronoMult = kronoMult;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public double getKronoMult() {
        return kronoMult;
    }

    // Apply the item's effect to the player
    public void applyMult(Player player) {
        player.getKrono().addToMult(this.kronoMult);
        System.out.println("The effect of item " + name + " is applied. Bonus: " + kronoMult + " Krono per second.");
    }
}
