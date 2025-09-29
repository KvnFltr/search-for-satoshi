import java.util.StringTokenizer;

/**
 * Classe permettant d'analyser les commandes saisies par l'utilisateur.
 * Elle extrait les mots clés de la chaîne de caractères entrée.
 * @author Michael Kolling + David J. Barnes + Kévin Feltrin
 * @version 2008.03.30
 * @version D.Bureau 2013.09.15
 */
public class Parser {
    private CommandWords aValidCommands;  // Liste des commandes valides
    private CommandWords aCommandWords;  // Lecture des commandes au clavier

    /**
     * Constructeur par défaut qui crée les deux objets pour les attributs.
     */
    public Parser() {
        this.aValidCommands = new CommandWords();
        this.aCommandWords = new CommandWords();
        // System.in représente le clavier, tout comme System.out représente l'écran
    }

    /**
     * Récupère une nouvelle commande de l'utilisateur.
     * La commande est lue en analysant la chaîne de caractères 'inputLine'.
     *
     * @param pInputLine La chaîne de caractères contenant la commande entrée par l'utilisateur.
     * @return La commande correspondant à la chaîne de caractères entrée par l'utilisateur.
     */
    public Command getCommand(final String pInputLine) {
        String vWord1;
        String vWord2;

        // Création d'un objet StringTokenizer pour analyser la chaîne de caractères entrée.
        StringTokenizer tokenizer = new StringTokenizer(pInputLine);

        if (tokenizer.hasMoreTokens())
            vWord1 = tokenizer.nextToken();      // Premier mot
        else
            vWord1 = null;

        if (tokenizer.hasMoreTokens())
            vWord2 = tokenizer.nextToken();      // Deuxième mot
        else
            vWord2 = null;

        if (this.aValidCommands.isCommand(vWord1))
            return new Command(vWord1, vWord2);
        else
            return new Command(null, vWord2);
    }

    /**
     * Renvoie la liste des commandes valides.
     *
     * @return Chaîne de caractères contenant les commandes valides.
     */
    public String getCommands() {
        return this.aValidCommands.getCommandList();
    }
}