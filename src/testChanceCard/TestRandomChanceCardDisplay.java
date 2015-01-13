package testChanceCard;

import fields.Chance;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestRandomChanceCardDisplay {
	
	private Dice dice = new Dice();
	private GameBoard gameBoard = new GameBoard(dice);
	private Game game = new Game();
	private Player player1 = new Player("TestChanceCardPlayer");
	private MatadorGUI gui = new MatadorGUI();
	int startingCash = player1.account.getScore();
	private Chance chanceCards = new Chance();

	@Test
	public void test() {
		/**
		 * Test if a random chanceCard is displayed
		 */
		
		//Set position for landOnField input
		player1.setPosition(7);
		
		//Set player on chanceField 
		gameBoard.landOnField(player1);
		
		gui.debugStopGUIForChanceCard();
		
		
		
		
	}

}
