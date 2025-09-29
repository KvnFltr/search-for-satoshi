import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * La classe RoomRandomizer est utilisée pour sélectionner aléatoirement une pièce parmi une liste de pièces.
 * Elle utilise un objet Random pour fonctionner.
 * 
 * @author K.FELTRIN
 * @version 30/04/2023
 */
public class RoomRandomizer {
    
    // La liste des pièces à choisir aléatoirement
    private List<Room> aRooms;
    
    // L'objet Random utilisé pour sélectionner aléatoirement une pièce
    private Random aRandom;
    private boolean aRandomizer;
    private List<Room> aRoomsArray;

    /**
     * Construit un nouvel objet RoomRandomizer avec une liste de pièces vide et un nouvel objet Random.
     */
    public RoomRandomizer() {
        // Initialisation de la liste des pièces avec une liste vide
        this.aRooms = new ArrayList<Room> ();
        this.aRandomizer = false;
        // Initialisation de l'objet Random
        this.aRandom = new Random ();
    }// RoomRandomizer ()
    
    /**
     * Ajoute une pièce à la liste des pièces pouvant être choisies aléatoirement.
     * 
     * @param pRoom La pièce à ajouter à la liste
     */
    public void addRoom(final Room pRoom) {
        // Ajout de la pièce à la liste
        this.aRooms.add(pRoom);
    }// addRoom ()
    
    /**
     * Renvoie une pièce choisie aléatoirement dans la liste des pièces.
     * 
     * @return Une pièce choisie aléatoirement
     */
    public Room getRandomRoom() {
        // Génère un nombre aléatoire entre 0 et le nombre de pièces dans la liste
        int vRandom = this.aRandom.nextInt(this.aRooms.size());
        
        // Renvoie la pièce correspondante dans la liste
        return this.aRooms.get(vRandom);
    }// getRandomRoom ()
}// RoomRandomizer
