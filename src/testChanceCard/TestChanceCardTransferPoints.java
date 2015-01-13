package testChanceCard;

import static org.junit.Assert.assertEquals;
import fields.Chance;
import fields.ChanceCards;
import fields.ChanceTransferPoints;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestChanceCardTransferPoints {
	
	private Dice dice = new Dice();
	private GameBoard gameBoard = new GameBoard(dice);
	private Game game = new Game();
	private Player player1 = new Player("TestChanceCardPlayer");
	private MatadorGUI gui = new MatadorGUI();
	int startingCash = player1.account.getScore();
	private Chance chanceField = new Chance();
	ChanceCards[] chanceCards;
	int randomInt;
	@Test
	public void test() {
		/**
		 * Display a a random ChanceTransferPoints
		 */
		randomInt = chanceField.genRandomInt();
		
		//Initialize card list
		chanceCards = chanceField.getChanceCards();
		
			
		//Test all subtractPoints cards
		for (int i = 0; i < 1; i++) {
			chanceCards[i].activate(player1);
			
			//Has player been deducted points .. ?
			assertEquals(player1.account.getScore(), (startingCash - ((ChanceTransferPoints) chanceCards[i]).getAmount()));
			
			//Reset player points
			player1.account.setPoints(startingCash);
		}
		
		
		
	}

}
