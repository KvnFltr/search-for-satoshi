import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * This class implements a simple graphical user interface with a 
 * text entry area, a text output area and an optional image.
 * 
 * @author K.FELTRIN
 * @version 18/04/2023
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame aMyFrame;
    private JTextField aEntryField;
    private JTextArea aLog;
    private JLabel aImage;
    private JPanel aPanel;
    private JPanel aPanelWest;
    
    private JButton aButtonBack;
    private JButton aButtonNorth;
    private JButton aButtonUp;
    private JButton aButtonWest;
    private JButton aButtonHelp;
    private JButton aButtonEast;
    private JButton aButtonQuit;
    private JButton aButtonSouth;
    private JButton aButtonDown;
    private JButton aButtonInventory;
    private JButton aButtonStopBitcoin;
    
    
    /**
     * Construit une interface utilisateur. En tant que paramètre, un moteur de jeu
     * (un objet qui traite et exécute les commandes de jeu) est nécessaire.
     * @param pGameEngine L'objet GameEngine implémentant la logique de jeu.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Affiche du texte dans la zone de texte.
     * @param pText texte à afficher dans la zone de texte
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Affiche du texte suivi d'un saut de ligne dans la zone de texte.
     * @param pText texte à afficher dans la zone de texte suivi d'un saut de ligne
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Affiche une image dans l'interface.
     * @param pImageName le nom de l'image à afficher dans l'interface
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)
     
    /**
     * Active ou désactive la saisie de texte dans le champ de saisie.
     * @param pOnOff valeur booléenne indiquant si la saisie de texte doit être activée ou désactivée
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // Active/Désactive l'entrée de texte
        if (!pOnOff){
            this.aEntryField.getCaret().setBlinkRate( 0 ); // Le curseur ne clignotera pas
            this.aEntryField.removeActionListener( this ); // Ne réagira pas à l'entrée
        }// if
        
        // Active/Désactive les boutons suivants en fonction du paramètre
        this.aButtonBack.setEnabled(pOnOff);
        this.aButtonNorth.setEnabled(pOnOff);
        this.aButtonUp.setEnabled(pOnOff);
        this.aButtonWest.setEnabled(pOnOff);
        this.aButtonHelp.setEnabled(pOnOff);
        this.aButtonEast.setEnabled(pOnOff);
        this.aButtonQuit.setEnabled(pOnOff);
        this.aButtonSouth.setEnabled(pOnOff);
        this.aButtonDown.setEnabled(pOnOff);
        this.aButtonInventory.setEnabled(pOnOff);
        this.aButtonStopBitcoin.setEnabled(pOnOff);
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        // Création d'une fenêtre principale avec le titre "The search for Satoshi Nakamoto"
        this.aMyFrame = new JFrame( "The search for Satoshi Nakamoto" );
        // Création d'un champ de texte pour la saisie utilisateur avec une longueur de 34 caractères
        this.aEntryField = new JTextField( 34 );

        // Création d'un composant JTextArea pour l'affichage de messages textuels
        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        // Création d'un panneau principal qui contiendra tous les autres composants
        JPanel vPanel = new JPanel();
        // Création d'un label pour afficher une image
        this.aImage = new JLabel();
        
        // Configuration du panneau principal avec un layout de type BorderLayout
        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.NORTH );// Ajout du label image en haut
        vPanel.add( vListScroller, BorderLayout.CENTER );// Ajout du JTextArea pour les messages au centre
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );// Ajout du champ de texte pour la saisie en bas
        
        // Création d'un panneau pour les boutons
        this.aPanel = new JPanel();
        this.aPanel.setLayout(new GridLayout(3, 3));// Configuration du layout pour afficher les boutons en grille de 3x3
        this.aPanelWest = new JPanel();
        this.aPanelWest.setLayout(new GridLayout(2, 2));
        
        // BACK
        this.aButtonBack = new JButton ("BACK");
        this.aButtonBack.addActionListener(this);
        this.aButtonBack.setBackground(Color.green);
        this.aPanel.add(this.aButtonBack);
        
        // NORTH
        this.aButtonNorth = new JButton ("NORTH");
        this.aButtonNorth.addActionListener(this);
        this.aButtonNorth.setBackground(Color.blue);
        this.aPanel.add(this.aButtonNorth);
        
        // UP
        this.aButtonUp = new JButton ("UP");
        this.aButtonUp.addActionListener(this);
        this.aButtonUp.setBackground(Color.green);
        this.aPanel.add(this.aButtonUp);
        
        // WEST
        this.aButtonWest = new JButton ("WEST");
        this.aButtonWest.addActionListener(this);
        this.aButtonWest.setBackground(Color.blue);
        this.aPanel.add(this.aButtonWest);
        
        // HELP
        this.aButtonHelp = new JButton ("HELP");
        this.aButtonHelp.addActionListener(this);
        this.aButtonHelp.setBackground(Color.blue);
        this.aPanel.add(this.aButtonHelp);
        
        // EAST
        this.aButtonEast = new JButton ("EAST");
        this.aButtonEast.addActionListener(this);
        this.aButtonEast.setBackground(Color.blue);
        this.aPanel.add(this.aButtonEast);
        
        // QUIT
        this.aButtonQuit = new JButton ("QUIT");
        this.aButtonQuit.addActionListener(this);
        this.aButtonQuit.setBackground(Color.red);
        this.aPanel.add(this.aButtonQuit);
        
        // SOUTH
        this.aButtonSouth = new JButton ("SOUTH");
        this.aButtonSouth.addActionListener(this);
        this.aButtonSouth.setBackground(Color.blue);
        this.aPanel.add(this.aButtonSouth);
        
        // DOWN
        this.aButtonDown = new JButton ("DOWN");
        this.aButtonDown.addActionListener(this);
        this.aButtonDown.setBackground(Color.green);
        this.aPanel.add(this.aButtonDown);
        
        // INVENTORY
        this.aButtonInventory = new JButton ("INVENTORY");
        this.aButtonInventory.addActionListener(this);
        this.aButtonInventory.setBackground(Color.orange);
        this.aPanelWest.add(this.aButtonInventory);
        
        this.aButtonStopBitcoin = new JButton ("STOP BITCOIN");
        this.aButtonStopBitcoin.addActionListener(this);
        this.aButtonStopBitcoin.setBackground(Color.orange);
        this.aPanelWest.add(this.aButtonStopBitcoin);
        
        // Ajout du panel de boutons sur la droite de vPanel
        vPanel.add(this.aPanel, BorderLayout.EAST);
        
        // Ajout du panel de boutons sur la gauche de vPanel
        vPanel.add(this.aPanelWest, BorderLayout.WEST);
        
        // Ajout d'un écouteur pour l'entrée de texte
        this.aEntryField.addActionListener(this);
        
        // Ajout d'un écouteur pour l'événement de fermeture de la fenêtre principale
        this.aMyFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { 
                System.exit(0); // Fermeture de l'application
            }
        });
        
        // Ajout du vPanel au centre de la fenêtre principale
        this.aMyFrame.getContentPane().add(vPanel, BorderLayout.CENTER);
        
        // Redimensionnement de la fenêtre principale selon les dimensions de ses composants
        this.aMyFrame.pack();
        
        // Affichage de la fenêtre principale
        this.aMyFrame.setVisible(true);
        
        // Donner le focus à l'entrée de texte pour permettre une saisie immédiate
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Interface ActionListener pour le champ de texte d'entrée.
     *
     * @param pE L'événement ActionEvent déclenché.
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        if(pE.getSource() == this.aButtonNorth)
        {
            this.aEngine.interpretCommand("go north");
        }
        else if(pE.getSource() == this.aButtonEast)
        {
            this.aEngine.interpretCommand("go east");
        }
        else if(pE.getSource() == this.aButtonSouth)
        {
            this.aEngine.interpretCommand("go south");
        }
        else if(pE.getSource() == this.aButtonWest)
        {
            this.aEngine.interpretCommand("go west");
        }
        else if(pE.getSource() == this.aButtonUp)
        {
            this.aEngine.interpretCommand("go up");
        }
        else if(pE.getSource() == this.aButtonDown)
        {
            this.aEngine.interpretCommand("go down");
        }
        else if(pE.getSource() == this.aButtonHelp)
        {
            this.aEngine.interpretCommand("help");
        }
        else if(pE.getSource() == this.aButtonBack)
        {
            this.aEngine.interpretCommand("back");
        }
        else if(pE.getSource() == this.aButtonQuit)
        {
            this.aEngine.interpretCommand("quit");
        }else if (pE.getSource() == this.aButtonInventory){
            this.aEngine.interpretCommand("inventory");
        }else if (pE.getSource() == this.aButtonStopBitcoin){
            this.aEngine.interpretCommand("stopBTC");
        }
        else{
            this.processCommand();
        }
    } // actionPerformed(.)

    /**
     * A command has been entered in the entry field.  
     * Read the command and do whatever is necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
