import java.util.Stack;
import java.util.HashMap;

/**
 * La classe Player représente un joueur qui se déplace dans un jeu à travers des pièces.
 *
 * @author K. FELTRIN
 * @version 11/04/2023
 */

public class Player {

    private String aPseudo; // Pseudonyme du joueur
    private Room aCurrentRoom; // Pièce actuelle
    private Stack<Room> aPreviousRooms; // Pile des pièces précédentes
    private ItemList aItemList;
    private double aWeight;
    private double aMaxWeight;
    private int aTime;
    
    /**
     * Constructeur naturel de la classe Player.
     *
     * @param pPseudo     le pseudonyme du joueur.
     * @param pCurrentRoom la pièce de départ du joueur.
     * @param pTime la limite des mouvements du du joueur.
     */
    public Player(final String pPseudo, final Room pCurrentRoom, final int pTime) {
        this.aPseudo = pPseudo;
        this.aCurrentRoom = pCurrentRoom;
        this.aPreviousRooms = new Stack <Room> ();
        this.aItemList = new ItemList ("inventory");
        this.aMaxWeight=4;
        this.aWeight=0;
        this.aTime = pTime;
    }

    /**
     * Retourne le pseudonyme du joueur.
     *
     * @return le pseudonyme du joueur.
     */
    public String getPseudo() {
        return this.aPseudo;
    }

    /**
     * Retourne la pièce actuelle du joueur.
     *
     * @return la pièce actuelle du joueur.
     */
    public Room getCurrentRoom() {
        return this.aCurrentRoom;
    }

    /**
     * Retourne la pile des pièces précédentes visitées par le joueur.
     *
     * @return la pile des pièces précédentes visitées par le joueur.
     */
    public Stack<Room> getPreviousRooms() {
        return this.aPreviousRooms;
    }

    public double getMaxWeight(){
        return this.aMaxWeight;
    }
    
    public void setCurrentRoom (final Room pRoom)
    {
        this.aCurrentRoom = pRoom;
    }// setCurrentRoom ()
    
    /**
     * Permet au joueur de se déplacer d'une pièce à une autre en fonction de la direction indiquée.
     *
     * @param direction la direction de la pièce à atteindre.
     */
    public void goRoom(String direction) {
        // On utilise la méthode getExit() de la pièce actuelle pour récupérer la prochaine pièce.
        Room vNextRoom = this.aCurrentRoom.getExit(direction);
        // On ajoute la pièce actuelle à la pile des pièces précédentes.
        this.aPreviousRooms.push(this.aCurrentRoom);
        // On change la pièce courante par la pièce suivante.
        this.aCurrentRoom = vNextRoom;
        this.aTime--;
    }

    /**
     * Cette méthode permet au joueur de revenir sur ses pas en se déplaçant vers la dernière pièce visitée.
     * Si la dernière pièce visitée est une sortie de la pièce courante, la méthode change la pièce courante par la dernière
     * pièce visitée, diminue le temps restant du joueur de 1 unité et retourne true. Sinon, elle retourne false.
     *
     * @return true si le joueur peut revenir en arrière et se déplace vers la dernière pièce visitée, false sinon.
     */
    public boolean back() {
        // Vérifie si la dernière pièce visitée est bien une sortie de la pièce courante.
        if (this.aCurrentRoom.isExit(this.aPreviousRooms.peek())) {
            // Change la pièce courante par la dernière pièce visitée.
            this.aCurrentRoom = this.aPreviousRooms.pop();
            // Diminue le temps restant du joueur de 1 unité.
            this.aTime--;
            return true;
        }
        // La dernière pièce visitée n'est pas une sortie de la pièce courante.
        return false;
    }
    
    public ItemList getInventory()
    {
        return this.aItemList;
    }
    
    public void take (final Item pItem)
    {
        this.aItemList.addItem(pItem.getItemName(),pItem); // Ajoute à l'inventaire l'item actuellement présent dans la pièce
        this.aCurrentRoom.getRoomItems().removeItem(pItem.getItemName());
    }// take ()
    
    public void drop (final Item pItem)
    {
        this.aCurrentRoom.getRoomItems().addItem(pItem.getItemName(), pItem); // Ajoute l'item actuellement présent dans l'inventaire à la pièce actuelle
        this.aItemList.removeItem(pItem.getItemName());
    }// drop ()
    
    /**
     * Cette méthode calcule le poids total de tous les articles dans le sac à dos.
     * 
     * @return le poids total de tous les articles dans le sac à dos
     */
    public double totalWeight()
    {
        double vTotalWeight = this.aItemList.getTotalWeight(); // Calcule le poids total de tous les articles dans la liste d'articles
        this.aWeight = vTotalWeight; // Met à jour la variable de poids aWeight avec la valeur de total
        return vTotalWeight; // Retourne le poids total
    }
    
    /**
     * Cette méthode détermine si un article peut être ajouté au sac à dos sans dépasser le poids maximum autorisé.
     * 
     * @param vItem l'item proposé à ajouter
     * @return true si l'article peut être ajouté, sinon false
     */
    public boolean canWear(final Item vItem)
    {
        double vCurrentWeight = totalWeight(); // Calcule le poids actuel en appelant la méthode totalWeight()
        double vProposedWeight = vCurrentWeight + vItem.getItemWeight(); // Calcule le poids proposé en ajoutant le poids de l'article proposé
        return vProposedWeight <= this.aMaxWeight; // Retourne un booléen qui indique si l'article peut être porté ou non
    }
    
    public void setMaxWeight(final double pWeight){
        this.aMaxWeight=pWeight;
    }
    
    /**
     * Méthode pour retirer le poids d'un objet de l'inventaire du joueur.
     * @param pWeight Le poids de l'objet à retirer.
     */
    public void removeWeight(final double pWeight) {
        // Soustraire le poids de l'objet du poids total de l'inventaire du joueur
        this.aWeight -= pWeight;
    }
    
    /**
     * Cette méthode renvoie les déplacements restants.
     * @return L'heure actuelle sous forme d'un entier.
     */
    public int getTime(){
        return this.aTime;
    }
    
    /**
     * Charge le beamer en sauvegardant la pièce actuelle comme pièce de destination.
     * Diminue également le temps restant d'une unité.
     *
     * @param pBeamer Le Beamer à charger.
     */
    public void charge(final Beamer pBeamer) {
        // Sauvegarde la pièce actuelle comme destination pour le Beamer
        pBeamer.setChargedRoom(this.aCurrentRoom);
        // Décrémente le temps restant
        this.aTime--;
    }
    
    /**
     * Téléporte le joueur à la pièce où le Beamer a été chargé.
     * Ajoute également la pièce actuelle à la pile de pièces précédentes.
     * Retire le Beamer de l'inventaire du joueur et diminue le poids de l'inventaire en conséquence.
     * Diminue également le temps restant d'une unité.
     *
     * @param pBeamer Le Beamer à utiliser pour la téléportation.
     */
    public void fire(final Beamer pBeamer) {
        // Ajoute la pièce actuelle à la pile de pièces précédentes
        this.aPreviousRooms.push(this.aCurrentRoom);
        // Change la pièce actuelle pour la pièce de destination du Beamer
        this.aCurrentRoom = pBeamer.getChargedRoom();
        // Retire le Beamer de l'inventaire du joueur
        this.aItemList.removeItem(pBeamer.getItemName());
        // Diminue le poids de l'inventaire en conséquence
        this.aWeight -= pBeamer.getItemWeight();
        // Décrémente le temps restant
        this.aTime--;
    }
}

