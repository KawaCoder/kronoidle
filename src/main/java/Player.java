/**
 * Represents a player.
 *
 * @author clickaddict
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    private int level;
    private KronoCounter k = new KronoCounter();
    private Map<Item, Integer> purchasedItems = new HashMap<>();

    /**
     * Buys an upgrade.
     */
    public void buyupgrade() {
        System.out.println("buy upgrade");
    }

    /**
     * Displays the current statistics of the player.
     */
    public void showstats() {
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
        return this.k;
    }

    /**
     * Returns the map of items purchased by the player.
     *
     * @return the map of items purchased by the player.
     */
    public Map<Item, Integer> getItems() {
        return this.purchasedItems;
    }

    /**
     * Adds an item to the purchased items.
     *
     * @param item the item to add.
     */
    public void addItem(Item item) {
        purchasedItems.put(item, purchasedItems.getOrDefault(item, 0) + 1);
    }

    /**
     * Returns the quantity of a specific item purchased by the player.
     *
     * @param item the item to check.
     * @return the quantity of the item purchased.
     */
    public int getItemQuantity(Item item) {
        return purchasedItems.getOrDefault(item, 0);
    }
}