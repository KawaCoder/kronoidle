public class notifierKrono implements ActionListener {

    private final int trigger;


    /**
     * Constructor for the KronoNotifier class.
     * 
     * @param trigger the Krono threshold at which the user will be notified.
     */
    public notifierKrono(int trigger) {
        this.trigger = trigger;
    }

    /**
     * Method called when the Krono count changes.
     * 
     * @param nouveauKrono the new Krono count.
     */
    @Override
    public void onKronoChanged(int nouveauKrono) {
        // If the Krono count reaches or exceeds the threshold
        if (nouveauKrono >= trigger) {

            System.out.println("You can now perform an action! (Krono reached " + nouveauKrono + ")");
        }
    }
}