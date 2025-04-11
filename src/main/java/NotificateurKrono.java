public class NotificateurKrono implements ActionListener {

    private final int seuilAction;


    /**
     * Constructeur de la classe NotificateurKrono.
     * 
     * @param seuilAction le seuil de Krono à partir duquel l'utilisateur sera notifié.
     */
    public NotificateurKrono(int seuilAction) {
        this.seuilAction = seuilAction;
    }

    /**
     * Méthode appelée lorsque le nombre de Krono change.
     * 
     * @param nouveauKrono le nouveau nombre de Krono.
     */
    @Override
    public void onKronoChanged(int nouveauKrono) {
        // Si le nombre de Krono atteint ou dépasse le seuil
        if (nouveauKrono >= seuilAction) {

            System.out.println("Vous pouvez maintenant effectuer une action ! (Krono atteint " + nouveauKrono + ")");
        }
    }
}