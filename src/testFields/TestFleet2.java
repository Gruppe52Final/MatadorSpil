package testFields;

import static org.junit.Assert.*;

import org.junit.Test;

import fields.Fleet;
import fields.Refuge;
import fields.Territory;
import game.Dice;
import game.Game;
import game.GameBoard;
import game.Player;

public class TestFleet2 {

	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestParkingPlayer");
	Territory territory;
	Refuge refuge = new Refuge("Parkering");
	Fleet fleet = new Fleet("Helsingør-Helsingborg", 200, 70);
	Fleet fleet2 = new Fleet("Mols-Linien",  200, 70);
	Player playerLanding = new Player("LandingOnFleetField");
	int startingCash;
	
	int[] rent = fleet.getRent();
	
	
	@Test
	public void test() {
		/*
		 * Test what happens when owner lands on fleetfield
		 */
		
		startingCash = player.getScore();
		
		//Make player buy a fleet
		fleet.setOwner(player);
		player.addFleet();
		
		
		//Make sure player has one fleet
		assertEquals(player.getFleets(),1);
		
		//Make sure player is owner of fleet field
		assertEquals(player, fleet.getOwner());
		
		player.setPoints(startingCash);
		
//		Make owner player land on the fleet field
		fleet.landOnField(player,refuge);
		
		assertEquals(player.getScore(),startingCash);
		
	}

}
