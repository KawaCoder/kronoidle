/**
 * Represents a game upgrade.
 * 
 * @author clickaddict
 */
public class Upgrades {
    private String name;
    private int cost;
    private int effect;
    private boolean disposable;
    Krono k;
    
    /**
     * Constructor for the Upgrades class.
     * 
     * @param k the Krono counter.
     */
    public Upgrades(Krono k) {
        this.k = k;
    }

    /**
     * Activates the upgrade if the player has enough Krono.
     */
    public void activer() {
        if (disposable) {
            k.removeKrono(cost);
        }
    }

    /**
     * Checks if the upgrade is available based on the player's Krono count.
     */
    public void getdisponible() {
        if (k.getKrono() >= cost) {
            disposable = true;
        } else {
            disposable = false;
        }
    }

}