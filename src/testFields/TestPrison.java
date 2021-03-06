package testFields;

import static org.junit.Assert.assertEquals;
import fields.GoToPrison;
import game.Dice;
import game.Game;
import game.PassStartCheck;
import game.Player;
import game.PrisonController;

import org.junit.Test;

import boundary.MatadorGUI;

public class TestPrison {
	
	Player player = new Player("TestPrison");
	GoToPrison goToPrisonField = new GoToPrison("Jail");
	int startingCash = player.getScore(); 
	Game game = new Game();
	Dice dice = new Dice();
	MatadorGUI gui = new MatadorGUI();
	PrisonController prisonController = new PrisonController(gui);
	PassStartCheck passStartCheck = new PassStartCheck();
	@Test
	public void test() {
		/**
		 * Inscructions for succesfull test...
		 * 1. Press "Yes" first time
		 * 2. Press "No" afterwards everytime
		 * If the test fails, then some code has been broken....
		 */
		//Test if player goes to field[10] after being arrested on field[30]
		
		//Make sure player is starting on field 0
		assertEquals(player.getPosition(),0);
		
		//Now put player on the goToPrisonField, should move him to field 10.
		goToPrisonField.landOnField(player);
		
		//Is he really on field 10 now ?
		assertEquals(player.getPosition(),10);
		
		//Ok, so now player gets moved from field 30 to field 10
		//But does he also NOT receive start cash?
		
		assertEquals(player.getPrisonTurns(),3);
		
		//We run the checkIfPlayerPassedStart to see if he can have start cash
		passStartCheck.checkIfPlayerPassedStart(player, 10); //5 is just a random dicethrow
		
		//So does it still have the same cash as when the player object was created?
		assertEquals(player.getScore(), startingCash);
		
		//Is player in prison now ?
		assertEquals(player.getPrisonTurns(),3);
		
		
		//1,2 just artificial dice numbers, not used in this test for payout
		dice.setDice1(1);
		dice.setDice2(2);
		//Check YES to pay out of prison!		
		prisonController.prisonDialog(player, dice);		
		
		//Does the player go on as usual with dices from field 10, after paying out ?
		
		//We add a dice throw
		player.addRollToPosition(5);
		
		//Players position should be dicethrow plus the field[10] position
		assertEquals(player.getPosition(),15);
		
		//Has the player been subtracted 100 points?
		assertEquals(player.getScore(), 1400);
		
		//Is player prisonturns 0 now?
		assertEquals(player.getPrisonTurns(),0);
		
//		Does Player also move the diceThrow after field[10],
//		if he chooses to throwDice, instead of paying ?
		
		//Move player back to prison again
		goToPrisonField.landOnField(player);

		//Is player in prison now ?
		assertEquals(player.getPrisonTurns(),3);
		
		//Let's test diceThrow functionality now
		
		//Set the dice to be same eyes
		dice.setDice1(1);
		dice.setDice2(1);
		
		//Choose No, to test throwing dice
		prisonController.prisonDialog(player, dice);
		
		//Is player out of prison now ?
		assertEquals(player.getPrisonTurns(),0);
		
		//Is player position on field 10 ?
		assertEquals(player.getPosition(),10);
		
		//Set currentPlayer object in game
//		game.setCurrentPlayer(player);
				
		//Move currentPlayer - somehow this doesn't affect the player objects position ?
		game.movePlayer(player, dice);
		
		//Is diceSum 2 ?
		assertEquals(dice.getSum(),2);
		
		//Get currentPlayer back from game
//		player = game.getCurrentPlayer();
		
		//Has player been moved exactly two fields now ?
		assertEquals(player.getPosition(),12);
		
		//Last test: Does player have three prison turns before being thrown out?
		goToPrisonField.landOnField(player);
		
		//Make sure player has three prison turns
		assertEquals(player.getPrisonTurns(),3);
		
		//Make dices different
		dice.setDice1(1);
		dice.setDice2(5);
		
		//Three dice throws
		prisonController.prisonDialog(player, dice);
		assertEquals(player.getPrisonTurns(),2);
		prisonController.prisonDialog(player, dice);
		assertEquals(player.getPrisonTurns(),1);
		prisonController.prisonDialog(player, dice);
		assertEquals(player.getPrisonTurns(),0);
		
		//Give player a turn
		game.movePlayer(player, dice);
		
		//Has player moved 6 fields? He should be at field[16] now
		assertEquals(player.getPosition(),16);

		
	}

}
