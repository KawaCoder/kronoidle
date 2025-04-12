public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Krono k = new Krono();
        notifierKrono not = new notifierKrono(1000);
        k.setActionListener(not);
        System.out.println(k.getKrono());

        k.addKrono(10000);
        k.removeKrono(3);
        System.out.println(k.getKrono());

    }
}
