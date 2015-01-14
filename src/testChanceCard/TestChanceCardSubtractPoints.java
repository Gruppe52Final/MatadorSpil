package testChanceCard;

import static org.junit.Assert.assertEquals;
import fields.Chance;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

import org.junit.Test;

import chanceCards.ChanceCards;
import chanceCards.ChanceSubtractPoints;
import boundary.MatadorGUI;
import boundary.Texts;

public class TestChanceCardSubtractPoints {
	
	private Dice dice = new Dice();
	private Player player1 = new Player("TestChanceCardPlayer");
	private MatadorGUI gui = new MatadorGUI();
	int startingCash = player1.account.getScore();
	private Chance chanceField = new Chance("English");
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
		int startingIndex = 0;
		int endingIndex = 1;
		for (int i = startingIndex; i < endingIndex; i++) {
			chanceCards[i].activate(player1);
			
			//Has player been deducted points .. ?
			assertEquals(player1.account.getScore(), (startingCash - ((ChanceSubtractPoints) chanceCards[i]).getAmount()));
			
			//Reset player points
			player1.account.setPoints(startingCash);
		}
		
		
		
	}

}
