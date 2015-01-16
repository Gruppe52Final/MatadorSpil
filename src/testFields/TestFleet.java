package testFields;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

public class TestFleet {

	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestParkingPlayer");
	Territory territory;
	Refuge refuge;
	Fleet fleet = new Fleet("Helsingør-Helsingborg", 200);
	Fleet fleet2 = new Fleet("Mols-Linien",  200);
	Player playerLanding = new Player("LandingOnFleetField");
	int startingCash;
	
	int[] rent = fleet.getRent();
	@Test
	public void test() {
		/*
		 * Test if owning one fleet field deducts money and transfer money
		 */
		
		startingCash = player.account.getScore();
		
		//Make player buy a fleet
		fleet.setOwner(player);
		player.addFleet();
		
		//Make sure player has one fleet
		assertEquals(player.getFleets(),1);
		
		//Make one player land on the fleet field
		fleet.landOnField(playerLanding,refuge);
		
		//Has the player now been deducted rent_1 ?
		assertEquals((startingCash - rent[0]), playerLanding.account.getScore());
		
		//Has the owner got 25 point?
		assertEquals(player.account.getScore(), (startingCash + rent[0]));
		
		//Transfer rent back to landingPlayer
		playerLanding.account.addPoints(rent[0]);
		
		//Reset owners money
		player.account.setPoints(startingCash);
		

		
		
		/**
		 * Test if owning two fleets increases the rent
		 */
		
		startingCash = player.account.getScore();
		
		//What if the player owns two fleets?
		fleet2.setOwner(player);
		player.addFleet();
		

		assertEquals(player.getFleets(),2);
		
		assertEquals(playerLanding.account.getScore(),1500);
		
		//Make the poor player land on the fleet field again
		fleet.landOnField(playerLanding, refuge);
		
		System.out.println(startingCash + " startingCash," + rent[1] + " rent[1]");
		
		//Has the player now been deducted even more rent ?
		assertEquals((startingCash - rent[1]), playerLanding.account.getScore());
		
		//Has the owner now got 50 points ?
		assertEquals(player.account.getScore(), (startingCash + rent[1]));
		
		//Transfer rent back to landingPlayer
		playerLanding.account.addPoints(rent[0]);
		
		//Reset owners money
		player.account.setPoints(startingCash);
		
		/**
		 * Test if owning three fleets increases the rent
		 */
		
		startingCash = player.account.getScore();
		

		fleet2.setOwner(player);
		player.addFleet();
		

		assertEquals(player.getFleets(),3);
		
		
		playerLanding.account.setPoints(1500);
		
		//Make the poor player land on the fleet field again
		fleet.landOnField(playerLanding, refuge);
		
		System.out.println(startingCash + " startingCash," + rent[2] + " rent[2]");
		
		//Has the player now been deducted even more rent ?
		assertEquals((startingCash - rent[2]), playerLanding.account.getScore());
		
		//Has the owner now got 50 points ?
		assertEquals(player.account.getScore(), (startingCash + rent[2]));
		
		//Transfer rent back to landingPlayer
		playerLanding.account.addPoints(rent[0]);
		
		//Reset owners money
		player.account.setPoints(startingCash);
		
		/**
		 * Test if owning four fleets increases the rent
		 */
		
		startingCash = player.account.getScore();
		

		fleet2.setOwner(player);
		player.addFleet();
		

		assertEquals(player.getFleets(),4);
		
		
		playerLanding.account.setPoints(1500);
		
		//Make the poor player land on the fleet field again
		fleet.landOnField(playerLanding, refuge);
		
		System.out.println(startingCash + " startingCash," + rent[3] + " rent[3]");
		
		//Has the player now been deducted even more rent ?
		assertEquals((startingCash - rent[3]), playerLanding.account.getScore());
		
		//Has the owner now got 50 points ?
		assertEquals(player.account.getScore(), (startingCash + rent[3]));
		
		//Transfer rent back to landingPlayer
		playerLanding.account.addPoints(rent[0]);
		
		//Reset owners money
		player.account.setPoints(startingCash);
		
	}

}
