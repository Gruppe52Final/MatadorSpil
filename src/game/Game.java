//********************************************************************
//  Main.java       Authors: Group 57
//
//  The main class in CDIO part 2 to start and end the game
//********************************************************************

package game;

import boundary.MatadorGUI;

public class Game {

	int currentPlayer = 0;
	int playerAmount = 0;
	private int passStartMoney = 4000;

	public static void main(String[] args) {
		Game game = new Game();
		game.run();

	}

	public void run() {

		boolean won = false;
		Dice dice = new Dice();
		GameBoard gameboard = new GameBoard(dice);
		Player[] player;
		MatadorGUI out = new MatadorGUI();
		int lostCount = 0;

//		System.out.println(gameboard.toString()); //This gives nullPointerError, but why do we need it anyway ?
		out.createField();
		
		// Takes a chosen number and creates that amount of players
		playerAmount = out.playerAmount();
		player = new Player[playerAmount];

		out.createPlayers(playerAmount, player);
		

		
		// The game continues as long as won equals false
		while (!won) {
			if (!player[currentPlayer].getStatus()) {

				out.nextPlayer(player, currentPlayer);
				dice.throwDice();
				out.showDice(dice.getDice1(), dice.getDice2());
			
				//Updates the position variable inside player object
				player[currentPlayer].setPosition(dice.getSum());
				
				//Updates the position of the cars on GUI
				out.updatePosition(player, currentPlayer);
				
				//Check if player passed start field, gives him passStartMoney in case
				checkIfPlayerPassedStart(player[currentPlayer], dice.getSum(), out);
				
				// Execute landOnField for the players new position
				gameboard.getField(player[currentPlayer].getPosition()).landOnField(player[currentPlayer]);
				
				//Updates the position of the cars on GUI
				out.updatePosition(player, currentPlayer);
				
				// If a player has lost, adds one to lostCount and reset the players owned fields
				if (player[currentPlayer].getStatus()) {
					out.removePlayer(player, currentPlayer);
					
					gameboard.resetOwnedFields(player[currentPlayer]);
					lostCount++;
					
					// If only one player is left, won is set to true
					if (lostCount == playerAmount - 1) {
						won = true;
						out.showWin(player, playerAmount);
					}	
				}	
			}
			// Changes player
			changePlayer();
		}
	}
	// Method that changes turn
	public void changePlayer() {
		if (currentPlayer == playerAmount - 1) {
			currentPlayer = 0;
		} else {
			currentPlayer++;
		}
	}
	private void checkIfPlayerPassedStart(Player player, int diceSum, MatadorGUI out) {
		player.getPreviousPosition();
		if (!(diceSum + player.getPreviousPosition() == player.getPosition())) {
			player.account.addPoints(passStartMoney);
			out.passedStart(player, passStartMoney);
			out.updateBalance(player.getName(), player.account.getScore());
		}
	}
}