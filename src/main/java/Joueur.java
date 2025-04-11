/**
 * Représente un joueur.
 * 
 * @author clickaddict
 */
public class Joueur {

    private int level;
    private Krono k = new Krono();
    private Ressources r = new Ressources();

    /**
     * Achète une amélioration.
     */
    public static void buyupgrade() {
        k.removeKrono();
    }

    /**
     * Affiche les statistiques actuelles du joueur.
     * 
     * @param level le niveau actuel du joueur.
     */
    public void showstats(int level) {
        System.out.println("Level : " + this.level);
        System.out.println("Ressources : " + r.getressourcesquantity());
        System.out.println("Krono : " + k.getKrono());
    }

    /**
     * Retourne le niveau actuel du joueur.
     * 
     * @return le niveau actuel du joueur.
     */
    public int getlevel() { return this.level; }

}