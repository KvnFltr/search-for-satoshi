
/**
 * Créé des items dans une pièce
 *
 * @author K.FELTRIN
 * @version 11/04/2023
 */
public class Item
{
    private String aItemDescription; // Description de l'objet
    private double aItemWeight; // Poids de l'objet en kilogrammes
    private String aItemName; // Nom de l'item
    
    /**
     * Constructeur de la classe Item.
     * @param pItemName Nom de l'item
     * @param pItemDescription Description de l'item
     * @param pItemWeight Poids de l'item
     */
    public Item(final String pItemName, final String pItemDescription, final double pItemWeight)
    {
        this.aItemName = pItemName;
        this.aItemDescription = pItemDescription;
        this.aItemWeight = pItemWeight;
    }// Item ()
    
    /**
     * Accesseur du nom de l'item
     * 
     * @return Nom de l'item
     */
    public String getItemName()
    {
        return this.aItemName;
    }// getName ()
    
    /**
     * Renvoie la description de l'objet.
     * @return La description de l'objet.
     */
    public String getDescription()
    {
        return this.aItemDescription;
    }//getDescription()
    
    /**
     * Renvoie le poids de l'objet.
     * @return Le poids de l'objet en kilogrammes.
     */
    public double getItemWeight()
    {
        return this.aItemWeight;
    }//getWeight()
    
    /**
     * Renvoie une description complète de l'objet, incluant sa description et son poids.
     * @return Une chaîne de caractères contenant la description de l'objet et son poids en kilogrammes.
     */
    public String getItemDescription()
    {
        return this.aItemDescription + " and it weighs " + this.aItemWeight + " kg.";
    }
}
