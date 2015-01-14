//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;


import boundary.MatadorGUI;



public class Game {

	private int playerAmount = 0;
	private int passStartMoney = 200;
	private MatadorGUI gui = new MatadorGUI(); //This is set now so ChanceCard is not giving nullpoint error
	private int lostCount = 0;
	private Dice dice = new Dice();
	private GameBoard gameboard;
	private boolean won = false;
	private Player currentPlayer;
	Player[] player;	

	
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		game.run();
	}
	
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
	public void setPlayers(Player[] player) {
		this.player = player;
	}
	
	public void setPlayerAmount(int playerAmount) {
		this.playerAmount = playerAmount;
	}
	
	public void createPlayers() {
		//GUI places player cars on board with their chosen names
		gui.createPlayers(playerAmount, player);
			
	}
	
	public void setCars() {
		gui.setCars(player);
	}
	
	public void init() {
		
	//Gets input from player actor outside system boundary
	playerAmount = gui.playerAmount();
	
	player = new Player[playerAmount];

	}
	
	public void run() {
		
		createPlayers();
		
		// The game continues as long as won equals false
		while (!won) {
			//Goes through the player[]
			for (int i = 0; i < player.length; i++) {
				
				//If the player is not dead, he can have a turn!
				if (!player[i].getDeathStatus()) {
					
					//Sets currentPlayer object
					currentPlayer = player[i];
					
					//Shows message for what player has turn
					nextPlayer(currentPlayer);
					
					//Throws dice in Dice class, meaning generating random numbers stored in Dice.
					dice.throwDice();							
					
					if(currentPlayer.getPrisonTurns() == 0) {
						movePlayer(currentPlayer, dice);
					}
					
					//Check if player passed start field, gives him passStartMoney in case
					checkIfPlayerPassedStart(currentPlayer, dice.getSum());
					
					if(currentPlayer.getPrisonTurns() > 0) {
						prisonDialog(currentPlayer, dice);
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
	public void nextPlayer(Player currentPlayer) {		
			//currentPlayer.OwnsTerritoryGroup
			if(currentPlayer.canBuyHouses()) {
				if(gui.optionToBuyHouse().equals("Køb hus")) {
					gui.setHouse(gui.choosePropertyToHouse(currentPlayer),gui.chooseNumberOfHousesToBuy(), gameboard);
				}
			} else {
				//Shows message for what player has turn
				gui.nextPlayer(currentPlayer);
			}
	}
	
	public void movePlayer(Player player, Dice dice) {
		//Shows the dice on the GUI
		gui.showDice(dice.getDice1(), dice.getDice2());

		//Updates the position variable inside player object
//		player.setPosition(player.getPosition() + dice.getSum());
		player.addRollToPosition(dice.getSum());
		
		//Updates the position of the cars on GUI
		gui.updatePosition(player);
		
//		currentPlayer.setJustOutOfPrison(false);
		
		
		
	}

	public void prisonDialog(Player currentPlayer, Dice dice) {
		boolean payOutOfPrison = false;
		payOutOfPrison = gui.payOutOfPrison(currentPlayer);
		if(payOutOfPrison) {				
			//Check if player has enough money to actually pay himself out...	
			
			//If he has more than 100 points, let him out and subtract the points
			if (currentPlayer.account.getScore() >= 100) {
				currentPlayer.setPrisonTurns(0);
				//Subtract 100 points from players account
				currentPlayer.account.subtractPoints(100);	
				currentPlayer.setJustOutOfPrison(true);				
				//Update GUI
				gui.updateBalance(currentPlayer);
				
				//If he doesn't have enough, tell him this in GUI.
				} else if (currentPlayer.account.getScore() < 100) {					
					gui.cantPayOutOfPrison(currentPlayer);
				}
			//If player chooses not to pay bail, or doesn't have enough money, we throw the dice.
			} else if(!payOutOfPrison || (currentPlayer.account.getScore() < 100)) {
				//Shows the dice on the GUI
				gui.showDice(dice.getDice1(), dice.getDice2());
				//If both dice are equal, he's out of prison
				if (dice.getDice1() == dice.getDice2()) {
					currentPlayer.setPrisonTurns(0);

					currentPlayer.setJustOutOfPrison(true);

				} else {
					currentPlayer.setPrisonTurns(currentPlayer.getPrisonTurns() - 1);
				}
			}
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
	
	public Dice getDice() {
		return dice;
	}
	
	//Used for TestPrison.java purpose
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
	}
	//Also used for testing purposes
	public Player getCurrentPlayer() {
	return currentPlayer;
	}
}
