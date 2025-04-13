public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        KronoCounter k = new KronoCounter();
        notifierKrono not = new notifierKrono(1000);
        k.setActionListener(not);
        System.out.println(k.getKrono());

        k.addKrono(10000);
        k.removeKrono(3);
        System.out.println(k.getKrono());

        Player p = new Player();
        System.out.println(p.getlevel());
        p.buyupgrade();
        p.showstats();
        System.out.println(p.getItems());


    }
}
