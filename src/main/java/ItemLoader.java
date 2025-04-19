import java.util.ArrayList;
import java.util.List;

public class ItemLoader {
    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Campfire", "A cozy place where the tribe can meet and rest.", 1, 0.001));
        items.add(new Item("Stone Tools", "Simple tools made from stone.", 5, 0.002));
        items.add(new Item("Animal Trap", "A primitive contraption to catch animals.", 10, 0.005));
        items.add(new Item("Tribal Hut", "A temporary shelter for the tribe.", 20, 0.01));
        items.add(new Item("Le gros paf à nathan", "a huge weapon for the tribe", 69, 420));
        items.add(new Item("Magnaud le gros", "Be careful with this one", 1000, 666));

        return items;
    }

}
