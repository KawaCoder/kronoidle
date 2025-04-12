/**
 * Represents a player.
 * 
 * @author clickaddict
 */
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int level;
    private KronoCounter k = new KronoCounter();
    private List<Item> purchasedItems = new ArrayList<>();

    /**
     * Buys an upgrade.
     */
    public void buyupgrade() {
        //k.removeKrono();
        System.out.println("buy upgrade");
    }

    /**
     * Displays the current statistics of the player.
     * 
     * @param level the current level of the player.
     */
    public void showstats(int level) {
        System.out.println("Level : " + this.level);
        System.out.println("Krono : " + k.getKrono());
        System.out.println("Purchased Items: " + purchasedItems.size());
    }

    /**
     * Returns the current level of the player.
     * 
     * @return the current level of the player.
     */
    public int getlevel() { return this.level; }

/**
 * Returns the current quantity of Krono the player has.
 *
 * @return the user's KronoCounter.
 */
public KronoCounter getKrono() {
    return k;
}

    /**
     * Adds an item to the purchased items.
     * 
     * @param item the item to add.
     */
    public void addItem(Item item) {
        purchasedItems.add(item);
    }
}