package test;

import static org.junit.Assert.*;
import game.*;
import fields.*;

import org.junit.Test;

public class TestPrison {
	
	Player player = new Player("TestPrison");
	GoToPrison goToPrisonField = new GoToPrison("Jail");
	int startingCash = player.account.getScore(); 
	Game game = new Game();
	Dice dice;
	
	@Test
	public void test() {
		//Test if player goes to field[10] after being arrested on field[30]
		
		//Make sure player is starting on field 0
		assertEquals(player.getPosition(),0);
		
		//Now put player on the goToPrisonField, should move him to field 10.
		goToPrisonField.landOnField(player);
		
		//Is he really on field 10 now ?
		assertEquals(player.getPosition(),10);
		
		//Ok, so now player gets moved from field 30 to field 10
		//But does he also NOT receive start cash?
		
		//We run the checkIfPlayerPassedStart to see if he can have start cash
		game.checkIfPlayerPassedStart(player, 5); //5 is just a random dicethrow
		
		//So does it still have the same cash as when the player object was created?
		assertEquals(player.account.getScore(), startingCash);
		
		//Is player in prison now ?
		assertEquals(player.getPrisonTurns(),3);
		
		//Check YES to pay out of prison!		
		game.prisonDialog(player);
		
		//Does the player go on as usual with dices from field 10, after paying out ?
		
		//We add a dice throw
		player.addRollToPosition(5);
		
		//Players position should be dicethrow plus the field[10] position
		assertEquals(player.getPosition(),15);
		
		//Has the player been subtracted 100 points?
		assertEquals(player.account.getScore(), 1400);
		
		//Does Player also move the diceThrow after field[10], if he chooses to throwDice, instead of paying ?
		
//		//Move player back to prison again
//		goToPrisonField.landOnField(player);
//		
//		//Choose No, to throw dice
//		game.prisonDialog(player);
		
		//Sets dice, need to comment out dice.Throw() in game.prisonDialog() for this to work......
//		dice.setDice1(6);
//		dice.setDice2(6);
		
		//Is player now on field[16] ?
//		assertEquals(player.getPosition(),16);
		
		//Keep trying till we have same eyes
//		while(dice.getDice1() != dice.getDice2()) {
//			game.prisonDialog(player);
//		}
//		assertEquals(player.getPosition, )
		
	}

}
