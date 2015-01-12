//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;

import fields.Fields;
import boundary.MatadorGUI;
import boundary.Texts;


public class Game {

	private int playerAmount = 0;
	private int passStartMoney = 200;
	private MatadorGUI out = new MatadorGUI();
	private int lostCount = 0;
	private Dice dice = new Dice();
	private GameBoard gameboard = new GameBoard(dice);
	private boolean won = false;
	private Player currentPlayer;
//	private Fields currentField;
	Player[] player;	
//	private MatadorGUI out;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
	
	public Game() {
	out.createField();
	String language = out.selectLanguage(); // Makes game crash nullPointerException Field line 118

//	out.createTexts(language);
//	String language = "English";
 	if(language.equals("Dansk")) {
	 out = new MatadorGUI("Dansk");
 		} else if(language.equals("English")) {
 			out = new MatadorGUI("English");
		}
	}
	public void run() {
					
		//Gets input from player actor outside system boundary
		playerAmount = out.playerAmount();
		
		player = new Player[playerAmount];
		
		//GUI places player cars on board with their chosen names
		out.createPlayers(playerAmount, player);
		
		// The game continues as long as won equals false
		while (!won) {
			//Goes through the player[]
			for (int i = 0; i < player.length; i++) {
				
				//If the player is not dead, he can have a turn!
				if (!player[i].getDeathStatus()) {
					
					//Sets currentPlayer object
					currentPlayer = player[i];
					
					//Shows message for what player has turn
					out.nextPlayer(currentPlayer);
					
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
			
					// Get the current field the player lands on
//					currentField = gameboard.getField(currentPlayer.getPosition());
			
					//Check if the field is a territory (NOT IMPLEMENTED BELOW)
					gameboard.getField(currentPlayer.getPosition()).landOnField(currentPlayer);
			
					// If a player has lost, adds one to lostCount and reset the players owned fields
					checkIfPlayerLost(currentPlayer, player);
			
					//Checks if one player has won in the player array
					checkIfPlayerWon(player);
					
					//Remove justGotOutOfPrison on currentPlayer


			}
		}
	}	
}	
	public void movePlayer(Player player, Dice dice) {
		//Shows the dice on the GUI
		out.showDice(dice.getDice1(), dice.getDice2());

		//Updates the position variable inside player object
//		player.setPosition(player.getPosition() + dice.getSum());
		player.addRollToPosition(dice.getSum());
		
		//Updates the position of the cars on GUI
		out.updatePosition(player);
		
		currentPlayer.setJustOutOfPrison(false);
		
	}

	public void prisonDialog(Player currentPlayer, Dice dice) {
		boolean payOutOfPrison = false;
		payOutOfPrison = out.payOutOfPrison(currentPlayer);
		if(payOutOfPrison) {				
			//Check if player has enough money to actually pay himself out...	
			
			//If he has more than 100 points, let him out and subtract the points
			if (currentPlayer.account.getScore() >= 100) {
				currentPlayer.setPrisonTurns(0);
				//Subtract 100 points from players account
				currentPlayer.account.subtractPoints(100);	
				currentPlayer.setJustOutOfPrison(true);				
				//Update GUI
				out.updateBalance(currentPlayer);
				
				//If he doesn't have enough, tell him this in GUI.
				} else if (currentPlayer.account.getScore() < 100) {					
					out.cantPayOutOfPrison(currentPlayer);
				}
			//If player chooses not to pay bail, or doesn't have enough money, we throw the dice.
			} else if(!payOutOfPrison || (currentPlayer.account.getScore() < 100)) {
				//Shows the dice on the GUI
				out.showDice(dice.getDice1(), dice.getDice2());
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
			out.removePlayer(currentPlayer);			
			gameboard.resetOwnedFields(currentPlayer);
			lostCount++;
		}		
	}
	
	private void checkIfPlayerWon(Player[] player) {
		// If only one player is left, won is set to true
		if (lostCount == playerAmount - 1) {
			won = true;
			out.showWin(player, playerAmount);
		}	
	}

	public void checkIfPlayerPassedStart(Player player, int diceSum) {
		if (!(diceSum + player.getPreviousPosition() == player.getPosition()) && (player.getPrisonTurns() == 0)) {
				player.account.addPoints(passStartMoney);
				out.passedStart(player, passStartMoney);
				out.updateBalance(player);	
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
