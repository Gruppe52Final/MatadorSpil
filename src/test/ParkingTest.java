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
		
		System.out.println(player.account.getScore());
		
		//Places player on board
		territory.landOnField(player, refuge);
		
		System.out.println(territory.getPrice());
		
		assertEquals(player.account.getScore(),(1500 - territory.getPrice()));
				
		//Make sure that player is now owner
		assertEquals(territory.getOwner(), player);
		
		//Set variable for money in the beginning
		int startBonus = refuge.getStartBonus();
		int playerStartMoney = player.account.getScore();
		
		//Make sure getPoints has been raised in Refuge,
		// because of player buying a property		
		assertNotEquals(startBonus,refuge.account.getScore());
		
		//Let's see if player receives the bonus when he goes on refuge
		refuge.landOnField(player);
		
		int bonus = refuge.account.getScore();
		
		//Lets make sure the bonus is not the default 50,
		// but that something has been added from the previous buy
		assertNotEquals(bonus,50);
		
		//Lets see if the player received the bonus
		assertEquals(player.account.getScore(),bonus + playerStartMoney);
		assertEquals(player.account.getScore(),1424);
		System.out.println(player.account.getScore());

	}
}
