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
		
		//Places player on board
		gameBoard.getField(13).landOnField(player);
		
		//make territory object
		territory = (Territory) gameBoard.getField(13);
		
		//Make sure that player is now owner
		assertEquals(territory.getOwner(), player);
		
		//Check if bonus has been raised on the Refuge field (also refered as Parking in game)
		int startBonus = refuge.getStartBonus();
		
		//Make sure getPoints in account in refuge is same as startBonus
		assertEquals(refuge.getStartBonus(),refuge.account.getScore());
		
	}

}
