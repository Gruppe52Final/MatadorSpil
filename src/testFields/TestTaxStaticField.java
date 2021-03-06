package testFields;

import static org.junit.Assert.*;

import org.junit.Test;

import game.*;
import fields.*;

public class TestTaxStaticField {

	Player player = new Player("TestTaxField");
	Dice dice = new Dice();
	int taxAmount = 100;
	int taxAmount2 = 200;
	TaxStatic tax = new TaxStatic("Statsskat", taxAmount);
	TaxPercent taxPercentOption = new TaxPercent("Indkomstskat", taxAmount2);
	Game game = new Game();
	GameBoard gameBoard = new GameBoard(dice);
	
	@Test
	public void test() {
		/**
		 * Must be corrected so that player dies if he can't pay the 100 points
		 */
		//Testing if player loses 100 cash by landing on tax field 38 (statsskat gives minus 100 points)
		player.addRollToPosition(38);		
		assertEquals(player.getPosition(),38);		
		assertEquals(player.getScore(),1500);		
		tax.landOnField(player);
		
		//Test if player can pay, if they have enough money.		
		assertEquals(player.getScore(),(1500-taxAmount));
		
		//Test if player dies, if they have too little money.		
		player.setPoints(99);		
		tax.landOnField(player);		
		assertEquals(player.getDeathStatus(), true);
		
		
		//Test if player can have option to chose percent instead, on field 
		taxPercentOption.landOnField(player);		
	}

}
