package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.*;
import fields.*
;
/**
 * Test if parking receives bonus when a player buys a field
 * @author 52
 *
 */
public class ParkingTest {
	
	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestParkingPlayer");
	Territory territory;
	Refuge refuge;
	

	
	@Test
	public void test() {
		
		//make territory object
		territory = (Territory) gameBoard.getField(13);
		
		//make refuge object
		refuge = (Refuge) gameBoard.getField(20);
		
		//Places player on board
		territory.landOnField(player, refuge);
				
		//Make sure that player is now owner
		assertEquals(territory.getOwner(), player);
		
		//Set variable for money in the beginning
		int startBonus = refuge.getStartBonus();
		
		//Make sure getPoints has been raised in Refuge,
		// because of player buying a property		
		assertNotEquals(startBonus,refuge.account.getScore());
		
		System.out.println(territory.getClass());
	}

}
