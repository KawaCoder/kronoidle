public class Krono {
    private int quantity;

    /**
     * Increases the quantity of Krono by the given amount
     * @param quantity the amount to increase by
     */
    public void addKrono(int quantity) {
        this.quantity += quantity;
    }   


    public void resetKrono() {
        this.quantity = 0;
    }

    /**
     * Subtracts the given quantity from the current quantity of krono.
     *
     * @param quantity the amount of krono to remove.
     */
    public void removeKrono (int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Returns the current quantity of krono.
     *
     * @return the current quantity of krono as an integer.
     */

    public int getKrono() {
        return this.quantity;
    }
}
