public class krono {
    private int quantity;

    public void addKrono(int quantity) {
        this.quantity += quantity;
    }   

    public void resetKrono() {
        this.quantity = 0;
    }

    public void removeKrono (int quantity) {
        this.quantity -= quantity;
    }

    public int getKrono() {
        return this.quantity;
    }
}
