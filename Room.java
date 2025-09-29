import java.util.HashMap;
import java.util.Set;

 /**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Kévin FELTRIN
 * @version 15/02/2023
 */
public class Room
{
    // Une chaîne de caractères pour stocker la description de la pièce
    private String aDescription;

    // Une table de hachage pour stocker les sorties de la pièce sous forme de paires direction/pièce
    private HashMap <String, Room> aExits;
    
    //Le nom de l'image utilisé pour chaque pièce;
    private String aImageName;
    private ItemList aItemList;
    private Door aDoor;
    
    /**
     * Crée une nouvelle pièce avec une description donnée.
     * @param pDescription La description de la pièce.
     * @param pImage Le nom de l'image utilisée pour chaque pièce.
     */
    public Room(final String pDescription, final String pImage)
    {
        // Initialise la variable de description avec la valeur donnée en paramètre
        this.aDescription = pDescription;
        
        // Initialise la table de hachage des sorties avec une nouvelle instance de HashMap
        this.aExits = new HashMap <String, Room>();
        this.aImageName = pImage;
        this.aItemList = new ItemList ("the room");
        this.aDoor = new Door();
    }//Room()
    
    /**
     * Retourne la description de la pièce.
     *
     * @return la description de la pièce
     */
    public String getDescription()
    {
        // Retourne la valeur actuelle de la variable de description
        return this.aDescription;
    } // getDescription()
    
    /**
     * Définit une sortie de la pièce dans une direction donnée.
     *
     * @param pDirection la direction de la sortie
     * @param pNeighbor la pièce voisine vers laquelle la sortie mène
     */
    public void setExit( final String pDirection, final Room pNeighbor)
    {
      // Stocke la pièce voisine dans la table de hachage des sorties, associée à la direction donnée
      this.aExits.put(pDirection, pNeighbor);
    } // setExit()
    
    /**
     * Retourne la pièce voisine atteignable dans une direction donnée.
     *
     * @param pDirection la direction de la sortie
     * @return la pièce voisine dans la direction donnée, ou null si aucune pièce voisine n'a été définie pour cette direction
     */
    public Room getExit(final String pDirection)
    {
      // Retourne la pièce associée à la direction donnée dans la table de hachage des sorties, ou null si aucune pièce n'a été définie pour cette direction
      return this.aExits.get(pDirection);
    }//getExit()
    
    /**
     * Retourne une chaîne de caractères représentant les sorties possibles depuis la pièce courante.
     *
     * @return La chaîne de caractères représentant les sorties possibles depuis la pièce courante.
     */
    public String getExitString() {
        // Utilisation de StringBuilder pour construire la chaîne de caractères de sortie.
        StringBuilder vExitString = new StringBuilder("Exits:");
    
        // Boucle sur les clés de la table de hachage des sorties pour les ajouter à la chaîne de caractères de sortie.
        for (String vExit : this.aExits.keySet()) {
            vExitString.append(" ").append(vExit);
        }
    
        // Retourne la chaîne de caractères de sortie.
        return vExitString.toString();
    }

    /**
     * Retourne une description complète de la pièce, incluant sa description courte
     * ainsi que les sorties disponibles.
     *
     * @return La description complète de la pièce.
     */
    public String getLongDescription() 
    {
      // Concatène la description courte avec une chaîne contenant la liste des sorties.
      // On utilise la méthode getExitString() pour générer cette liste.
      String vLongDescription = "\n"+"You are " + this.aDescription + ".\n" + getExitString() + "\n" + this.aItemList.getItemString() + "\n";

      // Retourne la description complète de la pièce.
      return vLongDescription;
    }
    
    /**
     * Obtient le nom de l'image.
     * @return le nom de l'image
     */
    public String getImageName()
    {
        return this.aImageName;
    }
    
    /**
     * Accesseur de la liste de items de la pièce
     * 
     * @return Liste d'items de la pièce
     */
    public ItemList getRoomItems ()
    {
        return this.aItemList;
    }// getRoomItems ()
    
    /**
     * Vérifie si la pièce donnée en argument est une sortie de la pièce courante.
     *
     * @param pExit La pièce à vérifier.
     * @return true si la pièce donnée est une sortie de la pièce courante, false sinon.
     */
    public boolean isExit(final Room pExit) {
        // Vérifie si la pièce donnée en argument est contenue dans la liste des sorties de la pièce courante.
        return this.aExits.values().contains(pExit);
    }
    
    public Door getDoor() {
        return this.aDoor;
    }
} // Room
