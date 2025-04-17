import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Krono Idle!");
        Player p = new Player();
        List<Item> items = ItemLoader.loadItems();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Buy an item");
            System.out.println("2: Set the Krono balance");
            System.out.println("3: Show purchased items");
            System.out.println("4: Quit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    System.out.println("Choose an item to buy:");
                    int i = 1;
                    for (Item item : items) {
                        System.out.println(i + ": " + item.getName());
                        if (item.isAvailable(p.getKrono())) {
                            System.out.println("  Available");
                        } else {
                            System.out.println("  Not available");
                        }
                        i++;
                    }
                    System.out.print("Your choice: ");
                    int itemChoice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (items.get(itemChoice).isAvailable(p.getKrono())) {
                        p.addItem(items.get(itemChoice));
                        p.getKrono().removeKrono(items.get(itemChoice).getCost());
                    } else {
                        System.out.println("You don't have enough Krono to buy that item.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the Krono balance: ");
                    int balance = Integer.parseInt(scanner.nextLine());
                    p.getKrono().resetKrono();
                    p.getKrono().addKrono(balance);
                    break;
                case 3:
                    System.out.println("Purchased items:");
                    for (Item item : p.getItems().keySet()) {
                        System.out.println(item.getName() + " x" + p.getItemQuantity(item));
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }
}