public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Krono k = new Krono();
        NotificateurKrono notificateur = new NotificateurKrono(1000);
        k.setActionListener(notificateur);

        k.addKrono(10);
        System.out.println(k.getKrono());
        k.removeKrono(3);
        System.out.println(k.getKrono());

    }
}
