import java.util.HashMap;
import java.util.Set;

/**
 * Liste des objets dans une localisation spécifique.
 * Permet de gérer les objets présents dans une localisation donnée.
 */
public class ItemList {
    private HashMap<String, Item> aItems; // HashMap pour stocker les objets (clé : nom de l'objet, valeur : objet lui-même)
    private String aLocation; // Localisation des objets

    /**
     * Constructeur de la classe ItemList.
     *
     * @param pLocation La localisation des objets.
     */
    public ItemList(final String pLocation) {
        this.aItems = new HashMap<String, Item>();
        this.aLocation = pLocation;
    }

    /**
     * Récupère un objet spécifique par son nom.
     *
     * @param pItem Le nom de l'objet à récupérer.
     * @return L'objet correspondant au nom spécifié, ou null s'il n'existe pas.
     */
    public Item getItem(final String pItem) {
        return this.aItems.get(pItem);
    }

    /**
     * Récupère la liste complète des objets dans la localisation.
     *
     * @return La HashMap contenant les objets (clé : nom de l'objet, valeur : objet lui-même).
     */
    public HashMap<String, Item> getItems() {
        return aItems;
    }
    
    /**
     * Retourne une chaîne de caractères représentant les objets présents dans la localisation.
     *
     * @return La chaîne de caractères représentant les objets dans la localisation, ou un message indiquant qu'il n'y a pas d'objets.
     */
    public String getItemString() {
        if (this.aItems.isEmpty()) {
            return "There is no items here.";
        }
    
        StringBuilder vChaine = new StringBuilder();
    
        // Itération sur les clés de la HashMap pour obtenir les noms des objets
        for (String vName : this.aItems.keySet()) {
            vChaine.append(" " + vName);
        }
    
        // Construction de la chaîne de caractères finale en ajoutant la phrase de localisation
        return "Items in " + this.aLocation + ":" + vChaine.toString();
    }

    /**
     * Ajoute un nouvel objet à la liste.
     *
     * @param pItemName Le nom de l'objet à ajouter.
     * @param pItem     L'objet à ajouter.
     */
    public void addItem(final String pItemName, final Item pItem) {
        this.aItems.put(pItemName, pItem);
    }

    /**
     * Supprime un objet de la liste par son nom.
     *
     * @param pItemName Le nom de l'objet à supprimer.
     */
    public void removeItem(final String pItemName) {
        this.aItems.remove(pItemName);
    }

    /**
     * Calcule le poids total des objets dans la liste.
     *
     * @return Le poids total des objets.
     */
    public double getTotalWeight() {
        double vTotalWeight = 0;
    
        // Itération sur les clés de la HashMap pour obtenir les noms des objets
        for (String vItemName : this.aItems.keySet()) {
            // Obtention de l'objet correspondant à la clé et ajout de son poids au poids total
            vTotalWeight += getItem(vItemName).getItemWeight();
        }
    
        return vTotalWeight;
    }
}
