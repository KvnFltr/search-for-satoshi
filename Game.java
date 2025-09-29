 /**
 * Classe Game - le moteur de The Search for Satoshi Nakamoto.
 *
 * @author Kévin FELTRIN
 * @version 15/02/2023
 */
public class Game
{
    private GameEngine aEngine; // Moteur de jeu
    private UserInterface aGui; // Interface utilisateur
    
    /**
     * Initialise une nouvelle partie de jeu.
     * Cette méthode crée les pièces, le parser et les mots de direction utilisés dans le jeu.
     */
    public Game() {
        this.aEngine = new GameEngine(); // Créer un nouveau moteur de jeu
        this.aGui = new UserInterface(this.aEngine); // Créer une nouvelle interface utilisateur pour le moteur de jeu
        this.aEngine.setGUI(this.aGui); // Définir l'interface utilisateur pour le moteur de jeu
    } // Game()
} // Game
