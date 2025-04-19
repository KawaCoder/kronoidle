/**
 * Represents a game upgrade.
 * 
 * @author clickaddict
 */
public class Upgrade {
    private String name;
    private int cost;
    private int effect;
    private boolean available;

    /**
     * Checks if the upgrade is available based on the player's Krono count.
     */
    public boolean isAvailable(KronoCounter k) {
        return(k.getKrono() >= this.cost);
    }

    public Upgrade(String name, int cost, int effect) {
        this.name = name;
        this.cost = cost;
        this.effect = effect;
        this.available = true;
    }

}