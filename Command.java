 

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Kévin FELTRIN
 * @version 15/02/2023
 */
public class Command
{
   private String aCommandWord; // Le mot de commande de la commande.
   private String aSecondWord; // Le deuxième mot de la commande.
   
   /**
     * Initialise une nouvelle instance de la classe Command.
     *
     * @param pCommandWord Le mot de commande de la commande.
     * @param pSecondWord  Le deuxième mot de la commande.
     */
   public Command( final String pCommandWord, final String pSecondWord )
    {
      this.aCommandWord = pCommandWord;
      this.aSecondWord = pSecondWord;
    } // Command()
    
   /**
     * Obtient le mot de commande de cette commande.
     *
     * @return Le mot de commande de cette commande.
     */
   public String getCommandWord()
    {
      return this.aCommandWord;
    } // getCommandWord()
    
   /**
     * Obtient le deuxième mot de cette commande.
     *
     * @return Le deuxième mot de cette commande.
     */
   public String getSecondWord()
    {
      return this.aSecondWord;
    } // getCSecondWord()
    
   /**
     * Indique si cette commande a un deuxième mot.
     *
     * @return true si cette commande a un deuxième mot, false sinon.
     */
   public boolean hasSecondWord()
    {
      return this.getSecondWord() != null;
    } // hasSecondWord( )
    
   /**
     * Indique si le mot de commande de cette commande est inconnu.
     *
     * @return true si le mot de commande de cette commande est null, false sinon.
     */
   public boolean isUnknown()
    {
      return this.getCommandWord() == null;
    } // isUnknown( )
} // Command
