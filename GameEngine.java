import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Cette classe crée toutes les pièces, crée l'analyseur et démarre
 * le jeu. Il évalue et exécute également les commandes que
 * l'analyseur renvoie.
 * 
 * @author  Kévin Feltrin
 * @version 18/04/2023
 */
public class GameEngine
{
    private Parser aParser; // Le parser utilisé pour interpréter les commandes du joueur.
    private UserInterface aGui; // Interface utilisateur.
    private Player aPlayer;
    private HashMap <String, Room> aRooms; // Déclare une variable de classe "aRooms" de type HashMap qui stocke des objets Room.
    
    /**
     * Constructeur de la classe GameEngine.
     * Initialise les pièces du jeu, le parser et les mots de direction.
     */
    public GameEngine() {
        this.aRooms = new HashMap <String, Room> ();// On initialise la variable aRooms avec un nouveau HashMap vide
        this.aParser = new Parser();// On crée un nouveau parser pour interpréter les commandes du joueur
        this.createRooms();// On crée les pièces du jeu
    }

    /**
     * Définit l'interface utilisateur pour le moteur de jeu et affiche le message de bienvenue.
     * @param pUserInterface L'interface utilisateur à définir.
     */
    public void setGUI(final UserInterface pUserInterface) {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * Affiche le message de bienvenue du jeu, avec des informations sur le contexte et les instructions.
     * Appelle également la méthode printLocationInfo() pour afficher les informations sur la pièce actuelle.
     */
    private void printWelcome()
    {
      this.aGui.println("\n" + "Welcome to the village of Satoshi Nakamoto, the creator of Bitcoin! \n" + 
      "The Search for Satoshi Nakamoto is an incredible investigation to discover the identity of the creator of bitcoin! \n" +  
      "You are an investigator commissioned by the IMF who must find Satoshi Nakamoto's HQ and stop the bitcoin which threatens the world economy. \n"+
      "You are only allowed 50 moves and are limited to carrying 4 items. \n"+
      "Type 'help' if you need help. \n");
      
      this.printLocationInfo();// Afficher les informations sur la pièce actuelle
    } // printWelcome()

    /**
     * Cette méthode crée les pièces du jeu et configure leurs sorties.
     * Elle initialise également les objets et les attribue aux différentes pièces.
     */
    private void createRooms ()
    {
        // Déclaration/création des 22 lieux
        Room vHQLivingRoom = new Room ("in the investigator's living room","Images/hq_living_room.png");
        Room vHQOffice = new Room ("in the HQ office","Images/hq_office.png");
        Room vHQAndGavinStreet = new Room ("in the street of the HQ and Gavin","Images/hq_and_gavin_street.png");
        Room vGavinLivingRoom = new Room ("in Gavin's living room","Images/gavin_living_room.png");
        Room vGavinOffice = new Room ("in Gavin's office","Images/gavin_office.png");
        Room vCraigStreet = new Room ("in the street of Craig","Images/craig_street.png");
        Room vCraigLivingRoom = new Room ("in Craig's living room","Images/craig_living_room.png");
        Room vCraigOffice = new Room ("in Craig's office","Images/craig_office.png");
        Room vLenStreet = new Room ("in the street of Len","Images/len_street.png");
        Room vLenLivingRoom = new Room ("in Len's living room","Images/len_living_room.png");
        Room vLenOffice = new Room ("in Len's office","Images/len_office.png");
        Room vHalStreet = new Room ("in the street of Hal","Images/hal_street.png");
        Room vHalLivingRoom = new Room ("in Hal's living room","Images/hal_living_room.png");
        Room vHalOffice = new Room ("in Hal's office","Images/hal_office.png");
        Room vPaulAndAdamStreet = new Room ("in the street of Paul and Adam","Images/paul_and_adam_street.png");
        Room vPaulLivingRoom = new Room ("in Paul's living room","Images/paul_living_room.png");
        Room vPaulOffice = new Room ("in Paul's office","Images/paul_office.png");
        Room vAdamLivingRoom = new Room ("in Adam's living room","Images/adam_living_room.png");
        Room vAdamOffice = new Room ("in Adam's office","Images/adam_office.png");
        Room vSecretGate = new Room ("in the Secret Gate","Images/secret_gate.png");
        Room vSatoshiHQ = new Room ("in Satoshi Nakamoto's HQ","Images/satoshi_hq.png");
        TransporterRoom vTransporterRoom = new TransporterRoom ("You have entered the teleportation room. This room has the ability to randomly teleport you to different locations." + "\n" + "To activate the teleportation, simply leave the room.", "Images/transporter_room.png");
        
        // Ajout des pièces à la collection aRooms
        aRooms.put("investigator's living room", vHQLivingRoom);
        aRooms.put("HQ office",vHQOffice);
        aRooms.put("street of the HQ and Gavin",vHQAndGavinStreet);
        aRooms.put("Gavin's living room", vGavinLivingRoom);
        aRooms.put("Gavin's office", vGavinOffice);
        aRooms.put("the street of Craig", vCraigStreet);
        aRooms.put("Craig's living room", vCraigLivingRoom);
        aRooms.put("Craig's office", vCraigOffice);
        aRooms.put("street of Len", vLenStreet);
        aRooms.put("Len's living room", vLenLivingRoom);
        aRooms.put("Len's office", vLenOffice);
        aRooms.put("street of Hal", vHalStreet);
        aRooms.put("Hal's living room", vHalLivingRoom);
        aRooms.put("Hal's office", vHalOffice);
        aRooms.put("street of Paul and Adam", vPaulAndAdamStreet);
        aRooms.put("Paul's living room", vPaulLivingRoom);
        aRooms.put("Paul's office", vPaulOffice);
        aRooms.put("Adam's living room", vAdamLivingRoom);
        aRooms.put("Adam's office", vAdamOffice);
        aRooms.put("Secret Gate", vSecretGate);
        aRooms.put("Satoshi Nakamoto's HQ", vSatoshiHQ);
        
        // Configuration de la salle de téléportation
        vTransporterRoom.getRoomRandomizer().addRoom(vHQLivingRoom);
        
        // Création des items
        Item vKey1 = new Item ("Key1","First key to enter Satoshi Nakamoto's HQ",1.0);
        Item vKey2 = new Item ("Key2","Second key to enter Satoshi Nakamoto's HQ",1.0);
        Item vKey3 = new Item ("Key3","Third key to enter Satoshi Nakamoto's HQ",1.0);
        Item vUSB = new Item ("USB","USB key to plug into the PC",1.0);
        Item vPicture = new Item ("Picture","Picture",1.0);
        Item vBadge = new Item ("Badge","IMF Investigator Badge which gives permission to enter suspects",1.0);
        Item vCookie = new Item ("Cookie","Cookie that may be useful for the player",1.0);
        Beamer vBeamer = new Beamer("Beamer","this item can teleport you," +
        "\n" + "Charge inside a room and fire into another to go back where you charged it !", 1.0);
        
        // Configuration des sorties des différentes pièces
        vHQLivingRoom.setExit("north", vHQAndGavinStreet);
        vHQLivingRoom.setExit("down", vHQOffice);
        
        vHQOffice.setExit("up", vHQLivingRoom);
        
        vHQAndGavinStreet.setExit("north", vGavinLivingRoom);
        vHQAndGavinStreet.setExit("east", vLenStreet);
        vHQAndGavinStreet.setExit("south", vHQLivingRoom);
        vHQAndGavinStreet.setExit("west", vCraigStreet);
        
        vGavinLivingRoom.setExit("south", vHQAndGavinStreet);
        vGavinLivingRoom.setExit("up", vGavinOffice);
        
        vGavinOffice.setExit("down", vGavinLivingRoom);
        
        vCraigStreet.setExit("north", vCraigLivingRoom);
        vCraigStreet.setExit("east", vHQAndGavinStreet);
        
        vCraigLivingRoom.setExit("south", vCraigStreet);
        vCraigLivingRoom.setExit("up", vCraigOffice);
        
        vLenStreet.setExit("north", vLenLivingRoom);
        vLenStreet.setExit("south", vHalStreet);
        vLenStreet.setExit("west", vHQAndGavinStreet);
        
        vLenLivingRoom.setExit("south", vLenStreet);
        vLenLivingRoom.setExit("up", vLenOffice);
        
        vLenOffice.setExit("down", vLenLivingRoom);
        
        vHalStreet.setExit("north", vLenStreet);
        vHalStreet.setExit("east", vPaulAndAdamStreet);
        vHalStreet.setExit("south", vHalLivingRoom);
        
        vHalLivingRoom.setExit("north", vHalStreet);
        vHalLivingRoom.setExit("down", vHalOffice);
        
        vHalOffice.setExit("up", vHalLivingRoom);
        
        vPaulAndAdamStreet.setExit("north", vTransporterRoom);
        vPaulAndAdamStreet.setExit("east", vPaulLivingRoom);
        vPaulAndAdamStreet.setExit("south", vAdamLivingRoom);
        vPaulAndAdamStreet.setExit("west", vHalStreet);
        
        vPaulLivingRoom.setExit("west", vPaulAndAdamStreet);
        vPaulLivingRoom.setExit("up", vPaulOffice);
        
        vAdamLivingRoom.setExit("north", vPaulAndAdamStreet);
        vAdamLivingRoom.setExit("west", vAdamOffice);
        
        vAdamOffice.setExit("east", vAdamLivingRoom);
        vAdamOffice.setExit("down", vSecretGate);
        
        vSecretGate.setExit("north", vSatoshiHQ);
        
        vSatoshiHQ.setExit("south", vSecretGate);
        
        // Configuration des objets dans les différentes pièces
        vHQOffice.getRoomItems().addItem("Badge", vBadge);
        
        vGavinOffice.getRoomItems().addItem("Key1", vKey1);
        vGavinOffice.getRoomItems().addItem("Picture", vPicture);
        
        vCraigLivingRoom.getRoomItems().addItem("Beamer", vBeamer);
        
        vLenLivingRoom.getRoomItems().addItem("Key2", vKey2);
        vLenOffice.getRoomItems().addItem("USB", vUSB);
        
        vHalOffice.getRoomItems().addItem("Key3", vKey3);
        
        vPaulLivingRoom.getRoomItems().addItem("Cookie", vCookie);

        // Configuration des clés nécessaires pour les portes verrouillées
        vAdamOffice.getExit("down").getDoor().setNecessaryKeys(new Item[] {vKey1, vKey2, vKey3});
        vAdamOffice.getExit("down").getDoor().setLocked(true);
        
        vHQAndGavinStreet.getExit("north").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vHQAndGavinStreet.getExit("north").getDoor().setLocked(true);
        
        vCraigStreet.getExit("north").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vCraigStreet.getExit("north").getDoor().setLocked(true);
        
        vLenStreet.getExit("north").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vLenStreet.getExit("north").getDoor().setLocked(true);
        
        vPaulAndAdamStreet.getExit("east").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vPaulAndAdamStreet.getExit("east").getDoor().setLocked(true);
        
        vPaulAndAdamStreet.getExit("south").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vPaulAndAdamStreet.getExit("south").getDoor().setLocked(true);
        
        vHalStreet.getExit("south").getDoor().setNecessaryKeys(
            new Item[] {vBadge});
        vHalStreet.getExit("south").getDoor().setLocked(true);
        
        // Initialisation du joueur
        this.aPlayer = new Player ("Agent Smith", vHQLivingRoom,50);
    } // createRooms ()

    /**
     * Cette méthode permet de transformer et d'analyser la commande de l'utilisateur.
     * Elle reçoit une chaîne de caractères pStringCommand, qui est la commande entrée par l'utilisateur.
     * La méthode affiche la commande entrée, puis la convertit en une commande utilisable par le jeu grâce à un objet Parser.
     * Ensuite, la méthode vérifie quelle est la commande entrée, et exécute la méthode correspondante.
     * Si la commande entrée est inconnue, la méthode affiche un message d'erreur.
     *
     * @param pCommandLine La commande entrée par l'utilisateur.
     */
    public void interpretCommand(final String pCommandLine) {
        // Affichage de la commande entrée
        this.aGui.println("\n" + "> " + pCommandLine );
    
        // Conversion de la commande en une commande utilisable par le jeu
        Command vCommand = this.aParser.getCommand(pCommandLine);
    
        if (vCommand.isUnknown()){
            this.aGui.println("I don't know what you mean ...");
        }else{
            // Vérification de la commande entrée et exécution de la méthode correspondante
            switch (vCommand.getCommandWord()) {
                case "go":
                    this.goRoom(vCommand);
                    break;
                case "look":
                    this.look(vCommand);
                    break;
                case "eat":
                    this.eat(vCommand);
                    break;
                case "quit":
                    if (vCommand.hasSecondWord()) {
                        this.aGui.println("Quit what?");
                    } else {
                        this.endGame();
                    }
                    break;
                case "help":
                    this.printHelp();
                    break;
                case "back":
                    this.back(vCommand);
                    break;
                case "test":
                    this.test(vCommand);
                    break;
                case "take":
                    this.take(vCommand);
                    break;
                case "drop":
                    this.drop(vCommand);
                    break;
                case "inventory":
                    this.inventory();
                    break;
                case "charge":
                    this.charge(vCommand);
                    break;
                case "fire":
                    this.fire(vCommand);
                    break;
                case "stopBTC":
                    this.stopBTC();
                    break;
                default:
                    this.aGui.println("Unknown command!");
                    break;
            }
        }
    }

    /**
     * Affiche les commandes disponibles pour le joueur.
     */
    private void printHelp()
    {
        this.aGui.println("Your command words are:"+ aParser.getCommands());
    } // printHelp( )  

    /**
     * Retourne l'objet Room associé au nom de la salle donné.
     * @param pRoom le nom de la salle à récupérer
     * @return l'objet Room associé au nom de la salle donné
    */
    public Room getRoom (final String pRoom)
    {
        return this.aRooms.get(pRoom);
    }// getRoom ()
    
    /**
     * Déplace le joueur dans une nouvelle pièce en fonction de l'instruction de commande donnée.
     * Si l'instruction est invalide ou s'il n'y a pas de pièce dans la direction donnée, affiche un message d'erreur.
     * @param pInstruction La commande de déplacement du joueur.
     */
    private void goRoom(final Command pInstruction)
    {
        // Vérifie si un deuxième mot est présent dans l'instruction, sinon affiche un message d'erreur.
        if (!pInstruction.hasSecondWord()){
            this.aGui.println("Go where ?");
            return;
        }
        
        // Récupère le deuxième mot de l'instruction, qui doit être la direction souhaitée.
        String vDirection = pInstruction.getSecondWord();
        
        // Vérifie si la direction est valide en utilisant la méthode isDirection de l'objet aDirection de la classe actuelle.
        if (!CommandWords.isDirection(vDirection)) {
            this.aGui.println("Unknown direction!");
            return;
        }
    
        // Récupère la prochaine pièce dans la direction spécifiée.
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null){
            this.aGui.println("There is no door !");
            return;
        }// if
        
        // Vérifie si la porte de la prochaine pièce est verrouillée.
        if (vNextRoom.getDoor().isLocked()) {
            // Tente de déverrouiller la porte en utilisant les objets de l'inventaire du joueur.
            boolean vSuccess = vNextRoom.getDoor().tryToUnlock(this.aPlayer.getInventory().getItems());
            
            if(vSuccess)
                this.aGui.println("The door has been unlocked");
            else {
                this.aGui.println("You can't pass this door without Badge or Keys ! It's locked!");
                return;
            }
        }
        
        // Déplace le joueur dans la prochaine pièce.
        this.aPlayer.goRoom(vDirection);
        
        // Vérifie si le joueur a été téléporté dans la pièce "investigator's living room".
        if (this.aPlayer.getPreviousRooms().peek().equals(this.getRoom("transporter room"))){
            this.aGui.println("You have been teleported to investigator's living room!" + "\n");
        }
        
        this.printLocationInfo();
        this.timer();
    } // goRoom()

