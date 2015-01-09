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
	
	@Test
	public void test() {
		//Test if player goes to field[10] after being arrested on field[30]
		
		//Make sure player is starting on field 0
		assertEquals(player.getPosition(),0);
		
		//Now put player on the goToPrisonField, should move him to field 10.
		goToPrisonField.landOnField(player);
		
		//Is he really on field 10 now ?
		assertEquals(player.getPosition(),11);
		
		//Ok, so now player gets moved from field 30 to field 10
		//But does he also NOT receive start cash?
		
		//We run the checkIfPlayerPassedStart to see if he can have start cash
		game.checkIfPlayerPassedStart(player, 5); //5 is just a random dicethrow
		
		//So does it still have the same cash as when the player object was created?
		assertEquals(player.account.getScore(), startingCash);
		
		
	}

}
