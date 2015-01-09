//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;

import fields.Fields;
import boundary.MatadorGUI;

public class Game {

	private int playerAmount = 0;
	private int passStartMoney = 200;
	private MatadorGUI out = new MatadorGUI();
	private int lostCount = 0;
	private Dice dice = new Dice();
	private GameBoard gameboard = new GameBoard(dice);
	private boolean won = false;
	private Player currentPlayer;
	private Fields currentField;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

	public void run() {
	
		Player[] player;	

//		System.out.println(gameboard.toString()); //This gives nullPointerError, but why do we need it anyway ?
		out.createField();
		
		
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
					
					if(player[i].prisonTurns > 0) {
						out.arrestedMessage(currentPlayer);
						player[i].setPosition(40);
//						out.updatePosition(player[i]);
					}

					//Throws dice in Dice class, meaning generating random numbers stored in Dice.
					dice.throwDice();
					
					//Shows the dice on the GUI
					out.showDice(dice.getDice1(), dice.getDice2());
				
					//Updates the position variable inside player object
					currentPlayer.setPosition(dice.getSum());
					
					//Updates the position of the cars on GUI
					out.updatePosition(currentPlayer);
					
					//Check if player passed start field, gives him passStartMoney in case
					checkIfPlayerPassedStart(currentPlayer, dice.getSum());
					
					// Get the current field the player lands on
					currentField = gameboard.getField(currentPlayer.getPosition());
					
					//Check if the field is a territory (NOT IMPLEMENTED BELOW)
					gameboard.getField(currentPlayer.getPosition()).landOnField(currentPlayer);
					
					// If a player has lost, adds one to lostCount and reset the players owned fields
					checkIfPlayerLost(currentPlayer, player);
					
					//Checks if one player has won in the player array
					checkIfPlayerWon(player);
				}
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
			out.updateBalance(player.getName(), player.account.getScore());
		}
	}
//	private void inPrison(Player player, int diceSum){
//		currentPlayer.
//	}
}