    /**
     * Permet de finir le jeu
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false ); //Enleve la possibilité d'écrire du texte dans le GUI
    }// endGame ()
    
    /**
     * Affiches détails de l'endroit dans lequel on est 
     * et où nous pouvons aller.
     */
    private void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        if (this.aPlayer.getCurrentRoom().getImageName() != null){
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName() );
        }
        this.aGui.println("You still have "+this.aPlayer.getTime()+" mouvements.");
    }//printLocationInfo()
    
    /**
     * Permet au joueur de regarder autour de lui dans la pièce courante. Si le joueur fournit
     * un deuxième mot, la commande n'affiche les détails que de l'objet dont le nom est fourni
     * en deuxième mot.
     *
     * @param pCommand La commande d'observation du joueur.
     */
    private void look(Command pCommand) {
        // Vérifier s'il y a un deuxième mot dans la commande d'observation.
        if (pCommand.hasSecondWord()) {
            String vItemName = pCommand.getSecondWord();
            // Trouver l'objet dans la pièce courante.
            Item vItem = this.aPlayer.getCurrentRoom().getRoomItems().getItem(vItemName);
            if (vItem == null) {
                // Si l'objet n'est pas dans la pièce ou n'existe pas, afficher un message d'erreur.
                this.aGui.println("This item is not in this room or does not exist!");
            } else {
                // Afficher la description de l'objet.
                this.aGui.println(vItem.getItemDescription());
            }
        } else {
            // S'il n'y a pas de deuxième mot, afficher la description complète de la pièce.
            this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        }
    }

    /**
     * Méthode pour consommer un cookie et augmenter la capacité d'inventaire du joueur.
     * @param pCommand La commande pour manger un aliment.
     */
    private void eat(final Command pCommand) {
        // Vérifier si la commande contient un deuxième mot (nom de l'aliment à manger)
        if (!pCommand.hasSecondWord()) {
            this.aGui.println("Eat what?");
            return;
        }
    
        // Récupérer le nom de l'aliment à manger
        final String vFoodName = pCommand.getSecondWord();
    
        // Vérifier si l'aliment est un cookie
        if (!"Cookie".equals(vFoodName) || this.aPlayer.getInventory().getItem("Cookie") == null) {
            this.aGui.println("You don't have the cookie in your inventory!");
            return;
        }
    
        // Retirer le poids du cookie de l'inventaire du joueur
        final double vCookieWeight = this.aPlayer.getInventory().getItem("Cookie").getItemWeight();
        this.aPlayer.removeWeight(vCookieWeight);
    
        // Augmenter la capacité d'inventaire du joueur de 10 unités
        this.aPlayer.setMaxWeight(this.aPlayer.getMaxWeight() + 10.0);
    
        // Retirer le cookie de l'inventaire du joueur
        this.aPlayer.getInventory().removeItem("Cookie");
    
        // Afficher un message de confirmation de la consommation du cookie
        this.aGui.println("You ate the magic cookie and increased your inventory capacity!");
    }
    
    /**
     * Permet au joueur de retourner à la pièce précédente visitée.
     * Si le joueur a fourni un deuxième mot, la commande affiche un message d'erreur.
     *
     * @param pCommand La commande de retour du joueur.
     */
    private void back(final Command pCommand) {
        // Vérifie si un deuxième mot a été fourni dans la commande de retour.
        if (pCommand.hasSecondWord()) {
            this.aGui.println("Return where?");
            return;
        }
    
        // Vérifie si la pile des pièces précédentes est vide.
        if (this.aPlayer.getPreviousRooms().empty()) {
            this.aGui.println("Error: There is no previous room to return to.");
        } else if (!this.aPlayer.back()) {
            // Essaye de retourner à la pièce précédente, sinon affiche un message d'erreur.
            this.aGui.println("Error: You can't go back from a trapdoor.");
        }
    
        // Affiche les informations sur la nouvelle pièce courante.
        this.printLocationInfo();
    }
    
    /**
     * Méthode pour tester un fichier contenant des commandes.
     * @param pCommand L'objet Command contenant le nom du fichier à tester.
     */
    private void test(final Command pCommand) {
        // Vérifie si la commande contient un deuxième mot (nom de fichier)
        if (!pCommand.hasSecondWord()) {
            this.aGui.println("Test what?");
            return;
        }
        
        // Obtient le nom du fichier à partir de la commande
        String vFileName = pCommand.getSecondWord();
        // Crée un objet File à partir du nom de fichier spécifié avec une extension .txt
        File vFile = new File(vFileName + ".txt");
        
        // Vérifie si le fichier existe
        if (!vFile.exists()) {
            this.aGui.println("File not found!");
            return;
        }
        
        try (Scanner vScanner = new Scanner(vFile)) {
            // Parcourt chaque ligne du fichier et interprète la commande
            while (vScanner.hasNextLine()) {
                this.interpretCommand(vScanner.nextLine());
            }
        } catch (FileNotFoundException pF) {
            this.aGui.println("File not found!");
        }
    }

    /**
     * Cette méthode gère la commande "prendre".
     *
     * @param pCommand La commande "prendre" à exécuter.
     */
    private void take(final Command pCommand)
    {
        // Vérifie si la commande a un deuxième mot.
        if(!pCommand.hasSecondWord()){
            this.aGui.println("Take what ?");
            return;
        }
        // Récupère l'objet de la pièce actuelle.
        Item vItem = this.aPlayer.getCurrentRoom().getRoomItems().getItem(pCommand.getSecondWord());
        // Si l'objet n'est pas dans la pièce, affiche un message à l'utilisateur.
        if(vItem==null){
            this.aGui.println("This item is not here.");
        }else if(this.aPlayer.canWear(vItem)==false){
            this.aGui.println("Sorry, this Item is too heavy.");
        }
        else{
            // Si l'objet est dans la pièce, le prend et le retire de la pièce.
            this.aPlayer.take(vItem);
            this.aGui.println(vItem.getItemDescription());
            this.aGui.println(this.aPlayer.getInventory().getItemString());
            this.aGui.println("You picked up " + pCommand.getSecondWord());
        }
    }
    
    /**
     * Drops an item from the player's inventory and removes it from the inventory.
     * @param pCommand the command object containing the item to be dropped
     */
    private void drop(final Command pCommand)
    {
        // Vérifie si la commande a un deuxième mot.
        if(!pCommand.hasSecondWord()){
            this.aGui.println("Drop what ?");
            return;
        }
        // Récupère l'objet de la pièce actuelle.
        Item vItem = this.aPlayer.getInventory().getItem(pCommand.getSecondWord());
        // Si l'objet n'est pas dans l'inventaire, affiche un message à l'utilisateur.
        if(vItem==null){
            this.aGui.println("You don't have this item.");
        }else{
            // Si l'objet est dans l'inventaire, le jette et le retire de l'inventaire.
            this.aPlayer.drop(vItem);
            this.aGui.println("You dropped " + vItem.getItemName());
            this.aGui.println(this.aPlayer.getInventory().getItemString());
        }
    }
    
    /**
     * Cette méthode affiche l'inventaire du joueur ainsi que son poids total et son poids maximal possible.
     */
    private void inventory()
    {
        this.aGui.println(this.aPlayer.getInventory().getItemString() + 
        "\n"+ "Total weight : " + this.aPlayer.totalWeight() 
        + "\n"+ "Maximum possible weight : " + this.aPlayer.getMaxWeight());
    }
    
    /**
     * Cette méthode vérifie si le joueur a encore des mouvements pour jouer. Si les mouvements sont écoulés, la partie se termine.
     */
    private void timer()
    {
        // Vérifie si les mouvements restants du joueur sont égals à zéro
        if(this.aPlayer.getTime() == 0){
            // Si les mouvements sont écoulés, affiche un message de fin de partie et termine la partie
            this.aGui.println("Game over! You have reached the maximum number of movements allowed by the IMF.");
            this.aGui.showImage("Images/lost.png");
            this.endGame();
        }
    }
    
    /**
     * Cette méthode permet de charger le Beamer dans l'inventaire du joueur.
     * Si le joueur n'a pas le Beamer, il ne peut pas le charger.
     * Si le Beamer est déjà chargé, le joueur ne peut pas le charger à nouveau.
     * @param pCommand Commande saisie par l'utilisateur pour charger le Beamer
     */
    private void charge(final Command pCommand) {
        // Vérifie si la commande saisie possède un deuxième mot ou si ce mot n'est pas "Beamer"
        if (!pCommand.hasSecondWord() || !pCommand.getSecondWord().equals("Beamer")) {
            this.aGui.println("Invalid charge command!");
            return;
        }
    
        // Récupère l'objet Beamer de l'inventaire du joueur
        Item vItem = this.aPlayer.getInventory().getItem("Beamer");
        if (vItem == null) {
            // Le joueur n'a pas le Beamer dans son inventaire
            this.aGui.println("You don't have the Beamer in your inventory!");
            return;
        }
    
        // Effectue le casting vers Beamer car nous savons que vItem est un Beamer
        Beamer vBeamer = (Beamer) vItem;
        if (vBeamer.isCharged()) {
            // Le Beamer est déjà chargé
            this.aGui.println("Your Beamer is already charged!");
            return;
        }
    
        // Charge le Beamer
        this.aPlayer.charge(vBeamer);
        this.aGui.println("Your Beamer has been charged!");
    }
    
    /**
     * Cette méthode permet de décharger avec le Beamer.
     * Si le joueur n'a pas le Beamer, il ne peut pas le décharger.
     * Si le Beamer n'est pas chargé, le joueur ne peut pas le décharger.
     * @param pCommand Commande saisie par l'utilisateur pour décharger avec le Beamer
     */
    private void fire(final Command pCommand) {
        // Vérifie si la commande saisie possède un deuxième mot ou si ce mot n'est pas "Beamer"
        if (!pCommand.hasSecondWord() || !pCommand.getSecondWord().equals("Beamer")) {
            this.aGui.println("Invalid fire command!");
            return;
        }
    
        // Récupère l'objet Beamer de l'inventaire du joueur
        Item vItem = this.aPlayer.getInventory().getItem("Beamer");
        if (vItem == null) {
            // Le joueur n'a pas le Beamer dans son inventaire
            this.aGui.println("You don't have the Beamer in your inventory!");
            return;
        }
    
        // Effectue le casting vers Beamer car nous savons que vItem est un Beamer
        Beamer vBeamer = (Beamer) vItem;
        if (!vBeamer.isCharged()) {
            // Le Beamer n'est pas chargé
            this.aGui.println("First you need to charge your Beamer!");
            return;
        }
    
        // Décharge le Beamer
        this.aPlayer.fire(vBeamer);
        this.aGui.println("Your Beamer has been fired!");
    
        // Affiche des informations supplémentaires sur l'emplacement du joueur
        this.printLocationInfo();
    }
    
    private void stopBTC()
    {
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        
        if(vCurrentRoom == aRooms.get("Satoshi Nakamoto's HQ") ){
            this.aGui.println("\n");
            this.aGui.println("Congratulations!" +"\n"+ "You stopped Bitcoin and saved the world economy!" +"\n"+"The IMF thanks you!");
            this.aGui.showImage("Images/win.png");
            this.endGame();
        } else{ this.aGui.println("You are not in Satoshi Nakamoto's HQ!");
        }
    }
}
