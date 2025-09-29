
/**
 * Cette classe contient une table d'énumération de tous les mots de commande connus du jeu.
 * Il est utilisé pour reconnaître les commandes au fur et à mesure qu'elles sont saisies.
 *
 * @author  K.Feltrin
 * @version 30/04/2023
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private static final String aValidCommands[] = {"go","quit","help","look","eat","back", "test","take","drop","inventory","charge","fire","stopBTC"};
    private static final String[] aValidDirection = {"north","south","east","west","up","down"};
    
    /**
     * Vérifie si une chaîne de caractères donnée est une commande valide.
     * @param pString la chaîne de caractères à vérifier
     * @return true si la chaîne est une commande valide, false sinon.
    */
    public boolean isCommand( final String pString )
    {
        for ( int vI=0; vI<this.aValidCommands.length; vI++ ) {
            if ( this.aValidCommands[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isCommand()
   
    /**
     * Vérifie si une chaîne de caractères est une direction valide.
     *
     * @param pString La chaîne de caractères à vérifier.
     * @return true si c'est une direction valide, false sinon.
     */
    public static boolean isDirection(final String pString) {
        for (String direction : aValidDirection) {
            if (direction.equals(pString)) {
                return true; // Si la chaîne correspond à une direction valide, retourne true.
            }
        }
    
        return false; // Si aucune direction valide correspond à la chaîne, retourne false.
    }
    
    /**
     * Retourne une chaîne de caractères représentant la liste des commandes valides.
     *
     * @return La chaîne de caractères représentant la liste des commandes valides.
     */
    public String getCommandList() {
        String vResult = "";
        // Itération à travers la liste des commandes valides.
        for (String vCommand : aValidCommands) {
            // Ajout de chaque commande suivie d'un espace à la chaîne de résultats.
            vResult += vCommand + " ";
        }
        return vResult;
    }// getCommandList()
} // CommandWords