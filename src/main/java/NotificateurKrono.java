public class NotificateurKrono implements ActionListener {

    private final int seuilAction;


    public NotificateurKrono(int seuilAction) {
        this.seuilAction = seuilAction;
    }

    @Override
    public void onKronoChanged(int nouveauKrono) {
        // Si le nombre de Krono atteint ou dépasse le seuil
        if (nouveauKrono >= seuilAction) {

            System.out.println("Vous pouvez maintenant effectuer une action ! (Krono atteint " + nouveauKrono + ")");
        }
    }
}
