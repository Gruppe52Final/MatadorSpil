//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;


import boundary.MatadorGUI;
import fields.Fields;
import fields.Territory;



public class Game {

	private int playerAmount = 0;
	private int passStartMoney = 200;
	private MatadorGUI gui = new MatadorGUI(); 
	private int lostCount = 0;
	private Dice dice = new Dice();
	private GameBoard gameboard;
	private boolean won = false;
	private Player currentPlayer;
	private PrisonController prisonController = new PrisonController(gui);
	private HouseController houseController;
	Player[] player;	

	
	public Game() {
	gui.createField();

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
	
	
	player = new Player[playerAmount];
	
	gui.createPlayers(playerAmount, player);

	}
	
	public void run() {
		

		// The game continues as long as won equals false
		while (!won) {
			//Goes through the player[]
			for (int i = 0; i < player.length; i++) {
				
				//If the player is not dead, he can have a turn!
				if (!player[i].getDeathStatus()) {
					
					//Sets currentPlayer object
					currentPlayer = player[i];
					
					//Shows message for the player having current turn, might have option to buy houses, or option to throw dice
					playerTurnMessage(currentPlayer, gameboard);
					
					//Throws dice in Dice class, meaning generating random numbers stored in Dice.
					dice.throwDice();							
					
					if(currentPlayer.getPrisonTurns() == 0) {
						movePlayer(currentPlayer, dice);
					}
					
					//Check if player passed start field, gives him passStartMoney in case
					checkIfPlayerPassedStart(currentPlayer, dice.getSum());
					
					if(currentPlayer.getPrisonTurns() > 0) {
						prisonController.prisonDialog(currentPlayer, dice);
					}				
			
					//Check if the field is ownable, used for depositing money on Refuge
					//Check if the field is ownable 
					gameboard.landOnField(currentPlayer);

					// If a player has lost, adds one to lostCount and reset the players owned fields
					checkIfPlayerLost(currentPlayer, player);
			
					//Checks if one player has won in the player array
					checkIfPlayerWon(player);					

				}
			}
		}	
	}	
		
	public void playerTurnMessage(Player currentPlayer, GameBoard gameboard) {
			if(gameboard.canPlayerBuyHouses(currentPlayer)) {
				if(gui.optionToBuyHouse().equals("Køb hus")) {
					houseController = new HouseController(gui, gameboard, currentPlayer); //Sets variables for housecontroller to use
					houseController.buyHousesOption();
				}
			} else {
				//Shows message for what player has turn
				gui.throwDiceOptionOnly(currentPlayer);
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

	
	public void checkIfPlayerLost( Player currentPlayer, Player[] player) {
		if (currentPlayer.getDeathStatus()) {
			//If the player is dead, remove them from the board and reset the fields owned
			gui.removePlayer(currentPlayer);			
			gameboard.resetOwnedFields(currentPlayer);
			lostCount++;
		}		
	}
	
	private void checkIfPlayerWon(Player[] player) {
		// If only one player is left, won is set to true
		if (lostCount == playerAmount - 1) {
			won = true;
			gui.showWin(player, playerAmount);
		}	
	}

	public void checkIfPlayerPassedStart(Player player, int diceSum) {
		if (!(diceSum + player.getPreviousPosition() == player.getPosition()) && (player.getPrisonTurns() == 0)) {
				player.account.addPoints(passStartMoney);
				gui.passedStart(player, passStartMoney);
				gui.updateBalance(player);	
			}
			
		}
}
