﻿//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;


import desktop_resources.GUI;
import boundary.MatadorGUI;
import boundary.Texts;



public class Game {

	private int playerAmount = 0;
	private MatadorGUI gui = new MatadorGUI(); 
	private Dice dice = new Dice();
	private GameBoard gameboard;
	private Player currentPlayer;
	private PrisonController prisonController = new PrisonController(gui);
	private HouseController houseController;
	private Player[] players;	
	private PlayerList playerList;
	private PassStartCheck passStartCheck = new PassStartCheck();
	private PropertyController propertyController = new PropertyController();

	
	public Game() {
	gui.createField();	//Must be one of the first methods to call in GUI.jar

	String language = gui.selectLanguage();
 	if(language.equals("Dansk")) {
 		gui = new MatadorGUI("Dansk");
 		} else if(language.equals("English")) {
 			gui = new MatadorGUI("English");
		}
	 	gameboard = new GameBoard(dice); //If this is set earlier in class, Chance() will invoke an nullpointerError
	}

		
	public void init() {

	//Gets input from player actor outside system boundary
	playerAmount = gui.playerAmount();	
	players = new Player[playerAmount];	
	createPlayers();		
	playerList = new PlayerList(players);	
	}
	
	public void createPlayers() {
		for (int i = 0; i < playerAmount; i++) {
			players[i] = new Player(GUI.getUserString(Texts.text[0]		//This GUI call should be in MatadorGUI, but not the creation of player object.
					+ (i + 1) + ":"));
		}
		gui.createPlayers(playerAmount, players);	

	}
	
	public void run() {		

		// The game continues as long as won equals false
		while (!playerList.checkIfPlayerWon(players)) {
			//Goes through the player[]
			for (int i = 0; i < players.length; i++) {
				//If the player is not dead, he can have a turn!
				if (!players[i].getDeathStatus()) {
					
					//Sets currentPlayer object
					currentPlayer = players[i];
					
					//Shows message for the player having current turn, might have option to buy houses, or option to throw dice
					playerTurnMessage(currentPlayer, gameboard, playerList);
					
					//Throws dice in Dice class, meaning generating random numbers stored in Dice.
					dice.throwDice();							
					
					if(currentPlayer.getPrisonTurns() == 0) {
						movePlayer(currentPlayer, dice);
					}
					
					//Check if player passed start field, gives him passStartMoney in case
					passStartCheck.checkIfPlayerPassedStart(currentPlayer, dice.getSum());
					
					if(currentPlayer.getPrisonTurns() > 0) {
						prisonController.prisonDialog(currentPlayer, dice);
					}				
					//LandOnField handles buying/selling/rent
					gameboard.landOnField(currentPlayer);

					// If a player has lost, adds one to lostCount and reset the players owned fields
					checkIfPlayerLost(currentPlayer);
			
					//Checks if one player has won in the player array
					playerList.checkIfPlayerWon(players);					

				}
			}
		}	
	}	
	
		
	public void playerTurnMessage(Player currentPlayer, GameBoard gameboard, PlayerList playerList) {
			if(gameboard.canPlayerBuyHouses(currentPlayer)) {
				if(gui.optionToBuyHouse().equals("Køb hus")) {
					houseController = new HouseController(gui, gameboard, currentPlayer); //Sets variables for housecontroller to use
					houseController.buyHousesOption();	//Player is given option to buy houses if he has a group in same color
				}				
			}
			//If player has ownable and has ownable he can pledge, he gets option to sell, pledge, or throw
			 if(gameboard.playerHasOwnable(currentPlayer) && gameboard.playerHasPledgeable(currentPlayer.getName())) { 
				String userOption = gui.ownablesOptionsOrThrowDice(currentPlayer);
					if(userOption.equals("Kast")) {
						//Does nothing, just continue back to game.run(), which will dice.Throw() next.
					} 
					if(userOption.equals("Sælg grund")) {
						propertyController.sellProperty(currentPlayer, gameboard, playerList);
					} 
					if(userOption.equals("Pantsæt")) {
						propertyController.pledgeProperty(currentPlayer, gameboard);
					}
			}
			 if(!gameboard.playerHasOwnable(currentPlayer)) {	//If player doesn't have ownable, he only has option to throw dice
				//Shows message for what player has turn
				gui.throwDiceOptionOnly(currentPlayer);
			}
			 //If player has ownable, but not pledgeable property:
			 if(gameboard.playerHasOwnable(currentPlayer) && (!gameboard.playerHasPledgeable(currentPlayer.getName()))) {
					String userOption = gui.ownablesNotPledgeableOptionsOrThrowDice(currentPlayer);
					if(userOption.equals("Kast")) {
						//Does nothing, just continue back to game.run(), which will dice.Throw() next.
					} 
					if(userOption.equals("Sælg grund")) {
						propertyController.sellProperty(currentPlayer, gameboard, playerList);
					} 
			 }
	}
	

	
	public void movePlayer(Player player, Dice dice) {
		//Shows the dice on the GUI
		gui.showDice(dice.getDice1(), dice.getDice2());

		//Updates the position variable inside player object
		player.addRollToPosition(dice.getSum());
		
		//Updates the position of the cars on GUI
		gui.updatePosition(player);		
		
	}

	
	public void checkIfPlayerLost( Player currentPlayer) {
		if (currentPlayer.getDeathStatus()) {
			//If the player is dead, remove them from the board and reset the fields owned
			gui.removePlayer(currentPlayer);			
			gameboard.resetOwnedFields(currentPlayer);
		}		
	}
	
	
}
