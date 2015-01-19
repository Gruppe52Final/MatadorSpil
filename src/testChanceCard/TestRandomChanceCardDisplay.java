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
	private Player player1 = new Player("TestChanceCardPlayer");
	private MatadorGUI gui = new MatadorGUI();
	int startingCash = player1.getScore();
	private Chance chanceCards = new Chance("Dansk");
	private GameBoard gameBoard = new GameBoard(dice);

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
