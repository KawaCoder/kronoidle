/**
 * Représente une amélioration du jeu.
 * 
 * @author clickaddict
 */
public class Upgrades {
    private String name;
    private int cost;
    private int effect;
    private boolean disposable;
    Krono k;
    
    /**
     * Constructeur de la classe Upgrades.
     * 
     * @param k le compteur de Krono.
     */
    public Upgrades(Krono k) {
        this.k = k;
    }

    /**
     * Active l'amélioration si le joueur a suffisamment de Krono.
     */
    public void activer() {
        if (disposable) {
            k.removeKrono(cost);
        }
    }

    /**
     * Vérifie si l'amélioration est disponible en fonction du nombre de Krono du joueur.
     */
    public void getdisponible() {
        if (k.getKrono() >= cost) {
            disposable = true;
        } else {
            disposable = false;
        }
    }

}