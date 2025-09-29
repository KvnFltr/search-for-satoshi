
/**
 * Classe représentant un Beamer, héritant de la classe Item.
 * Un Beamer est un objet pouvant stocker la référence d'une pièce chargée.
 *
 * @author Kévin Feltrin
 * @version 27/04/2023
 */
public class Beamer extends Item
{
    private Room aSavedRoom; // La pièce chargée par le Beamer.
    
    /**
     * Constructeur de la classe Beamer.
     * @param pItemName Le nom de l'objet.
     * @param pItemDescription La description de l'objet.
     * @param pItemWeight Le poids de l'objet.
     */
    public Beamer(final String pItemName, final String pItemDescription, final double pItemWeight)
    {
        super(pItemName, pItemDescription, pItemWeight);
    }// Beamer ()
    
    /**
     * Getter pour la pièce chargée par le Beamer.
     * @return La pièce chargée par le Beamer.
     */
    public Room getChargedRoom ()
    {
        return this.aSavedRoom;
    }// getChargedRoom ()
    
    /**
     * Setter pour la pièce chargée par le Beamer.
     * @param pRoom La pièce à charger dans le Beamer.
     */
    public void setChargedRoom (final Room pRoom)
    {
        this.aSavedRoom = pRoom;
    }// setChargedRoom ()
    
    /**
     * Indique si le Beamer est chargé (c'est-à-dire si une pièce y est stockée).
     * @return Vrai si une pièce est chargée dans le Beamer, faux sinon.
     */
    public boolean isCharged ()
    {
        return this.aSavedRoom != null;
    }// isCharged ()
}// Beamer
