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
public class TestParking {
	
	Dice dice = new Dice();
	GameBoard gameBoard = new GameBoard(dice);
	Game game = new Game();
	Player player = new Player("TestParkingPlayer");
	Territory territory;
	Refuge refuge;
	LaborCamp laborCamp = new LaborCamp("Tuborg", 150, 100, dice);
	Fleet fleet = new Fleet("Helsingør-Helsingborg", 200);
	
	
	@Test
	public void test() {
		
		/**
		 * Test if Parking/Refuge receives money when buying territory
		 */
		
		//make territory object
		territory = (Territory) gameBoard.getField(13);
		
		//make refuge object
		refuge = (Refuge) gameBoard.getField(20);
			
		//Places player on board
		territory.landOnField(player, refuge);
		
		assertEquals(player.account.getScore(),(1500 - territory.getPrice()));
				
		//Make sure that player is now owner
		assertEquals(territory.getOwner(), player);
		
		//Set variable for money in the beginning
		int startBonus = refuge.getStartBonus();
		int playerStartMoney = player.account.getScore();
		
		//Make sure getPoints has been raised in Refuge,
		// because of player buying a property		
		assertNotEquals(startBonus,refuge.account.getScore());
		
		int bonus = refuge.account.getScore();
		
		//Lets make sure the bonus is not the default 50,
		// but that something has been added from the previous buy
		assertNotEquals(bonus,50);
		
		//Let's see if player receives the bonus when he goes on refuge
		refuge.landOnField(player);
		

		
		//Lets see if the player received the bonus
		assertEquals(player.account.getScore(),bonus + playerStartMoney);
		assertEquals(player.account.getScore(),1424);
		
		/**
		Test if parking receives money when you buy a LaborCamp
		**/
		
		

		//Make player land on laborCamp, buy it
		laborCamp.landOnField(player, refuge);

		System.out.println(laborCamp.getOwner());
		//Test if player is now owner of laborcamp
		assertEquals(laborCamp.getOwner(),player);
		
		//Test if Refuge has received money now
		assertEquals(refuge.account.getScore(),65);
		
		/*
		 * Test if parking receives money when you buy Fleet field
		 */
		
		//Make player land on Fleet field, buy it 
		fleet.landOnField(player,refuge);
		
		//Is player owner of the fleet field now?
		assertEquals(fleet.getOwner(),player);
		
		//Test if Refuge has received money now
		assertEquals(refuge.account.getScore(),85);
	}
}
