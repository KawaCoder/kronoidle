/**
 * Represents a game upgrade.
 * 
 * @author clickaddict
 */
public class Upgrade {
    private String name;
    private int cost;

    /**
     * Checks if the upgrade is available based on the player's Krono count.
     */
    public boolean isAvailable(KronoCounter k) {
        return(k.getKrono() >= this.cost);
    }

}