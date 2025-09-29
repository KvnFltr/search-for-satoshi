
/**
 * La classe TransporterRoom représente une pièce dans un jeu qui transporte aléatoirement le joueur vers une autre pièce lorsqu'il tente de partir.
 * Elle étend la classe Room et utilise un objet RoomRandomizer pour fonctionner.
 * 
 * @author K.FELTRIN
 * @version 30/04/2023
 */
public class TransporterRoom extends Room {
    
    // L'objet RoomRandomizer utilisé pour sélectionner la pièce suivante
    private RoomRandomizer aRoomRandomizer;
    
    /**
     * Construit un objet TransporterRoom avec la description et le nom d'image donnés.
     * 
     * @param pDescription La description de la pièce
     * @param pImageName Le nom de l'image associée à la pièce
     */
    public TransporterRoom(final String pDescription, final String pImageName) {
        super(pDescription, pImageName);
        this.aRoomRandomizer = new RoomRandomizer();
    }// TransporterRoom ()
    
    /**
     * Renvoie une pièce aléatoire en tant que sortie pour la direction donnée.
     * Remplace la méthode getExit de la classe Room.
     * 
     * @param pDirection La direction dans laquelle le joueur souhaite quitter la pièce
     * @return Un objet pièce sélectionné aléatoirement
     */
    @Override
    public Room getExit(final String pDirection) {
        return this.aRoomRandomizer.getRandomRoom();
    }// getExit ()
    
    /**
     * Recherche et renvoie une pièce aléatoire.
     *
     * @return Une pièce aléatoire.
     */
    private Room findRandomRoom(){
        return this.aRoomRandomizer.getRandomRoom();
    }
    
    /**
     * Renvoie l'objet RoomRandomizer utilisé par la pièce TransporterRoom pour sélectionner aléatoirement la pièce suivante.
     * 
     * @return L'objet RoomRandomizer
     */
    public RoomRandomizer getRoomRandomizer() {
        return this.aRoomRandomizer;
    }// getRoomRandomizer ()
}// TransporterRoom