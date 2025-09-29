import java.util.HashMap;

/**
 * Classe représentant une porte.
 * @author  K.Feltrin
 * @version 16/05/2023
 */
public class Door {
    private Item[] aKeys; // Les clés nécessaires pour ouvrir la porte
    private boolean aLocked; // Indique si la porte est verrouillée ou non

    /**
     * Constructeur par défaut de la porte.
     * La porte est initialement déverrouillée.
     */
    public Door() {
        this.aLocked = false;
    }

    /**
     * Définit les clés nécessaires pour ouvrir la porte.
     *
     * @param pKeys Les clés nécessaires pour ouvrir la porte.
     */
    public void setNecessaryKeys(final Item[] pKeys) {
        this.aKeys = pKeys;
    }

    /**
     * Récupère les clés nécessaires pour ouvrir la porte.
     *
     * @return Les clés nécessaires pour ouvrir la porte.
     */
    public Item[] getKeys() {
        return aKeys;
    }

    /**
     * Vérifie si la porte est verrouillée.
     *
     * @return true si la porte est verrouillée, sinon false.
     */
    public boolean isLocked() {
        return aLocked;
    }

    /**
     * Définit l'état de verrouillage de la porte.
     *
     * @param pLocked true pour verrouiller la porte, false pour déverrouiller la porte.
     */
    public void setLocked(boolean pLocked) {
        this.aLocked = pLocked;
    }

    /**
     * Tente de déverrouiller la porte en utilisant les clés présentes dans l'inventaire.
     *
     * @param pInventory L'inventaire contenant les clés.
     * @return true si la porte a été déverrouillée avec succès, sinon false.
     */
    public boolean tryToUnlock(HashMap<String, Item> pInventory) {
        for (Item vKey : aKeys) {
            if (!pInventory.containsValue(vKey)) {
                return false; // Si une clé nécessaire est manquante dans l'inventaire, retourne false.
            }
        }
    
        this.aLocked = false; // Déverrouille la porte en mettant aLocked à false.
        return true; // La porte a été déverrouillée avec succès.
    }
}
